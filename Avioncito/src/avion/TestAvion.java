package avion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TestAvion {

	// Declaración del avión
	private Avion avion;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws AvionException {

		avion = new Avion();
		System.setOut(new PrintStream(outContent));

	}

	@Test
	public void testCrearAvion() {
		// Verificar que se crea el avión correctamente sin lanzar excepciones
		assertNotNull(avion);
	}

	@Test
	public void testAsientosCreados() {
		// Verificar que se crean los asientos correctamente
		if (avion != null) {
			assertEquals(4 * 4 + 29 * 6, avion.getAsientos().size());
		}
	}

	@Test(expected = AvionException.class)
	public void testCrearAvionExistente() throws AvionException {
		// Verificar que se lanza una excepción al intentar crear un avión cuando ya existe uno
		if (avion != null) {
			avion.crearAvion();
		}
	}

	@Test
	public void testAsientosPrecios() {
		// Verificar que los precios de los asientos son correctos
		if (avion != null) {
			// Obtener los asientos libres
			HashMap<String, AsientoLibre> asientosLibres = avion.getAsientosLibres();

			// Verificar que los precios de los asientos son correctos
			for (AsientoLibre asiento : asientosLibres.values()) {
				if (asiento.getNumAsiento() <= 4) {
					assertEquals(50.99, asiento.getPrecio(), 0.01);
				} else {
					assertEquals(25.99, asiento.getPrecio(), 0.01);
				}
			}
		}
	}

	@Test(expected = AsientoException.class)
	public void testComprobarAsientoNoValido() throws AsientoException {
		avion.comprobarAsiento("40A");
	}

	@Test
	public void asientoExistenteDisponible() {
		// 6A debería existir y estar disponible según la configuración inicial en setUp.
		String numAsiento = "6A";
		try {
			avion.comprobarAsiento(numAsiento);
			assertTrue("El asiento debería estar disponible.", avion.asientoDisponible(avion.getAsiento(numAsiento)));
		} catch (AsientoException e) {
			fail("No debería lanzar una excepción para un asiento existente y disponible.");
		}
	}

	@Test
	public void asientoExistenteNoDisponible() throws AsientoException {

		avion.reservarAsiento("5A", new Persona("12345678A", "Juan", "García", 30));
		// 5A ha sido reservado, por lo tanto no está disponible.
		String numAsiento = "5A";
		try {
			avion.comprobarAsiento(numAsiento);
			assertFalse("El asiento no debería estar disponible.", avion.asientoDisponible(avion.getAsiento(numAsiento)));
		} catch (AsientoException e) {
			fail("No debería lanzar una excepción para un asiento existente, aunque esté reservado.");
		}
	}

	@Test(expected = AsientoException.class)
	public void asientoNoExistente() throws AsientoException {
		// Probamos con un asiento que definitivamente no existe.
		String numAsiento = "100Z";
		avion.comprobarAsiento(numAsiento);
	}

	@Test
	public void testReservarBillete_AsientoOcupado() {
		// Reservar un asiento
		try {
			avion.reservarAsiento("1A", new Persona("12345678A", "Juan", "García", 30));
		} catch (AsientoException e) {
			fail("No debería lanzar una excepción al reservar un asiento disponible.");
		}

		// Intentar reservar el mismo asiento nuevamente
		try {
			avion.reservarAsiento("1A", new Persona("98765432B", "María", "López", 25));
			fail("Se esperaba una AsientoException al intentar reservar un asiento ya ocupado.");
		} catch (AsientoException e) {
			assertEquals("El asiento ya está ocupado", e.getMessage());
		}
	}



	@Test
	public void testComprarBillete_AsientoNoExiste() {
		try {
			// Intentar reservar un asiento que no existe
			avion.reservarAsiento("100A", new Persona("12345678A", "Juan", "García", 30));
			fail("Se esperaba una AsientoException");
		} catch (AsientoException e) {
			assertEquals("El asiento que quieres reservar no está en el rango informado", e.getMessage());
		}
	}

	@Test
	public void testComprarBillete_AsientoDisponible() {
		try {
			// Reservar un asiento
			avion.reservarAsiento("1A", new Persona("12345678A", "Juan", "García", 30));
			// Verificar que el asiento está reservado
			assertTrue(avion.getAsientos().get("1A").estaReservado());
		} catch (AsientoException e) {
			fail("No se esperaba una AsientoException");
		}
	}

	@Test
	public void reservarAsientosContiguosExitosamente() throws AsientoException {
		int cantidadBilletes = 3; // Cantidad de asientos a reservar
		avion.reservarVariosBilletes(cantidadBilletes, new Persona("12345678A", "Juan", "Perez", 30));
		// Verifica que los asientos han sido reservados.

	}

	@Test
	public void testReservarTodosAsientosDisponibles() {
	    try {
	        avion.reservarVariosBilletes(191, new Persona("12345678A", "Juan", "García", 30));
	        fail("Se esperaba una AsientoException porque no hay suficientes asientos disponibles.");
	    } catch (AsientoException e) {
	        assertEquals("No se encontraron suficientes asientos contiguos para reservar", e.getMessage());
	    }
	}

	@Test
	public void testReservarAlgunosAsientosDisponibles() {
	    try {
	        avion.reservarVariosBilletes(5, new Persona("12345678B", "María", "López", 25));
	        System.out.println("Reserva exitosa");
	    } catch (AsientoException e) {
	        fail("No debería lanzar una excepción si hay suficientes asientos disponibles.");
	    }
	}

	@Test
	public void testReservarTodosAsientosOcupados() {
	    // Reservamos todos los asientos
	    HashMap<String, Asiento> asientosMap = avion.getAsientos();
	    for (Asiento asiento : asientosMap.values()) {
	        asiento.reservar(new Persona("99999999Z", "Ana", "Martínez", 35));
	    }
	    
	    // Intentamos reservar más asientos
	    try {
	        avion.reservarVariosBilletes(5, new Persona("12345678C", "David", "Pérez", 40));
	        fail("Se esperaba una AsientoException porque todos los asientos ya están reservados.");
	    } catch (AsientoException e) {
	        assertEquals("No se encontraron suficientes asientos contiguos para reservar", e.getMessage());
	    }
	}

}










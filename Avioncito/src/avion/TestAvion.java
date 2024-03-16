package avion;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAvion {
	
	Avion a1 = new Avion();
	Persona p;
	
	@BeforeEach
	void crearAvion() throws AvionException {
		a1.crearAvion();	
		p = Persona.crearPersona();;
	}
	
	@Test
	void testExcepcionCrearAvion() {
		assertThrows(AvionException.class, ()->a1.crearAvion());
	}
			
	@Test
	void testTamañoAvion() {
		
		assertEquals(a1.avionAsientos.size(), 190);
		assertEquals(a1.asientosPrimera.size(), 16);
		assertEquals(a1.asientosTurista.size(), 174);
	}
	
	@Test
	void testReservarAsiento() throws AsientoException {
		
		AsientoOcupado as1 = new AsientoOcupado("1A", p);
		
		a1.reservarAsiento("1A", p);
		assertEquals(a1.asientosPrimera.get(0).getClass(), as1.getClass()); //Se comprueba que se reserva correctamente el asiento de P.C
		
		AsientoOcupado as2 = new AsientoOcupado("5A", p);
		a1.reservarAsiento("5A", p);
		assertEquals(a1.asientosTurista.get(0).getClass(), as2.getClass()); 
	}
	
	@Test
	void testExceptionReservarAsientoFueraRango() {
		
		assertThrows(AsientoException.class, ()->a1.reservarAsiento("55A", p));
		assertThrows(AsientoException.class, ()->a1.reservarAsiento("-55A", p));
	}
	
	@Test
	//Se comprueba el metodo "mostrarAvion"
	void testMostrarAvion() throws AvionException{
		
		//Inicializamos el avion
		Avion a1 = new Avion();
		
		//Como no tenemos el avion creado, nos saltara "AvionException"
		assertThrows(AvionException.class , ()->a1.mostrarAvion());
		
		//Creamos el avion
		a1.crearAvion();
		
		
		//Aqui no saltaria "AvionException" y deveria mostrar los asientos
	}
	
	@Test
	//Se comprueban los metodos "comprobarAsiento" y "reservarAsiento"
	void testComprobarAsientoYReservarAsiento() throws AsientoException, AvionException{
		
		//Inicializamos el avion
		Avion a1 = new Avion();
		
		//Creamos el avion
		a1.crearAvion();
		
		//Como no esta el nomre del asiento "47S" en el avion creado, nos saltara "AsientoException"
		assertThrows(AsientoException.class , ()->a1.comprobarAsiento("47S"));
		
		//Comprobamos si el asiento esta reservado, que no lo esta, porque, se acaba de crear el avion
		assertEquals(a1.asientosTurista.get(0).reservado, false);
		
		//Creamos una persona para reserbar el asiento
		Persona p = new Persona("1","1","1",1);
		//Reservamos el asiento
		a1.reservarAsiento("5a",p);
		
		//Al comprobar el asiento, ahora, estara reservado
		assertEquals(a1.asientosTurista.get(0).reservado, true);
		
	}
		
}

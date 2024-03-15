package avion;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestAvion {
	
	//IMPORTANTE------------------------------------------------------------------------
	//har algunos test que no funcionan porque no estan bien los throw esceptions
	//----------------------------------------------------------------------------------
	
	@Test
	//Se comprueba el metodo "crearAvion"
	void testCrearAvion() throws AvionException{
		
		//Inicializamos el avion
		Avion a1 = new Avion();
		
		//Creamos variables para comparar
		int testCapacidadMaxima = 174 ;
		ArrayList<Asiento> prueba= new ArrayList<Asiento>();
		
		//Comparamos que cuando inicializamos el avion, tiene 174 asientos
		assertEquals(testCapacidadMaxima , a1.capacidadMaxima);
		//Comparamos que cuando inicializamos el avion, tiene las variables "asientosPrimera", "asientosTurista" y "avionAsientos"; solo estan inicializadas.
		assertEquals(prueba, a1.asientosPrimera);
		assertEquals(prueba, a1.asientosTurista);
		assertEquals(prueba, a1.avionAsientos);
		
		//Creamos el avion
		a1.crearAvion();
		
		//Comparamos si las variables "asientosPrimera" esta inicializada.
		boolean iguales = a1.asientosPrimera.equals(prueba);
		assertEquals(false, iguales);//Como tienen datos dentro, sera falso
		
		//Comparamos si las variables "asientosTurista" esta inicializada.
		iguales = a1.asientosTurista.equals(prueba);//Como tienen datos dentro, sera falso
		assertEquals(false, iguales);
		
		//Comparamos si las variables "avionAsientos" esta inicializada.
		iguales = a1.avionAsientos.equals(prueba);//Como tienen datos dentro, sera falso
		assertEquals(false, iguales);
		
		//Como ya tenemos el avion creado, nos saltara "AvionException"
		assertThrows(AvionException.class , ()->a1.crearAvion());
		
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

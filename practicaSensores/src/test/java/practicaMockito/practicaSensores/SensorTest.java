package practicaMockito.practicaSensores;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SensorTest {
	GestorSensores gestor;

	@BeforeEach
	public void init() {
		gestor = new GestorSensores();
	}
	
	@AfterEach
	public void terminate() {
		gestor = null;
	}

	@Test
	public void inicialmenteElNumeroDeSensoresDelGestorEsCero() {
		//fail("Implemente este caso de prueba");
		assertEquals(0, gestor.getNumeroSensores());
	}

	@Test
	public void siSeBorraUnSensorNoExistenteSeElevaExcepcion() throws SensorExcepcion {
		//fail("Implemente este caso de prueba");
		assertThrows(SensorExcepcion.class, () -> gestor.borrarSensor("NoExisto"));
	}

	@Test
	public void siSeObtieneLaTemperaturaMediaEnUnGestorVacioSeElevaExcepcion() throws SensorExcepcion {
		//fail("Implemente este caso de prueba");
		assertThrows(SensorExcepcion.class, () -> gestor.getTemperaturaMedia());
	}

	// el numero maximo de sensores permitido es 100
	@Test
	public void siSeIntroduceUnSensorEnUnGestorLlenoSeElevaExcepcion() throws SensorExcepcion {
		int max_sensores = 100;
		for (int i = 0; i < max_sensores; i++) {
			ISensorTemperatura sensorMock = mock(ISensorTemperatura.class);
			gestor.introducirSensor(sensorMock);
		}
		assertEquals(gestor.getNumeroSensores(), max_sensores);

		ISensorTemperatura sensorMock = mock(ISensorTemperatura.class);
		Exception exception = assertThrows(SensorExcepcion.class, () -> gestor.introducirSensor(sensorMock));
	    assertEquals("No se puede introducir en un gestor de sensores lleno", exception.getMessage());
	}

	@Test
	public void siSeBorraUnSensorDelGestorSeDecrementaEnUnoElNumeroDeSensores() {
		//fail("Implemente este caso de prueba");
		ISensorTemperatura prueba = mock(ISensorTemperatura.class);
		when(prueba.getNombre()).thenReturn("prueba");
		gestor.introducirSensor(prueba);
		int nSensores = gestor.getNumeroSensores();
		gestor.borrarSensor("prueba");
		assertEquals(nSensores - 1, gestor.getNumeroSensores());
	}

	// se considera temperatura fuera de rango si la temperatura es menor que -90 o
	// mayor que 60
	@Test
	public void siAlgunSensorTieneTemperaturaFueraDeRangoObtenerLaTemperaturaMediaElevaUnaExcepcion() throws SensorExcepcion {
		//fail("Implemente este caso de prueba");
		ISensorTemperatura prueba = mock(ISensorTemperatura.class);
		when(prueba.getTemperaturaCelsius()).thenReturn((float)61);
		gestor.introducirSensor(prueba);
		assertThrows(SensorExcepcion.class, () -> gestor.getTemperaturaMedia());
		when(prueba.getTemperaturaCelsius()).thenReturn((float)-91);
		assertThrows(SensorExcepcion.class, () -> gestor.getTemperaturaMedia());
	}

	// prueba con tres valores a tu eleccion
	@Test
	public void laTemperaturaMediaDeTresSensoresObtenidaATravesDelGestorEsCorrecta() {
		//fail("Implemente este caso de prueba");
		ISensorTemperatura prueba = mock(ISensorTemperatura.class);
		when(prueba.getTemperaturaCelsius()).thenReturn((float)30);
		when(prueba.disponible()).thenReturn(true);
		ISensorTemperatura prueba2 = mock(ISensorTemperatura.class);
		when(prueba2.getTemperaturaCelsius()).thenReturn((float)30);
		when(prueba2.disponible()).thenReturn(true);
		ISensorTemperatura prueba3 = mock(ISensorTemperatura.class);
		when(prueba3.disponible()).thenReturn(true);
		when(prueba3.getTemperaturaCelsius()).thenReturn((float)30);
		
		gestor.introducirSensor(prueba3);
		gestor.introducirSensor(prueba2);
		gestor.introducirSensor(prueba);
		assertEquals(30, gestor.getTemperaturaMedia());
	}

	@Test
	public void siSeContactaTresVecesConSensoresDisponiblesNoSeBorraNinguno() {
		//fail("Implemente este caso de prueba");
		ISensorTemperatura prueba = mock(ISensorTemperatura.class);
		when(prueba.disponible()).thenReturn(true);
		gestor.introducirSensor(prueba);
		gestor.contactarSensores();
		assertEquals(1, gestor.getNumeroSensores());
	}

	@Test
	public void siSeContactaTresVecesConUnSensorNoDisponibleSeBorraDelGestor() {
		//fail("Implemente este caso de prueba");
		ISensorTemperatura prueba = mock(ISensorTemperatura.class);
		when(prueba.disponible()).thenReturn(false);
		gestor.introducirSensor(prueba);
		gestor.contactarSensores();
		gestor.contactarSensores();
		gestor.contactarSensores();
		assertEquals(0, gestor.getNumeroSensores());
	}
}
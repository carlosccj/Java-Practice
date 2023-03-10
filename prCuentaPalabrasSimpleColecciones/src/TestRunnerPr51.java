
//--------------------------------------------------------------------------
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

//--------------------------------------------------------------------------

import prCuentaPalabrasSimpleColecciones.*;

//--------------------------------------------------------------------------

public class TestRunnerPr51 {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestPalabraEnTexto {
		private PalabraEnTexto an1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of PalabraEnTexto JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of PalabraEnTexto JUnit Test");
		}
		@Before
		public void setUp() throws Exception {
			// Code executed before each test
			an1 = new PalabraEnTexto("palabra");
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void palabraEnTextoCtorTest1() {
			assertEquals("\n> Error: an1.toString():",
						 normalize("PALABRA: 1"),
						 normalize(an1.toString()));
		}
		@Test(timeout = 1000)
		public void palabraEnTextoCtorTest2() {
			assertTrue("\n> Error: PalabraEnTexto implements Comparable<?>:", ((Object)an1 instanceof Comparable<?>));
		}
		@Test(timeout = 1000)
		public void palabraEnTextoIncrementaTest2() throws Exception {
			an1.incrementa();
			assertEquals("\n> Error: an1.incrementa(); an1.toString():",
						 normalize("PALABRA: 2"),
						 normalize(an1.toString()));
		}
		@Test(timeout = 1000)
		public void palabraEnTextoEqualsTest1() throws Exception {
			PalabraEnTexto an2 = new PalabraEnTexto("palabra");
			assertTrue("\n> Error: an1.equals(an2): ", an1.equals(an2));
			assertTrue("\n> Error: an1.equals((Object)an2): ", an1.equals((Object)an2));
			an2.incrementa();
			assertTrue("\n> Error: an1.equals(an2): ", an1.equals(an2));
			//------------------------
			PalabraEnTexto an3 = new PalabraEnTexto("PALABRA");
			assertTrue("\n> Error: an1.equals(an3): ", an1.equals(an3));
			an3.incrementa();
			assertTrue("\n> Error: an1.equals(an3): ", an1.equals(an3));
			//------------------------
			PalabraEnTexto an4 = new PalabraEnTexto("otra palabra");
			assertFalse("\n> Error: an1.equals(an4): ", an1.equals(an4));
			//------------------------
			assertFalse("\n> Error: an1.equals(null): ", an1.equals(null));
			assertFalse("\n> Error: an1.equals(\"Esto es un String\"): ", an1.equals("Esto es un String"));
		}
		@Test(timeout = 1000)
		public void palabraEnTextoHashCodeTest1() throws Exception {
			int an1HashCode = an1.hashCode();
			//------------------------
			PalabraEnTexto an2 = new PalabraEnTexto("palabra");
			assertEquals("\n> Error: an2.hashCode(): ", an1HashCode, an2.hashCode());
			an2.incrementa();
			assertEquals("\n> Error: an2.hashCode(): ", an1HashCode, an2.hashCode());
			//------------------------
			PalabraEnTexto an3 = new PalabraEnTexto("PALABRA");
			assertEquals("\n> Error: an3.hashCode(): ", an1HashCode, an3.hashCode());
			an3.incrementa();
			assertEquals("\n> Error: an3.hashCode(): ", an1HashCode, an3.hashCode());
			//------------------------
			PalabraEnTexto an4 = new PalabraEnTexto("otra palabra");
			assertNotEquals("\n> Error: an4.hashCode(): ", an1HashCode, an4.hashCode());
		}
		@Test(timeout = 1000)
		public void palabraEnTextoCompareToTest1() throws Exception {
			PalabraEnTexto an2 = new PalabraEnTexto("palabra");
			assertEquals("\n> Error: an1.compareTo(an2): ", 0, an1.compareTo(an2));
			an2.incrementa();
			assertEquals("\n> Error: an1.compareTo(an2): ", 0, an1.compareTo(an2));
			//------------------------
			PalabraEnTexto an3 = new PalabraEnTexto("PALABRA");
			assertEquals("\n> Error: an1.compareTo(an3): ", 0, an1.compareTo(an3));
			an3.incrementa();
			assertEquals("\n> Error: an1.compareTo(an3): ", 0, an1.compareTo(an3));
			//------------------------
			PalabraEnTexto an4 = new PalabraEnTexto("PERRO");
			assertTrue("\n> Error: an1.compareTo(an4): ", an1.compareTo(an4) < 0);
			an4.incrementa();
			assertTrue("\n> Error: an1.compareTo(an4): ", an1.compareTo(an4) < 0);
			//------------------------
			PalabraEnTexto an5 = new PalabraEnTexto("PERRO");
			assertTrue("\n> Error: an5.compareTo(an1): ", an5.compareTo(an1) > 0);
			an5.incrementa();
			assertTrue("\n> Error: an5.compareTo(an1): ", an5.compareTo(an1) > 0);
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestContadorPalabras {
		private static final String[] inputData = {
			"Guerra tenia una jarra y Parra tenia una perra, ",
			"pero la perra de Parra rompio la jarra de Guerra.",
			"Guerra pego con la porra a la perra de Parra. ",
			"!Oiga usted buen hombre de Parra! ",
			"Por que ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
			"Guerra no hubiera pegado con la porra a la perra de Parra."
		};
		private static final String delimiters = "[ .,:;\\-\\!\\?]+";
		private ContadorPalabras cp1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of ContadorPalabras JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of ContadorPalabras JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			cp1 = new ContadorPalabras();
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void contadorPalabrasCtorTest1() {
			assertEquals("\n> Error: cp1.toString():",
						 normalize("[]"),
						 normalize(cp1.toString()));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasIncluyeTodasTest1() {
			cp1.incluyeTodas(inputData, delimiters);
			assertEquals("\n> Error: incluyeTodas() ; toString():",
						 normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
						 normalize(cp1.toString()));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasIncluyeTodasFicheroTest1() throws Exception {
			try {
				createFile("inputData.txt", inputData);
				cp1.incluyeTodasFichero("inputData.txt", delimiters);
				assertEquals("\n> Error: incluyeTodasFichero() ; toString():",
							 normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
							 normalize(cp1.toString()));
			} finally {
				deleteFile("inputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasEncuentraTest1() {
			cp1.incluyeTodas(inputData, delimiters);
			precond(normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
					normalize(cp1.toString()));
			assertEquals("\n> Error: cp1.encuentra(guerra):", new PalabraEnTexto("GUERRA"), cp1.encuentra("guerra"));
			assertEquals("\n> Error: cp1.encuentra(jarra):", new PalabraEnTexto("JARRA"), cp1.encuentra("jarra"));
			assertEquals("\n> Error: cp1.encuentra(roto):", new PalabraEnTexto("ROTO"), cp1.encuentra("roto"));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasEncuentraTest2() {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
						normalize(cp1.toString()));
				PalabraEnTexto pal = cp1.encuentra("xxx");
				fail("\n> Error: encuentra(xxx): No se lanzo ninguna excepcion");
			} catch (java.util.NoSuchElementException e) {
				//assertEquals("\n> Error: encuentra(xxx): exception.getMessage():", "No existe la palabra xxx", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: encuentra(xxx): la excepcion lanzada no es NoSuchElementException");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasEncuentraTest3() {
			try {
				PalabraEnTexto pal = cp1.encuentra("xxx");
				fail("\n> Error: encuentra(xxx): No se lanzo ninguna excepcion");
			} catch (java.util.NoSuchElementException e) {
				//assertEquals("\n> Error: encuentra(xxx): exception.getMessage():", "No existe la palabra xxx", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: encuentra(xxx): la excepcion lanzada no es NoSuchElementException");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasPresentaPalabrasPWTest1() throws Exception {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
						normalize(cp1.toString()));
				try (java.io.PrintWriter pw = new java.io.PrintWriter("outputData.txt")) {
					cp1.presentaPalabras(pw);
				}
				assertEquals("\n> Error: presentaPalabrasPW():",
							 normalize("A: 3 BUEN: 1 CON: 3 DE: 8 GUERRA: 5 HA: 1 HOMBRE: 1 HUBIERA: 2 JARRA: 3 LA: 10 NO: 2 OIGA: 1 PARRA: 7 PEGADO: 2 PEGO: 1 PERO: 1 PERRA: 6 POR: 1 PORQUE: 1 PORRA: 3 QUE: 1 ROMPIO: 1 ROTO: 1 SI: 1 TENIA: 2 UNA: 2 USTED: 1 Y: 1"),
							 normalize(loadFile("outputData.txt")));
				
			} finally {
				deleteFile("outputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasPresentaPalabrasFichTest1() throws Exception {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[A: 3, BUEN: 1, CON: 3, DE: 8, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, LA: 10, NO: 2, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, SI: 1, TENIA: 2, UNA: 2, USTED: 1, Y: 1]"),
						normalize(cp1.toString()));
				cp1.presentaPalabras("outputData.txt");
				assertEquals("\n> Error: presentaPalabrasPW():",
							 normalize("A: 3 BUEN: 1 CON: 3 DE: 8 GUERRA: 5 HA: 1 HOMBRE: 1 HUBIERA: 2 JARRA: 3 LA: 10 NO: 2 OIGA: 1 PARRA: 7 PEGADO: 2 PEGO: 1 PERO: 1 PERRA: 6 POR: 1 PORQUE: 1 PORRA: 3 QUE: 1 ROMPIO: 1 ROTO: 1 SI: 1 TENIA: 2 UNA: 2 USTED: 1 Y: 1"),
							 normalize(loadFile("outputData.txt")));
				
			} finally {
				deleteFile("outputData.txt");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestContadorPalabrasSig {
		private static final String[] inputData = {
			"Guerra tenia una jarra y Parra tenia una perra, ",
			"pero la perra de Parra rompio la jarra de Guerra.",
			"Guerra pego con la porra a la perra de Parra. ",
			"!Oiga usted buen hombre de Parra! ",
			"Por que ha pegado con la porra a la perra de Parra.",
			"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
			"Guerra no hubiera pegado con la porra a la perra de Parra."
		};
		private static final String delimiters = "[ .,:;\\-\\!\\?]+";
		private static final String[] noSig = {
			"Con", "La", "A", "De", "NO", "SI", "y", "una"
		};
		private static final String[] noSigInputData = {
			"Con La A De NO SI y una"
		};
		private ContadorPalabrasSig cp1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of ContadorPalabrasSig JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of ContadorPalabrasSig JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			cp1 = new ContadorPalabrasSig(java.util.Arrays.asList(noSig));
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigCtorTest1() {
			assertTrue("\n> Error: ContadorPalabrasSig extends ContadorPalabras:", ((Object)cp1 instanceof ContadorPalabras));
			assertEquals("\n> Error: cp1.toString():",
						 normalize("[]"),
						 normalize(cp1.toString()));
			cp1.incluyeTodas(inputData, delimiters);
			assertEquals("\n> Error: incluyeTodas() ; toString():",
						 normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
						 normalize(cp1.toString()));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigCtorTest3() throws Exception {
			try {
				createFile("noSigInputData.txt", noSigInputData);
				ContadorPalabrasSig cp2 = new ContadorPalabrasSig("noSigInputData.txt", delimiters);
				assertEquals("\n> Error: cp2.toString():",
							 normalize("[]"),
							 normalize(cp2.toString()));
				cp2.incluyeTodas(inputData, delimiters);
				assertEquals("\n> Error: incluyeTodas() ; toString():",
							 normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
							 normalize(cp2.toString()));
			} finally {
				deleteFile("noSigInputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigIncluyeTodasTest1() {
			cp1.incluyeTodas(inputData, delimiters);
			assertEquals("\n> Error: incluyeTodas() ; toString():",
						 normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
						 normalize(cp1.toString()));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigIncluyeTodasFicheroTest1() throws Exception {
			try {
				createFile("inputData.txt", inputData);
				cp1.incluyeTodasFichero("inputData.txt", delimiters);
				assertEquals("\n> Error: incluyeTodasFichero() ; toString():",
							 normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
							 normalize(cp1.toString()));
			} finally {
				deleteFile("inputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigEncuentraTest1() {
			cp1.incluyeTodas(inputData, delimiters);
			precond(normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
					normalize(cp1.toString()));
			assertEquals("\n> Error: cp1.encuentra(guerra):", new PalabraEnTexto("GUERRA"), cp1.encuentra("guerra"));
			assertEquals("\n> Error: cp1.encuentra(jarra):", new PalabraEnTexto("JARRA"), cp1.encuentra("jarra"));
			assertEquals("\n> Error: cp1.encuentra(roto):", new PalabraEnTexto("ROTO"), cp1.encuentra("roto"));
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigEncuentraTest2() {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
						normalize(cp1.toString()));
				PalabraEnTexto pal = cp1.encuentra("xxx");
				fail("\n> Error: encuentra(xxx): No se lanzo ninguna excepcion");
			} catch (java.util.NoSuchElementException e) {
				//assertEquals("\n> Error: encuentra(xxx): exception.getMessage():", "No existe la palabra xxx", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: encuentra(xxx): la excepcion lanzada no es NoSuchElementException");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigEncuentraTest3() {
			try {
				PalabraEnTexto pal = cp1.encuentra("xxx");
				fail("\n> Error: encuentra(xxx): No se lanzo ninguna excepcion");
			} catch (java.util.NoSuchElementException e) {
				//assertEquals("\n> Error: encuentra(xxx): exception.getMessage():", "No existe la palabra xxx", e.getMessage());
			} catch (Exception e) {
				fail("\n> Error: encuentra(xxx): la excepcion lanzada no es NoSuchElementException");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigPresentaPalabrasPWTest1() throws Exception {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
						normalize(cp1.toString()));
				try (java.io.PrintWriter pw = new java.io.PrintWriter("outputData.txt")) {
					cp1.presentaPalabras(pw);
				}
				assertEquals("\n> Error: presentaPalabrasPW():",
							 normalize("BUEN: 1 GUERRA: 5 HA: 1 HOMBRE: 1 HUBIERA: 2 JARRA: 3 OIGA: 1 PARRA: 7 PEGADO: 2 PEGO: 1 PERO: 1 PERRA: 6 POR: 1 PORQUE: 1 PORRA: 3 QUE: 1 ROMPIO: 1 ROTO: 1 TENIA: 2 USTED: 1"),
							 normalize(loadFile("outputData.txt")));
				
			} finally {
				deleteFile("outputData.txt");
			}
		}
		@Test(timeout = 1000)
		public void contadorPalabrasSigPresentaPalabrasFichTest1() throws Exception {
			try {
				cp1.incluyeTodas(inputData, delimiters);
				precond(normalize("[BUEN: 1, GUERRA: 5, HA: 1, HOMBRE: 1, HUBIERA: 2, JARRA: 3, OIGA: 1, PARRA: 7, PEGADO: 2, PEGO: 1, PERO: 1, PERRA: 6, POR: 1, PORQUE: 1, PORRA: 3, QUE: 1, ROMPIO: 1, ROTO: 1, TENIA: 2, USTED: 1]"),
						normalize(cp1.toString()));
				cp1.presentaPalabras("outputData.txt");
				assertEquals("\n> Error: presentaPalabrasPW():",
							 normalize("BUEN: 1 GUERRA: 5 HA: 1 HOMBRE: 1 HUBIERA: 2 JARRA: 3 OIGA: 1 PARRA: 7 PEGADO: 2 PEGO: 1 PERO: 1 PERRA: 6 POR: 1 PORQUE: 1 PORRA: 3 QUE: 1 ROMPIO: 1 ROTO: 1 TENIA: 2 USTED: 1"),
							 normalize(loadFile("outputData.txt")));
				
			} finally {
				deleteFile("outputData.txt");
			}
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestPalabraEnTexto.class ,
				JUnitTestContadorPalabras.class ,
				JUnitTestContadorPalabrasSig.class
				})
				public static class JUnitTestSuite { /*empty*/ }
	//----------------------------------------------------------------------
	//--TestRunner-----------------------------------------------------
	//----------------------------------------------------------------------
	public static Result result = null;
	public static void main(String[] args) {
		result = JUnitCore.runClasses(JUnitTestSuite.class);
		int rc = result.getRunCount();
		int fc = result.getFailureCount();
		int ac = 0;//result.getAssumptionFailureCount();
		int ic = result.getIgnoreCount();
		if (fc > 0) {
			System.out.println(">>> ------");
		}
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if ((ac > 0)||(fc > 0)) {
			System.out.println(">>> ------");
			if (ac > 0) {
				System.out.println(">>> Error: No se pudieron realizar "+ac+" tests debido a errores en otros metodos");
			}
			if (fc > 0) {
				System.out.println(">>> Error: Fallaron "+fc+" tests debido a errores en metodos");
			}
		}
		if (result.wasSuccessful()) {
			System.out.print(">>> JUnit Test Succeeded");
		} else {
			System.out.print(">>> Error: JUnit Test Failed");
		}
		System.out.println(" ("+rc+", "+fc+", "+ac+", "+ic+")");
	}
	//----------------------------------------------------------------------
	//-- Utils -------------------------------------------------------------
	//----------------------------------------------------------------------
	private static char normalizeUnicode(char ch) {
		switch (ch) {
		case '\n':
		case '\r':
		case '\t':
		case '\f':
			ch = ' ';
			break;
		case '\u20AC':
			ch = 'E';
			break;
		case '\u00A1':
			ch = '!';
			break;
		case '\u00AA':
			ch = 'a';
			break;
		case '\u00BA':
			ch = 'o';
			break;
		case '\u00BF':
			ch = '?';
			break;
		case '\u00C0':
		case '\u00C1':
		case '\u00C2':
		case '\u00C3':
		case '\u00C4':
		case '\u00C5':
		case '\u00C6':
			ch = 'A';
			break;
		case '\u00C7':
			ch = 'C';
			break;
		case '\u00C8':
		case '\u00C9':
		case '\u00CA':
		case '\u00CB':
			ch = 'E';
			break;
		case '\u00CC':
		case '\u00CD':
		case '\u00CE':
		case '\u00CF':
			ch = 'I';
			break;
		case '\u00D0':
			ch = 'D';
			break;
		case '\u00D1':
			ch = 'N';
			break;
		case '\u00D2':
		case '\u00D3':
		case '\u00D4':
		case '\u00D5':
		case '\u00D6':
			ch = 'O';
			break;
		case '\u00D9':
		case '\u00DA':
		case '\u00DB':
		case '\u00DC':
			ch = 'U';
			break;
		case '\u00DD':
			ch = 'Y';
			break;
		case '\u00E0':
		case '\u00E1':
		case '\u00E2':
		case '\u00E3':
		case '\u00E4':
		case '\u00E5':
		case '\u00E6':
			ch = 'a';
			break;
		case '\u00E7':
			ch = 'c';
			break;
		case '\u00E8':
		case '\u00E9':
		case '\u00EA':
		case '\u00EB':
			ch = 'e';
			break;
		case '\u00EC':
		case '\u00ED':
		case '\u00EE':
		case '\u00EF':
			ch = 'i';
			break;
		case '\u00F0':
			ch = 'd';
			break;
		case '\u00F1':
			ch = 'n';
			break;
		case '\u00F2':
		case '\u00F3':
		case '\u00F4':
		case '\u00F5':
		case '\u00F6':
			ch = 'o';
			break;
		case '\u00F9':
		case '\u00FA':
		case '\u00FB':
		case '\u00FC':
			ch = 'u';
			break;
		case '\u00FD':
		case '\u00FF':
			ch = 'y';
			break;
		}
		return ch;
	}
	//----------------------------------------------------------------------
	private static String normalize(String s1) {
		int sz = s1 == null ? 16 : s1.length() == 0 ? 16 : 2*s1.length();
		StringBuilder sb = new StringBuilder(sz);
		sb.append(' ');
		if (s1 != null) {
			for (int i = 0; i < s1.length(); ++i) {
				char ch = normalizeUnicode(s1.charAt(i));
				char sbLastChar = sb.charAt(sb.length()-1);
				if (Character.isLetter(ch)) {
					if ( ! Character.isLetter(sbLastChar)) {
						if ( ! Character.isSpaceChar(sbLastChar)) {
							sb.append(' ');
						}
					}
					sb.append(ch);
				} else if (Character.isDigit(ch)) {
					if ((i >= 2)
						&& (s1.charAt(i-1) == '.')
						&& Character.isDigit(s1.charAt(i-2))) {
						sb.setLength(sb.length()-2); // "9 ."
						sb.append('.');
					} else if ((i >= 2)
							   && ((s1.charAt(i-1) == 'e')||(s1.charAt(i-1) == 'E'))
							   && Character.isDigit(s1.charAt(i-2))) {
						sb.setLength(sb.length()-2); // "9 e"
						sb.append('e');
					} else if ((i >= 3)
							   && (s1.charAt(i-1) == '+')
							   && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
							   && Character.isDigit(s1.charAt(i-3))) {
						sb.setLength(sb.length()-4); // "9 e +"
						sb.append('e');
					} else if ((i >= 3)
							   && (s1.charAt(i-1) == '-')
							   && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
							   && Character.isDigit(s1.charAt(i-3))) {
						sb.setLength(sb.length()-4); // "9 e -"
						sb.append("e-");
					} else if ( (sbLastChar != '-') && ! Character.isDigit(sbLastChar)) {
						if ( ! Character.isSpaceChar(sbLastChar)) {
							sb.append(' ');
						}
					}
					sb.append(ch);
				} else if (Character.isSpaceChar(ch)) {
					if ( ! Character.isSpaceChar(sbLastChar)) {
						sb.append(' ');
					}
				} else {
					if ( ! Character.isSpaceChar(sbLastChar)) {
						sb.append(' ');
					}
					sb.append(ch);
				}
			}
		}
		if (Character.isSpaceChar(sb.charAt(sb.length()-1))) {
			sb.setLength(sb.length()-1);
		}
		if ((sb.length() > 0) && Character.isSpaceChar(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	//----------------------------------------------------------------------
	private static final String precondMessage = "\n> Aviso: No se pudo realizar el test debido a errores en otros metodos";
	//----------------------------------------------------------------------
	private static void precond(boolean expectedValue, boolean currValue) {
		assumeTrue(precondMessage, expectedValue == currValue);
	}
	private static void precond(char expectedValue, char currValue) {
		assumeTrue(precondMessage, expectedValue == currValue);
	}
	private static void precond(short expectedValue, short currValue) {
		assumeTrue(precondMessage, expectedValue == currValue);
	}
	private static void precond(int expectedValue, int currValue) {
		assumeTrue(precondMessage, expectedValue == currValue);
	}
	private static void precond(long expectedValue, long currValue) {
		assumeTrue(precondMessage, expectedValue == currValue);
	}
	private static void precond(float expectedValue, float currValue, float delta) {
		assumeTrue(precondMessage, Math.abs(expectedValue - currValue) <= delta);
	}
	private static void precond(double expectedValue, double currValue, double delta) {
		assumeTrue(precondMessage, Math.abs(expectedValue - currValue) <= delta);
	}
	private static void precond(Object expectedValue, Object currValue) {
		if ((expectedValue == null)||(currValue == null)) {
			assumeTrue(precondMessage, expectedValue == currValue);
		} else {
			assumeTrue(precondMessage, expectedValue.equals(currValue));
		}
	}
	//------------------------------------------------------------------
	private static void precond(int[] expectedValue, int[] currValue) {
		if ((expectedValue == null)||(currValue == null)) {
			assumeTrue(precondMessage, expectedValue == currValue);
		} else {
			precond(expectedValue.length, currValue.length);
			for (int i = 0; i < expectedValue.length; ++i) {
				precond(expectedValue[i], currValue[i]);
			}
		}
	}
	private static void precond(double[] expectedValue, double[] currValue, double delta) {
		if ((expectedValue == null)||(currValue == null)) {
			assumeTrue(precondMessage, expectedValue == currValue);
		} else {
			precond(expectedValue.length, currValue.length);
			for (int i = 0; i < expectedValue.length; ++i) {
				precond(expectedValue[i], currValue[i], delta);
			}
		}
	}
	private static <T> void precond(T[] expectedValue, T[] currValue) {
		if ((expectedValue == null)||(currValue == null)) {
			assumeTrue(precondMessage, expectedValue == currValue);
		} else {
			precond(expectedValue.length, currValue.length);
			for (int i = 0; i < expectedValue.length; ++i) {
				precond(expectedValue[i], currValue[i]);
			}
		}
	}
	//----------------------------------------------------------------------
	private static void precondNorm(String expectedValue, String currValue) {
		precond(normalize(expectedValue), normalize(currValue));
	}
	private static void assertEqualsNorm(String msg, String expectedValue, String currValue) {
		assertEquals(msg, normalize(expectedValue), normalize(currValue));
	}
	private static void assertArrayEqualsNorm(String msg, String[] expectedValue, String[] currValue) {
		assertEquals(msg, expectedValue.length, currValue.length);
		for (int i = 0; i < expectedValue.length; ++i) {
			assertEquals(msg, normalize(expectedValue[i]), normalize(currValue[i]));
		}
	}
	//----------------------------------------------------------------------
	private static void deleteFile(String filename) {
		new java.io.File(filename).delete();
	}
	private static void createFile(String filename, String inputData) throws Exception {
		try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
			pw.println(inputData);
		}
	}
	private static void createFile(String filename, String[] inputData) throws Exception {
		try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
			for (String linea : inputData) {
				pw.println(linea);
			}
		}
	}
	private static String loadFile(String filename) throws Exception {
		java.util.StringJoiner sj = new java.util.StringJoiner("\n");
		try (java.util.Scanner sc = new java.util.Scanner(new java.io.File(filename))) {
			while (sc.hasNextLine()) {
				sj.add(sc.nextLine());
			}
		}
		return sj.toString();
	}
	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	private static class SysOutCapture {
		private SysOutErrCapture systemout;
		private SysOutErrCapture systemerr;
		public SysOutCapture() {
			systemout = new SysOutErrCapture(false);
			systemerr = new SysOutErrCapture(true);
		}
		public void sysOutCapture() throws RuntimeException {
			try {
				systemout.sysOutCapture();
			} finally {
				systemerr.sysOutCapture();
			}
		}
		public String sysOutRelease() throws RuntimeException {
			String s1 = "";
			String s2 = "";
			try {
				s1 = systemout.sysOutRelease();
			} finally {
				s2 = systemerr.sysOutRelease();
			}
			return s1 + " " + s2 ;
		}
		//--------------------------
		private static class SysOutErrCapture {
			//--------------------------------
			private java.io.PrintStream sysoutOld;
			private java.io.PrintStream sysoutstr;
			private java.io.ByteArrayOutputStream baos;
			private final boolean systemErr;
			private int estado;
			//--------------------------------
			public SysOutErrCapture(boolean syserr) {
				sysoutstr = null ;
				baos = null;
				sysoutOld = null ;
				estado = 0;
				systemErr = syserr;
			}
			//--------------------------------
			public void sysOutCapture() throws RuntimeException {
				if (estado != 0) {
					throw new RuntimeException("sysOutCapture:BadState");
				} else {
					estado = 1;
					try {
						if (systemErr) {
							sysoutOld = System.err;
						} else {
							sysoutOld = System.out;
						}
						baos = new java.io.ByteArrayOutputStream();
						sysoutstr = new java.io.PrintStream(baos);
						if (systemErr) {
							System.setErr(sysoutstr);
						} else {
							System.setOut(sysoutstr);
						}
					} catch (Throwable e) {
						throw new RuntimeException("sysOutCapture:InternalError");
					}
				}
			}
			//--------------------------------
			public String sysOutRelease() throws RuntimeException {
				String result = "";
				if (estado != 1) {
					throw new RuntimeException("sysOutRelease:BadState");
				} else {
					estado = 0;
					try {
						if (sysoutstr != null) {
							sysoutstr.flush();
						}
						if (baos != null) {
							baos.flush();
							result = new String(baos.toByteArray()); //java.nio.charset.StandardCharsets.ISO_8859_1);
						}
					} catch (Throwable e) {
						throw new RuntimeException("sysOutRelease:InternalError1");
					} finally {
						try {
							if (systemErr) {
								System.setErr(sysoutOld);
							} else {
								System.setOut(sysoutOld);
							}
							if (sysoutstr != null) {
								sysoutstr.close();
								sysoutstr = null;
							}
							if (baos != null) {
								baos.close();
								baos = null;
							}
						} catch (Throwable e) {
							throw new RuntimeException("sysOutRelease:InternalError2");
						}
					}
				}
				return result;
			}
			//--------------------------------
		}
	}
	//----------------------------------------------------------------------
}
//--------------------------------------------------------------------------

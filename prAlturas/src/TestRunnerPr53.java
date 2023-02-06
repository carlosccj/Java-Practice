
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

import alturas.*;

//--------------------------------------------------------------------------

public class TestRunnerPr53 {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestPais {
		private Pais p1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Pais JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Pais JUnit Test");
		}
		@Before
		public void setUp() throws Exception {
			// Code executed before each test
			p1 = new Pais("Turkey", "Euro/Asia", 1.74);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void paisCtorTest1() {
			assertEquals("\n> Error: p1.getNombre():",
						 "Turkey",
						 p1.getNombre());
			assertEquals("\n> Error: p1.getContinente():",
						 "Euro/Asia",
						 p1.getContinente());
			assertEquals("\n> Error: p1.getAltura():",
						 1.74,
						 p1.getAltura(), 0.00001);
		}
		@Test(timeout = 1000)
		public void paisCtorTest2() {
			assertTrue("\n> Error: Pais implements Comparable<?>:", ((Object)p1 instanceof Comparable<?>));
		}
		@Test(timeout = 1000)
		public void paisEqualsTest1() throws Exception {
			precond("Turkey", p1.getNombre());
			precond("Euro/Asia", p1.getContinente());
			precond(1.74, p1.getAltura(), 0.00001);
			//----------------------
			Pais p2 = new Pais("Turkey", "Euro/Asia", 1.74);
			assertTrue("\n> Error: p1.equals(p2): ", p1.equals(p2));
			//------------------------
			assertTrue("\n> Error: p1.equals((Object)p2): ", p1.equals((Object)p2));
			//------------------------
			Pais p3 = new Pais("Turkey", "Asia", 1.74);
			assertTrue("\n> Error: p1.equals(p3): ", p1.equals(p3));
			//------------------------
			Pais p4 = new Pais("Turkey", "Euro/Asia", 2.00);
			assertTrue("\n> Error: p1.equals(p4): ", p1.equals(p4));
			//------------------------
			Pais p5 = new Pais("TURKEY", "Euro/Asia", 1.74);
			assertFalse("\n> Error: p1.equals(p5): ", p1.equals(p5));
			//------------------------
			Pais p6 = new Pais("Iceland", "Europe", 1.81);
			assertFalse("\n> Error: p1.equals(p6): ", p1.equals(p6));
			//------------------------
			assertFalse("\n> Error: p1.equals(null): ", p1.equals(null));
			assertFalse("\n> Error: p1.equals(\"Esto es un String\"): ", p1.equals("Esto es un String"));
		}
		@Test(timeout = 1000)
		public void paisHashCodeTest1() throws Exception {
			precond("Turkey", p1.getNombre());
			precond("Euro/Asia", p1.getContinente());
			precond(1.74, p1.getAltura(), 0.00001);
			//----------------------
			int p1HashCode = p1.hashCode();
			//------------------------
			Pais p2 = new Pais("Turkey", "Euro/Asia", 1.74);
			assertEquals("\n> Error: p2.hashCode(): ", p1HashCode, p2.hashCode());
			//------------------------
			Pais p3 = new Pais("Turkey", "Asia", 1.74);
			assertEquals("\n> Error: p3.hashCode(): ", p1HashCode, p3.hashCode());
			//------------------------
			Pais p4 = new Pais("Turkey", "Euro/Asia", 2.00);
			assertEquals("\n> Error: p4.hashCode(): ", p1HashCode, p4.hashCode());
			//------------------------
			Pais p5 = new Pais("TURKEY", "Euro/Asia", 1.74);
			assertNotEquals("\n> Error: p5.hashCode(): ", p1HashCode, p5.hashCode());
			//------------------------
			Pais p6 = new Pais("Iceland", "Europe", 1.81);
			assertNotEquals("\n> Error: p5.hashCode(): ", p1HashCode, p6.hashCode());
		}
		@Test(timeout = 1000)
		public void paisCompareToTest1() throws Exception {
			precond("Turkey", p1.getNombre());
			precond("Euro/Asia", p1.getContinente());
			precond(1.74, p1.getAltura(), 0.00001);
			//----------------------
			Pais p2 = new Pais("Turkey", "Euro/Asia", 1.74);
			assertEquals("\n> Error: p1.compareTo(p2): ", 0, p1.compareTo(p2));
			//------------------------
			Pais p3 = new Pais("Turkey", "Asia", 1.74);
			assertEquals("\n> Error: p1.compareTo(p3): ", 0, p1.compareTo(p3));
			//------------------------
			Pais p4 = new Pais("Turkey", "Euro/Asia", 2.00);
			assertEquals("\n> Error: p1.compareTo(p4): ", 0, p1.compareTo(p4));
			//------------------------
			Pais p5 = new Pais("TURKEY", "Euro/Asia", 1.74);
			assertTrue("\n> Error: p1.compareTo(p5): ", p1.compareTo(p5) > 0);
			assertTrue("\n> Error: p5.compareTo(p1): ", p5.compareTo(p1) < 0);
			//------------------------
			Pais p6 = new Pais("Iceland", "Europe", 1.81);
			assertTrue("\n> Error: p1.compareTo(p6): ", p1.compareTo(p6) > 0);
			assertTrue("\n> Error: p6.compareTo(p1): ", p6.compareTo(p1) < 0);
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestMundo {
		private static final String[] inputData = {
			"Albania,Europe,1.74",
			"Algeria,Africa,1.722",
			"Argentina,South America,1.745",
			"Australia,Oceania,1.756",
			"Austria,Europe,1.792",
			"Azerbaijan,Asia,1.718",
			"Bahrain,Asia,1.651",
			"Error,Error,Error",
			"Belgium,Europe,1.786",
			"Bolivia,South America,1.6",
			"Bosnia & Herzegovina,Europe,1.839",
			"Brazil,South America,1.731",
			"Error;Error;Error",
			"Bulgaria,Europe,1.752",
			"Cambodia,Asia,1.625",
			"Cameroon,Africa,1.706",
			"Canada,North America,1.751",
			"Chile,South America,1.71",
			"China,Asia,1.67",
			"Colombia,South America,1.706",
			"Croatia,Europe,1.805",
			"Cuba,North America,1.68",
			"Czech Republic,Europe,1.803",
		};
		private static final String inputList = normalize("[ Pais ( Albania , Europe , 1.74 ) , Pais ( Algeria , Africa , 1.722 ) , Pais ( Argentina , South America , 1.745 ) , Pais ( Australia , Oceania , 1.756 ) , Pais ( Austria , Europe , 1.792 ) , Pais ( Azerbaijan , Asia , 1.718 ) , Pais ( Bahrain , Asia , 1.651 ) , Pais ( Belgium , Europe , 1.786 ) , Pais ( Bolivia , South America , 1.6 ) , Pais ( Bosnia & Herzegovina , Europe , 1.839 ) , Pais ( Brazil , South America , 1.731 ) , Pais ( Bulgaria , Europe , 1.752 ) , Pais ( Cambodia , Asia , 1.625 ) , Pais ( Cameroon , Africa , 1.706 ) , Pais ( Canada , North America , 1.751 ) , Pais ( Chile , South America , 1.71 ) , Pais ( China , Asia , 1.67 ) , Pais ( Colombia , South America , 1.706 ) , Pais ( Croatia , Europe , 1.805 ) , Pais ( Cuba , North America , 1.68 ) , Pais ( Czech Republic , Europe , 1.803 ) ]");
		public static Mundo createMundo() throws Exception {
			Mundo mnd1 = null;
			try {
				createFile("alts.txt", inputData);
				mnd1 = Mundo.createFromFile("alts.txt");
			} finally {
				deleteFile("alts.txt");
			}
			return mnd1;
		}
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Mundo JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Mundo JUnit Test");
		}
		@Before
		public void setUp() throws Exception {
			// Code executed before each test
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void mundoCtorTest1() throws Exception {
			Mundo mnd1 = createMundo();
			assertEquals("\n> Error: mnd1.getPaises():",
						 inputList,
						 normalize(mnd1.getPaises().toString()));
		}
		@Test(timeout = 1000)
		public void mundoPresentaEnConsolaTest1() {
			java.util.TreeMap<String,String> map = new java.util.TreeMap<>();
			map.put("pepe", "maria");
			map.put("lola", "juan");
			map.put("luis", "eva");
			String salida = "";
			SysOutCapture sysOutCapture = new SysOutCapture();
			try {
				sysOutCapture.sysOutCapture();
				Mundo.presentaEnConsola(map);
			} finally {
				salida = sysOutCapture.sysOutRelease();
			}
			assertEquals("\n> Error: Mundo.presentaEnConsola(map):",
						 normalize("lola juan luis eva pepe maria"),
						 normalize(salida));
		}
		@Test(timeout = 1000)
		public void mundoNumeroDePaisesPorContinenteTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.numeroDePaisesPorContinente():",
						 normalize("{ Africa = 2 , Asia = 4 , Europe = 7 , North America = 2 , Oceania = 1 , South America = 5 }"),
						 normalize(mnd1.numeroDePaisesPorContinente().toString()));
		}
		@Test(timeout = 1000)
		public void mundoPaisesPorAlturaTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.paisesPorAltura():",
						 normalize("{ 1.6 = [ Pais ( Bahrain , Asia , 1.651 ) , Pais ( Bolivia , South America , 1.6 ) , Pais ( Cambodia , Asia , 1.625 ) , Pais ( China , Asia , 1.67 ) , Pais ( Cuba , North America , 1.68 ) ] , 1.7 = [ Pais ( Albania , Europe , 1.74 ) , Pais ( Algeria , Africa , 1.722 ) , Pais ( Argentina , South America , 1.745 ) , Pais ( Australia , Oceania , 1.756 ) , Pais ( Austria , Europe , 1.792 ) , Pais ( Azerbaijan , Asia , 1.718 ) , Pais ( Belgium , Europe , 1.786 ) , Pais ( Brazil , South America , 1.731 ) , Pais ( Bulgaria , Europe , 1.752 ) , Pais ( Cameroon , Africa , 1.706 ) , Pais ( Canada , North America , 1.751 ) , Pais ( Chile , South America , 1.71 ) , Pais ( Colombia , South America , 1.706 ) ] , 1.8 = [ Pais ( Bosnia & Herzegovina , Europe , 1.839 ) , Pais ( Croatia , Europe , 1.805 ) , Pais ( Czech Republic , Europe , 1.803 ) ] }"),
						 normalize(mnd1.paisesPorAltura().toString()));
		}
		@Test(timeout = 1000)
		public void mundoPaisesPorContinenteTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.paisesPorContinente():",
						 normalize("{ Africa = [ Pais ( Algeria , Africa , 1.722 ) , Pais ( Cameroon , Africa , 1.706 ) ] , Asia = [ Pais ( Azerbaijan , Asia , 1.718 ) , Pais ( Bahrain , Asia , 1.651 ) , Pais ( Cambodia , Asia , 1.625 ) , Pais ( China , Asia , 1.67 ) ] , Europe = [ Pais ( Albania , Europe , 1.74 ) , Pais ( Austria , Europe , 1.792 ) , Pais ( Belgium , Europe , 1.786 ) , Pais ( Bosnia & Herzegovina , Europe , 1.839 ) , Pais ( Bulgaria , Europe , 1.752 ) , Pais ( Croatia , Europe , 1.805 ) , Pais ( Czech Republic , Europe , 1.803 ) ] , North America = [ Pais ( Canada , North America , 1.751 ) , Pais ( Cuba , North America , 1.68 ) ] , Oceania = [ Pais ( Australia , Oceania , 1.756 ) ] , South America = [ Pais ( Argentina , South America , 1.745 ) , Pais ( Bolivia , South America , 1.6 ) , Pais ( Brazil , South America , 1.731 ) , Pais ( Chile , South America , 1.71 ) , Pais ( Colombia , South America , 1.706 ) ] }"),
						 normalize(mnd1.paisesPorContinente().toString()));
		}
		@Test(timeout = 1000)
		public void mundoPaisesPorInicialTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.paisesPorInicial():",
						 normalize("{ A = [ Pais ( Albania , Europe , 1.74 ) , Pais ( Algeria , Africa , 1.722 ) , Pais ( Argentina , South America , 1.745 ) , Pais ( Australia , Oceania , 1.756 ) , Pais ( Austria , Europe , 1.792 ) , Pais ( Azerbaijan , Asia , 1.718 ) ] , B = [ Pais ( Bahrain , Asia , 1.651 ) , Pais ( Belgium , Europe , 1.786 ) , Pais ( Bolivia , South America , 1.6 ) , Pais ( Bosnia & Herzegovina , Europe , 1.839 ) , Pais ( Brazil , South America , 1.731 ) , Pais ( Bulgaria , Europe , 1.752 ) ] , C = [ Pais ( Cambodia , Asia , 1.625 ) , Pais ( Cameroon , Africa , 1.706 ) , Pais ( Canada , North America , 1.751 ) , Pais ( Chile , South America , 1.71 ) , Pais ( China , Asia , 1.67 ) , Pais ( Colombia , South America , 1.706 ) , Pais ( Croatia , Europe , 1.805 ) , Pais ( Cuba , North America , 1.68 ) , Pais ( Czech Republic , Europe , 1.803 ) ] }"),
						 normalize(mnd1.paisesPorInicial().toString()));
		}
		@Test(timeout = 1000)
		public void mundoMediaPorContinenteTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.mediaPorContinente():",
						 normalize("{ Africa = 1.714 , Asia = 1.666 , Europe = 1.788142857142857 , North America = 1.7155 , Oceania = 1.756 , South America = 1.6984000000000001 }"),
						 normalize(mnd1.mediaPorContinente().toString()));
		}
		@Test(timeout = 1000)
		public void mundoContinentesConMasPaisesTest1() throws Exception {
			Mundo mnd1 = createMundo();
			precond(inputList, normalize(mnd1.getPaises().toString()));
			//----------------------
			assertEquals("\n> Error: mnd1.continentesConMasPaises():",
						 normalize("[ Europe ]"),
						 normalize(mnd1.continentesConMasPaises().toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestPais.class ,
				JUnitTestMundo.class
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


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

import prLibreria.*;

//--------------------------------------------------------------------------

public class TestRunnerPr23Ej2 {
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestLibro {
		private Libro lb1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Libro JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Libro JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			lb1 = new Libro("Isaac Asimov", "La Fundacion", 7.30);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void libroCtorTest1() {
			assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", 7.30): Autor:", "Isaac Asimov", lb1.getAutor());
			assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", 7.30): Titulo:", "La Fundacion", lb1.getTitulo());
			assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", 7.30): PrecioBase:", 7.30, lb1.getPrecioBase(), 1e-6);
			assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", 7.30): PorcIva:", 10.00, Libro.getIVA(), 1e-6);
		}
		//@Test(timeout = 1000)
		//public void libroCtorTestX1() {
		//	try {
		//		Libro lb2 = new Libro("Isaac Asimov", "La Fundacion", -7.30);
		//		fail("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30): No se lanzo ninguna excepcion");
		//	} catch (RuntimeException e) {
		//		//assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30): exception.getMessage():", "", e.getMessage());
		//	} catch (Exception e) {
		//		fail("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30): la excepcion lanzada no es RuntimeException");
		//	}
		//}
		@Test(timeout = 1000)
		public void libroPrecioFinalTest1() {
			precond("Isaac Asimov", lb1.getAutor());
			precond("La Fundacion", lb1.getTitulo());
			precond(7.30, lb1.getPrecioBase(), 1e-6);
			precond(10.0, Libro.getIVA(), 1e-6);
			assertEquals("\n> Error: lb1.getPrecioFinal(): ", 8.03, lb1.getPrecioFinal(), 1e-6);
		}
		@Test(timeout = 1000)
		public void libroSetIvaTest1() {
			precond("Isaac Asimov", lb1.getAutor());
			precond("La Fundacion", lb1.getTitulo());
			precond(7.30, lb1.getPrecioBase(), 1e-6);
			precond(10.0, Libro.getIVA(), 1e-6);
			Libro.setIVA(20.00);
			double ivaActual = Libro.getIVA();
			Libro.setIVA(10.00);
			assertEquals("\n> Error: Libro.setIVA(20.00): ", 20.00, ivaActual, 1e-6);
		}
		@Test(timeout = 1000)
		public void libroToStringTest1() {
			precond("Isaac Asimov", lb1.getAutor());
			precond("La Fundacion", lb1.getTitulo());
			precond(7.30, lb1.getPrecioBase(), 1e-6);
			precond(10.0, Libro.getIVA(), 1e-6);
			assertEquals("\n> Error: lb1.toString():",
						 normalize("(Isaac Asimov; La Fundacion; 7.3; 10.0%; 8.03)"),
						 normalize(lb1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestLibroOferta {
		private LibroOferta lo1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of LibroOferta JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of LibroOferta JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			lo1 = new LibroOferta("Isaac Asimov", "La Fundacion", 7.30, 20.0);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void libroOfertaCtorTest1() {
			assertTrue("\n> Error: LibroOferta extends Libro:", ((Object)lo1 instanceof Libro));
			assertEquals("\n> Error: new LibroOferta(\"Isaac Asimov\", \"La Fundacion\", 7.30, 20.0): Autor:", "Isaac Asimov", lo1.getAutor());
			assertEquals("\n> Error: new LibroOferta(\"Isaac Asimov\", \"La Fundacion\", 7.30, 20.0): Titulo:", "La Fundacion", lo1.getTitulo());
			assertEquals("\n> Error: new LibroOferta(\"Isaac Asimov\", \"La Fundacion\", 7.30, 20.0): PrecioBase:", 7.30, lo1.getPrecioBase(), 1e-6);
			assertEquals("\n> Error: new LibroOferta(\"Isaac Asimov\", \"La Fundacion\", 7.30, 20.0): PorcDto:", 20.00, lo1.getDescuento(), 1e-6);
			assertEquals("\n> Error: new LibroOferta(\"Isaac Asimov\", \"La Fundacion\", 7.30, 20.0): PorcIva:", 10.00, LibroOferta.getIVA(), 1e-6);
		}
		//@Test(timeout = 1000)
		//public void libroOfertaCtorTestX1() {
		//	try {
		//		Libro lb2 = new Libro("Isaac Asimov", "La Fundacion", -7.30, -20.0);
		//		fail("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30, -20.0): No se lanzo ninguna excepcion");
		//	} catch (RuntimeException e) {
		//		//assertEquals("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30, -20.0): exception.getMessage():", "", e.getMessage());
		//	} catch (Exception e) {
		//		fail("\n> Error: new Libro(\"Isaac Asimov\", \"La Fundacion\", -7.30, -20.0): la excepcion lanzada no es RuntimeException");
		//	}
		//}
		@Test(timeout = 1000)
		public void libroOfertaPrecioFinalTest1() {
			precond("Isaac Asimov", lo1.getAutor());
			precond("La Fundacion", lo1.getTitulo());
			precond(7.30, lo1.getPrecioBase(), 1e-6);
			precond(20.0, lo1.getDescuento(), 1e-6);
			precond(10.0, LibroOferta.getIVA(), 1e-6);
			assertEquals("\n> Error: lo1.getPrecioFinal(): ", 6.424, lo1.getPrecioFinal(), 1e-6);
		}
		@Test(timeout = 1000)
		public void libroOfertaSetIvaTest1() {
			precond("Isaac Asimov", lo1.getAutor());
			precond("La Fundacion", lo1.getTitulo());
			precond(7.30, lo1.getPrecioBase(), 1e-6);
			precond(20.0, lo1.getDescuento(), 1e-6);
			precond(10.0, LibroOferta.getIVA(), 1e-6);
			Libro.setIVA(20.00);
			double ivaActual = Libro.getIVA();
			Libro.setIVA(10.00);
			assertEquals("\n> Error: Libro.setIVA(20.00): ", 20.00, ivaActual, 1e-6);
		}
		@Test(timeout = 1000)
		public void libroOfertaToStringTest1() {
			precond("Isaac Asimov", lo1.getAutor());
			precond("La Fundacion", lo1.getTitulo());
			precond(7.30, lo1.getPrecioBase(), 1e-6);
			precond(20.0, lo1.getDescuento(), 1e-6);
			precond(10.0, LibroOferta.getIVA(), 1e-6);
			assertEquals("\n> Error: lo1.toString():",
						 normalize("(Isaac Asimov; La Fundacion; 7.3; 20.0%; 5.84; 10.0%; 6.4239999999999995)"),
						 normalize(lo1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestLibreria {
		private Libreria lr1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of Libreria JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of Libreria JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			lr1 = new Libreria(2);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		// Carlos (19/03/19) // Vicente (21/03/19)
		private static final Class arrayLibroClass = (new Libro[1]).getClass();
		private static Libro[] getArrayLibros(Libreria lb) {
			Libro[] libs = null;
			boolean encontrado = false;
			try {
				Class libreriaClass = lb.getClass();
				java.lang.reflect.Field[] libreriaFields = libreriaClass.getDeclaredFields();
				int i = 0;
				while ((i < libreriaFields.length)
					   &&(libreriaFields[i].getType() != arrayLibroClass)) {
					++i;
				}
				if (i < libreriaFields.length) {
					libreriaFields[i].setAccessible(true);
					libs = (Libro[])libreriaFields[i].get(lb);
					encontrado = true;
				}
			} catch (Throwable e) {
				fail("\n> Error: getArrayLibros ha lanzado una excepcion " + e);
			}
			if (! encontrado) {
				fail("\n> Error: la clase Libreria no contiene un array de libros Libro[]");
			}
			if (libs == null) {
				fail("\n> Error: el array de libros no se ha creado correctamente");
			}
			return libs;
		} 
		@Test(timeout = 1000)
		public void libreriaCtorTest1() {
			Libreria lr2 = new Libreria();
			// Carlos (19/03/19)
			assertEquals("\n> Error: new Libreria(): capacidad del array de libros:", 8, getArrayLibros(lr2).length);
		}

		// Carlos (19/03/19)
		@Test(timeout = 1000)
		public void libreriaCtorTest2() {
			assertEquals("\n> Error: lr1: capacidad del array de libros:", 2, getArrayLibros(lr1).length);
		}
			
		@Test(timeout = 1000)
		public void libreriaAddLibroTest1() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			
			// Carlos (19/03/19)
			assertEquals("\n> Error: lr1: capacidad del array de libros:", 4, getArrayLibros(lr1).length);
						
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			
			// Carlos (19/03/19)
			assertEquals("\n> Error: lr1: capacidad del array de libros:", 8, getArrayLibros(lr1).length);

			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lr1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lr1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lr1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lr1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lr1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaAddLibroTest2() {
			lr1.addLibro("isaac asimov", "la fundacion", 5.30);
			lr1.addLibro("aldous huxley", "un mundo feliz", 4.50);
			lr1.addLibro("william gibson", "neuromante", 6.30);
			lr1.addLibro("george orwell", "1984", 4.20);
			lr1.addLibro("ray bradbury", "fahrenheit 451", 5.40);
			//------------------------
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lr1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lr1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lr1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lr1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lr1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lr1.getPrecioBase("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lr1.getPrecioBase("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lr1.getPrecioBase("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lr1.getPrecioBase("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lr1.getPrecioBase("ray bradbury", "fahrenheit 451"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaGetPrecioBaseTest1() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lr1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lr1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lr1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lr1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lr1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("XXX", "XXX"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaGetPrecioBaseTest2() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lr1.getPrecioBase("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lr1.getPrecioBase("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lr1.getPrecioBase("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lr1.getPrecioBase("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lr1.getPrecioBase("ray bradbury", "fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("xxx", "xxx"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaGetPrecioFinalTest1() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.03, lr1.getPrecioFinal("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 7.15, lr1.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 9.13, lr1.getPrecioFinal("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 6.82, lr1.getPrecioFinal("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.14, lr1.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 0.00, lr1.getPrecioFinal("XXX", "XXX"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaGetPrecioFinalTest2() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.03, lr1.getPrecioFinal("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 7.15, lr1.getPrecioFinal("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 9.13, lr1.getPrecioFinal("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 6.82, lr1.getPrecioFinal("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.14, lr1.getPrecioFinal("ray bradbury", "fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 0.00, lr1.getPrecioFinal("xxx", "xxx"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaRemLibroTest1() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			precond(7.30, lr1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			precond(6.50, lr1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			precond(8.30, lr1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			precond(6.20, lr1.getPrecioBase("George Orwell", "1984"), 1e-6);
			precond(7.40, lr1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			lr1.remLibro("Isaac Asimov", "La Fundacion");
			lr1.remLibro("Aldous Huxley", "Un Mundo Feliz");
			lr1.remLibro("William Gibson", "Neuromante");
			lr1.remLibro("George Orwell", "1984");
			lr1.remLibro("Ray Bradbury", "Fahrenheit 451");
			//------------------------
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lr1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			lr1.remLibro("xxx", "xxx");
		}
		@Test(timeout = 1000)
		public void libreriaToStringTest1() {
			assertEquals("\n> Error: lr1.toString():",
						 normalize("[]"),
						 normalize(lr1.toString()));
		}
		@Test(timeout = 1000)
		public void libreriaToStringTest2() {
			lr1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lr1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lr1.addLibro("William Gibson", "Neuromante", 8.30);
			lr1.addLibro("George Orwell", "1984", 6.20);
			lr1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: lr1.toString():",
						 normalize("[(Isaac Asimov; La Fundacion; 7.3; 10.0%; 8.03), (Aldous Huxley; Un Mundo Feliz; 6.5; 10.0%; 7.15), (William Gibson; Neuromante; 8.3; 10.0%; 9.13), (George Orwell; 1984; 6.2; 10.0%; 6.82), (Ray Bradbury; Fahrenheit 451; 7.4; 10.0%; 8.14)]"),
						 normalize(lr1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestOfertaAutor {
		private static final String[] autoresOferta = { "george orwell", "isaac asimov" };
		private OfertaAutor oa1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of OfertaAutor JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of OfertaAutor JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			oa1 = new OfertaAutor(20.0, autoresOferta);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void ofertaAutorCtorTest1() {
			assertTrue("\n> Error: OfertaAutor implements OfertaFlex:", ((Object)oa1 instanceof OfertaFlex));
		}
		@Test(timeout = 1000)
		public void ofertaAutorGetDescuentoTest1() {
			Libro lb1 = new Libro("Isaac Asimov", "La Fundacion", 7.30);
			assertEquals("\n> Error: new OfertaAutor({\"george orwell\", \"isaac asimov\"}): getDescuento(new Libro(\"Isaac Asimov\", \"La Fundacion\", 7.30)):", 20.0, oa1.getDescuento(lb1), 1e-6);
		}
		@Test(timeout = 1000)
		public void ofertaAutorGetDescuentoTest2() {
			Libro lb1 = new Libro("George Orwell", "1984", 6.20);
			assertEquals("\n> Error: new OfertaAutor({\"george orwell\", \"isaac asimov\"}): getDescuento(new Libro(\"George Orwell\", \"1984\", 6.20)):", 20.0, oa1.getDescuento(lb1), 1e-6);
		}
		@Test(timeout = 1000)
		public void ofertaAutorGetDescuentoTest3() {
			Libro lb1 = new Libro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			assertEquals("\n> Error: new OfertaAutor({\"george orwell\", \"isaac asimov\"}): getDescuento(new Libro(\"Aldous Huxley\", \"Un Mundo Feliz\", 6.50)):", 0.0, oa1.getDescuento(lb1), 1e-6);
		}
		@Test(timeout = 1000)
		public void ofertaAutorToStringTest1() {
			assertEquals("\n> Error: oa1.toString():",
						 normalize("20.0%[george orwell, isaac asimov]"),
						 normalize(oa1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestOfertaPrecio {
		private OfertaPrecio op1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of OfertaPrecio JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of OfertaPrecio JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			op1 = new OfertaPrecio(20.0, 10.0);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void ofertaPrecioCtorTest1() {
			assertTrue("\n> Error: OfertaPrecio implements OfertaFlex:", ((Object)op1 instanceof OfertaFlex));
		}
		@Test(timeout = 1000)
		public void ofertaPrecioGetDescuentoTest1() {
			Libro lb1 = new Libro("Isaac Asimov", "La Fundacion", 9.90);
			assertEquals("\n> Error: new OfertaPrecio(20.0, 10.0): getDescuento(new Libro(\"Isaac Asimov\", \"La Fundacion\", 9.90)):", 0.0, op1.getDescuento(lb1), 1e-6);
		}
		@Test(timeout = 1000)
		public void ofertaPrecioGetDescuentoTest2() {
			Libro lb1 = new Libro("Isaac Asimov", "La Fundacion", 10.00);
			assertEquals("\n> Error: new OfertaPrecio(20.0, 10.0): getDescuento(new Libro(\"Isaac Asimov\", \"La Fundacion\", 10.00)):", 20.0, op1.getDescuento(lb1), 1e-6);
		}
		@Test(timeout = 1000)
		public void ofertaPrecioToStringTest1() {
			assertEquals("\n> Error: op1.toString():",
						 normalize("20.0%(10.0)"),
						 normalize(op1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestLibreriaOfertaFlex {
		private static final String[] autoresOferta = { "george orwell", "isaac asimov" };
		private OfertaAutor oa1;
		private LibreriaOfertaFlex lrof1;
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of LibreriaOfertaFlex JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of LibreriaOfertaFlex JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
			oa1 = new OfertaAutor(20.0, autoresOferta);
			lrof1 = new LibreriaOfertaFlex(2, oa1);
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexCtorTest1() {
			assertTrue("\n> Error: LibreriaOfertaFlex extends Libreria:", ((Object)lrof1 instanceof Libreria));
			assertSame("\n> Error: getOferta():", oa1, lrof1.getOferta());
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexCtorTest2() {
			LibreriaOfertaFlex lrof2 = new LibreriaOfertaFlex(oa1);
			assertTrue("\n> Error: LibreriaOfertaFlex extends Libreria:", ((Object)lrof2 instanceof Libreria));
			assertSame("\n> Error: getOferta():", oa1, lrof2.getOferta());
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexSetOfertaTest1() {
			LibreriaOfertaFlex lrof2 = new LibreriaOfertaFlex(oa1);
			precond(oa1, lrof2.getOferta());
			OfertaAutor oa2 = new OfertaAutor(20.0, autoresOferta);
			lrof2.setOferta(oa2);
			assertSame("\n> Error: getOferta():", oa2, lrof2.getOferta());
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexAddLibroTest1() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lrof1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lrof1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lrof1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lrof1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lrof1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexAddLibroTest2() {
			lrof1.addLibro("isaac asimov", "la fundacion", 5.30);
			lrof1.addLibro("aldous huxley", "un mundo feliz", 4.50);
			lrof1.addLibro("william gibson", "neuromante", 6.30);
			lrof1.addLibro("george orwell", "1984", 4.20);
			lrof1.addLibro("ray bradbury", "fahrenheit 451", 5.40);
			//------------------------
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lrof1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lrof1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lrof1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lrof1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lrof1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lrof1.getPrecioBase("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lrof1.getPrecioBase("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lrof1.getPrecioBase("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lrof1.getPrecioBase("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lrof1.getPrecioBase("ray bradbury", "fahrenheit 451"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexGetPrecioBaseTest1() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lrof1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lrof1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lrof1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lrof1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lrof1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("XXX", "XXX"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexGetPrecioBaseTest2() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.30, lrof1.getPrecioBase("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.50, lrof1.getPrecioBase("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 8.30, lrof1.getPrecioBase("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 6.20, lrof1.getPrecioBase("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 7.40, lrof1.getPrecioBase("ray bradbury", "fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("xxx", "xxx"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexGetPrecioFinalTest1() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 6.424, lrof1.getPrecioFinal("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 7.15, lrof1.getPrecioFinal("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 9.13, lrof1.getPrecioFinal("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 5.456, lrof1.getPrecioFinal("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.14, lrof1.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 0.00, lrof1.getPrecioFinal("XXX", "XXX"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexGetPrecioFinalTest2() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 6.424, lrof1.getPrecioFinal("isaac asimov", "la fundacion"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 7.15, lrof1.getPrecioFinal("aldous huxley", "un mundo feliz"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 9.13, lrof1.getPrecioFinal("william gibson", "neuromante"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 5.456, lrof1.getPrecioFinal("george orwell", "1984"), 1e-6);
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 8.14, lrof1.getPrecioFinal("ray bradbury", "fahrenheit 451"), 1e-6);
			//------------------------
			assertEquals("\n> Error: addLibro(): getPrecioFinal():", 0.00, lrof1.getPrecioFinal("xxx", "xxx"), 1e-6);
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexRemLibroTest1() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			precond(7.30, lrof1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			precond(6.50, lrof1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			precond(8.30, lrof1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			precond(6.20, lrof1.getPrecioBase("George Orwell", "1984"), 1e-6);
			precond(7.40, lrof1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			lrof1.remLibro("Isaac Asimov", "La Fundacion");
			lrof1.remLibro("Aldous Huxley", "Un Mundo Feliz");
			lrof1.remLibro("William Gibson", "Neuromante");
			lrof1.remLibro("George Orwell", "1984");
			lrof1.remLibro("Ray Bradbury", "Fahrenheit 451");
			//------------------------
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("Isaac Asimov", "La Fundacion"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("Aldous Huxley", "Un Mundo Feliz"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("William Gibson", "Neuromante"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("George Orwell", "1984"), 1e-6);
			assertEquals("\n> Error: remLibro(): getPrecioBase():", 0.00, lrof1.getPrecioBase("Ray Bradbury", "Fahrenheit 451"), 1e-6);
			//------------------------
			lrof1.remLibro("xxx", "xxx");
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexToStringTest1() {
			assertEquals("\n> Error: lrof1.toString():",
						 normalize("20.0%[george orwell, isaac asimov][]"),
						 normalize(lrof1.toString()));
		}
		@Test(timeout = 1000)
		public void libreriaOfertaFlexToStringTest2() {
			lrof1.addLibro("Isaac Asimov", "La Fundacion", 7.30);
			lrof1.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
			lrof1.addLibro("William Gibson", "Neuromante", 8.30);
			lrof1.addLibro("George Orwell", "1984", 6.20);
			lrof1.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
			//------------------------
			assertEquals("\n> Error: lrof1.toString():",
						 normalize("20.0%[george orwell, isaac asimov][(Isaac Asimov; La Fundacion; 7.3; 20.0%; 5.84; 10.0%; 6.4239999999999995), (Aldous Huxley; Un Mundo Feliz; 6.5; 10.0%; 7.15), (William Gibson; Neuromante; 8.3; 10.0%; 9.13), (George Orwell; 1984; 6.2; 20.0 % ; 4.96 ; 10.0 % ; 5.4559999999999995), (Ray Bradbury; Fahrenheit 451; 7.4; 10.0%; 8.14)]"),
						 normalize(lrof1.toString()));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTest-----------------------------------------------------------
	//----------------------------------------------------------------------
	public static class JUnitTestPruebaLibreriaOfertaFlex {
		@BeforeClass
		public static void beforeClass() {
			// Code executed before the first test method
			System.out.println("Start of PruebaLibreriaOfertaFlex JUnit Test");
		}
		@AfterClass
		public static void  afterClass() {
			// Code executed after the last test method
			System.out.println("End of PruebaLibreriaOfertaFlex JUnit Test");
		}
		@Before
		public void setUp() {
			// Code executed before each test
		}
		@After
		public void tearDown() {
			// Code executed after each test
		}
		@Test(timeout = 1000)
		public void PruebaLibreriaOfertaFlexMainTest1() {
			String salida = "";
			SysOutCapture sysOutCapture = new SysOutCapture();
			try {
				sysOutCapture.sysOutCapture();
				PruebaLibreriaOfertaFlex.main(new String[]{});
			} finally {
				salida = sysOutCapture.sysOutRelease();
			}
			assertEquals("\n> Error: PruebaLibreriaOfertaFlex.main():",
						 normalize("20.0 % [ George Orwell , Isaac Asimov ] [ ( George Orwell ; 1984 ; 6.2 ; 20.0 % ; 4.96 ; 10.0 % ; 5.4559999999999995 ) , ( Philip K . Dick ; ? Suenan los androides con ovejas electricas ? ; 3.5 ; 10.0 % ; 3.85 ) , ( Isaac Asimov ; Fundacion e Imperio ; 9.4 ; 20.0 % ; 7.5200000000000005 ; 10.0 % ; 8.272 ) , ( Ray Bradbury ; Fahrenheit 451 ; 7.4 ; 10.0 % ; 8.14 ) , ( Aldous Huxley ; Un Mundo Feliz ; 6.5 ; 10.0 % ; 7.15 ) , ( Isaac Asimov ; La Fundacion ; 7.3 ; 20.0 % ; 5.84 ; 10.0 % ; 6.4239999999999995 ) , ( William Gibson ; Neuromante ; 8.3 ; 10.0 % ; 9.13 ) , ( Isaac Asimov ; Segunda Fundacion ; 8.1 ; 20.0 % ; 6.4799999999999995 ; 10.0 % ; 7.127999999999999 ) , ( Isaac Newton ; Arithmetica Universalis ; 10.5 ; 10.0 % ; 11.55 ) ] 20.0 % [ George Orwell , Isaac Asimov ] [ ( William Gibson ; Neuromante ; 8.3 ; 10.0 % ; 9.13 ) , ( Philip K . Dick ; ? Suenan los androides con ovejas electricas ? ; 3.5 ; 10.0 % ; 3.85 ) , ( Isaac Asimov ; Fundacion e Imperio ; 9.4 ; 20.0 % ; 7.5200000000000005 ; 10.0 % ; 8.272 ) , ( Ray Bradbury ; Fahrenheit 451 ; 7.4 ; 10.0 % ; 8.14 ) , ( Isaac Asimov ; Segunda Fundacion ; 8.1 ; 20.0 % ; 6.4799999999999995 ; 10.0 % ; 7.127999999999999 ) , ( Isaac Asimov ; La Fundacion ; 7.3 ; 20.0 % ; 5.84 ; 10.0 % ; 6.4239999999999995 ) ] PrecioFinal ( George Orwell , 1984 ) : 0.0 PrecioFinal ( Philip K . Dick , ? Suenan los androides con ovejas electricas ? ) : 3.85 PrecioFinal ( isaac asimov , fundacion e imperio ) : 8.272 PrecioFinal ( Ray Bradbury , Fahrenheit 451 ) : 8.14 PrecioFinal ( Aldous Huxley , Un Mundo Feliz ) : 0.0 PrecioFinal ( Isaac Asimov , La Fundacion ) : 6.4239999999999995 PrecioFinal ( william gibson , neuromante ) : 9.13 PrecioFinal ( Isaac Asimov , Segunda Fundacion ) : 7.127999999999999 PrecioFinal ( Isaac Newton , Arithmetica Universalis ) : 0.0"),
						 normalize(salida));
		}
		//------------------------------------------------------------------
	}
	//----------------------------------------------------------------------
	//--JUnitTestSuite------------------------------------------------------
	//----------------------------------------------------------------------
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ JUnitTestLibro.class ,
				JUnitTestLibroOferta.class ,
				JUnitTestLibreria.class ,
				JUnitTestOfertaAutor.class ,
				JUnitTestOfertaPrecio.class ,
				JUnitTestLibreriaOfertaFlex.class ,
				JUnitTestPruebaLibreriaOfertaFlex.class 
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

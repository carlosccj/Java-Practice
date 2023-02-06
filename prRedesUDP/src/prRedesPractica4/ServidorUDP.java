package prRedesPractica4;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ServidorUDP {
	
	public static String trabajo (String s) {
		return s.toUpperCase();
	}
	
	public static void main (String args[]) throws IOException {
		
		//DATOS DEL SERVIDOR
		//FIJOS: Los datos de conexion nunca cambian (no se pasan por linea de comandos)
		int portF = 12345;
		//VARIABLES: Los datos del servidor son dinamicos (se pasan por linea de comandos)
		int port = Integer.parseInt(args[0]);
		
		//CREAMOS EL SOCKET DEL SERVIDOR
		DatagramSocket serverSocket = null;
		
		//INICIALIZAMOS SOCKET DEL SERVIDOR
		serverSocket = new DatagramSocket(port);
		
		//INICIAMOS BUCLE INFINITO DE SERVICIO
		while(true) {
			
			//CREAMOS BUFFER PARA ALMACENAR INFORMACION DE ENTRADA
			byte[] buffer = new byte[500];
			DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
			serverSocket.receive(recibido);
			
			//CREAMOS STRING CON LA INFORMACION RECIBIDA
			String line = new String(recibido.getData(), recibido.getOffset(), recibido.getLength(), StandardCharsets.UTF_8);
			System.out.println("La IP del cliente es: " + recibido.getAddress() + ", con el puerto: " + recibido.getPort());
			
			//MOSTRAMOS INFORMACION Y LLEVAMOS A CABO EL TRABAJO
			System.out.println(line);
			line = trabajo(line);
			System.out.println(line);
			
			//ENVIAMOS DE VUELTA LA INFORMACION AL CLIENTE
			DatagramPacket enviado = new DatagramPacket(line.getBytes("UTF-8"), line.getBytes("UTF-8").length,
					recibido.getAddress(), recibido.getPort());
			serverSocket.send(enviado);
		}
	}
}

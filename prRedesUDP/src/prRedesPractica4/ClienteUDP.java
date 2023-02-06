package prRedesPractica4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
//192.158.164.126

public class ClienteUDP {
	public static void main(String args[]) throws IOException {
		//DATOS DEL SERVIDOR
		//FIJO: Los datos nunca cambian (no se pasan por linea de comandos)
		String serverNameF = "128.0.0.1";
		int portF = 12345;
		//VARIABLES: Los datos son dinamicos (se pasan por linea de comandos)
		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		
		//CREAMOS SOCKET DE CLIENTE
		DatagramSocket serviceSocket = null;
		
		//INICIALIZAMOS SOCKET DE CLIENTE
		serviceSocket = new DatagramSocket();
		
		//INICIALIZAR ENTRADA POR TECLADO DEL CLIENTE
		BufferedReader clientOutput = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		System.out.println("Introduzca el string a enviar: ");
		userInput = clientOutput.readLine();
		
		//INICIAMOS BUCLE DE ENVIO AL SERVIDOR
		while(!userInput.equals("END")) {
			
			//CREAMOS DATAGRAMA CON LA INFORMACION A ENVIAR
			DatagramPacket enviado = new DatagramPacket(userInput.getBytes("UTF-8"), userInput.getBytes("UTF-8").length,
					InetAddress.getByName(serverName), port);
			serviceSocket.send(enviado);
			
			//CREAMOS BUFFER PARA GUARDAR LA INFORMACION DE ENTRADA
			byte[] buffer = new byte[500];
			DatagramPacket recibido = new DatagramPacket(buffer, buffer.length);
			serviceSocket.receive(recibido);
			
			//GUARDAMOS INFORMACION DE ENTRADA EN BUFFER
			String line = new String(recibido.getData(), recibido.getOffset(), recibido.getLength(), StandardCharsets.UTF_8);
			System.out.println("String recibido: " + line);
			
			//LEEMOS SIGUIENTE LINEA
			System.out.println("Introduzca el string a enviar: ");
			userInput = clientOutput.readLine();
		}
		
		System.out.println("Finalizando conexion y cerrando recursos...");
		
		//CERRAMOS RECURSOS UTILIZADOS
		serviceSocket.close();
		clientOutput.close();
	}
}

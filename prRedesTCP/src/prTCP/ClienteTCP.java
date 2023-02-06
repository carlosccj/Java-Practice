package prTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {
	
	public static void main(String args[]) throws IOException {
		//DATOS DEL SERVIDOR
		//FIJOS: Los datos del servidor nunca cambian (no se pasan por linea de comandos)
		String serverNameF = "127.0.0.1";
		int portF = 12345;
		//VARIABLES: Los datos del servidor se pasan por linea de comandos (comentar las lineas de arriba)
		String serverNameV = args[0];
		int portV = Integer.parseInt(args[1]);
		
		//CREAMOS SOCKET DEL CLIENTE
		Socket client = null;
		
		//CREAMOS FLUJOS PARA ENTRADA Y SALIDA
		BufferedReader in = null;
		PrintWriter out = null;
		
		//CREAMOS SOCKET Y CONECTAMOS CON EL SERVIDOR
		client = new Socket(serverNameV, portV);
		
		//INICIALIZAMOS FLUJOS DE ENTRADA Y SALIDA
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
		
		//OBTENEMOS TEXTO POR TECLADO
		BufferedReader clientOutput = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		
		System.out.println("Introduzca texto por teclado (END para acabar): ");
		userInput = clientOutput.readLine();
		
		//INICIAMOS BUCLE INFINITO DE ENVIO
		while(!userInput.equals("END")) {
			
			//ENVIAMOS EL STRING Y RECIBIMOS LA RESPUESTA
			out.println(userInput);
			String line = in.readLine();
			System.out.println("Mensaje recibido: " + line);
			
			//VOLVEMOS A PREGUNTAR PARA NUEVO ENVIO
			System.out.println("Introduzca texto por teclado (END para acabar): ");
			userInput = clientOutput.readLine();
		}
		
		//ENVIAMOS PALABRA PARA ACABAR Y TERMINAMOS CONEXION
		out.println("END");
		String line = in.readLine();
		System.out.println(line + " recibido. Terminando conexion...");
		
		//CERRAMOS RECURSOS
		client.close();
		in.close();
		out.close();
		clientOutput.close();
	}
}

package prTCP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static String trabajo (String s) {
		return s.toUpperCase();
	}
	
	public static void main(String args[]) throws IOException {
		
		//DATOS DEL SERVIDOR
		//FIJO: el puerto siempre es identico (no se lee por linea de comandos)
		int portF = 12345;
		//VARIABLE: el puerto se pasa por linea de comandos (comentar lo de arriba)
		int portV = Integer.parseInt(args[0]);
		
		//INICIALIZACION DE PUERTOS
		ServerSocket server = null;
		Socket client = null;
		
		//INICIALIZACION DE FLUJOS PARA ENVIO Y RECEPCION
		BufferedReader in = null;
		PrintWriter out = null;
		
		//CREAR E INICIALIZAR EL SOCKET DEL SERVIDOR (nunca debe cerrarse porque debe estar preparado para nuevas conexiones)
		server = new ServerSocket(portV, 1);
		
		//INICIAMOS BUCLE INFINITO DE SERVICIO
		while(true) {
			
			//ACEPTAMOS CLIENTE E INICIALIZAMOS FLUJOS DE ENTRADA/SALIDA
			client = server.accept();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			
			//INICIAMOS BUCLE INTERNO PARA EL MISMO CLIENTE
			boolean salir = false;
			while (!salir) {
				String line = in.readLine();
				if (!line.equals("END")) {
					line = trabajo(line);
					out.println(line);
				} else {
					salir = true;
					out.println("OK");
					System.out.println("FIN DE SERVICIO\n");
				}
			}
			//CERRAMOS RECURSOS
			client.close();
			in.close();
			out.close();
		}
	}
}

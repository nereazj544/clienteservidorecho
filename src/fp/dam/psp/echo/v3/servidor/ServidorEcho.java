package fp.dam.psp.echo.v3.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorEcho {

	public static LinkedList<Conexion> conexiones = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5000);
		ExecutorService executor = Executors.newFixedThreadPool(1000);
		System.out.println("Servidor ECHO escuchando en puerto 5000");
		while (true) {
			Socket socket = serverSocket.accept();
			conexiones.add(new Conexion(socket, executor));
		}
	}

}
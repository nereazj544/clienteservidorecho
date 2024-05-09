package fp.dam.psp.echo.v3.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Conexion {

	private Almacen almacen = new Almacen();
	
	public Conexion(Socket socket, ExecutorService executor) {
		try (Socket s = socket) {
			Future<?> emisor = executor.submit(new Emisor(s, almacen));
			Future<?> receptor = executor.submit(new Receptor(s, almacen));
			try {
				receptor.get();
				System.out.println(socket.getInetAddress() + ": CANCELANDO EMISOR");
				emisor.cancel(true);
				emisor.get();
			} catch (CancellationException e) {
				System.out.println("¿?");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(socket.getInetAddress() + ": FIN CONEXIÓN");
		ServidorEcho.conexiones.remove(this);
	}
	
}

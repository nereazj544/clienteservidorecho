package fp.dam.psp.echo.version2.servidor;

import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Conexion {

	private Socket socket;
	private Almacen almacen = new Almacen();
	private Emisor emisor;
	private Receptor receptor;
	
	public Conexion(Socket socket, ExecutorService executor) {
		this.socket = socket;
		emisor = new Emisor(socket);
		receptor = new Receptor(socket, this);
	}
	
	public void finalizarConexion() {
		
		
		ServidorEcho.conexiones.remove(this);
	}
	
}

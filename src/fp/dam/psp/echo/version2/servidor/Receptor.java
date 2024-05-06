package fp.dam.psp.echo.version2.servidor;

import java.net.Socket;

public class Receptor implements Runnable {
	
	private Socket socket;
	private Conexion conexion;
	
	public Receptor(Socket socket, Conexion conexion) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
				
	}

}

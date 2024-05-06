package fp.dam.psp.echo.version2.servidor;

import java.net.Socket;

public class Emisor implements Runnable {
	
	private Socket socket;
	
	public Emisor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
				
	}

}

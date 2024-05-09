package fp.dam.psp.echo.v3.servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Emisor implements Runnable {

	private Socket socket;
	private Almacen almacen;

	public Emisor(Socket socket, Almacen almacen) {
		this.socket = socket;
		this.almacen = almacen;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(socket.getInetAddress() + " (EMISOR)");
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (!Thread.currentThread().isInterrupted())
				out.writeUTF(almacen.retirar());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(socket.getInetAddress() + ": FIN EMISOR");
	}

}

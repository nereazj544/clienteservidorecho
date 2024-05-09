package fp.dam.psp.echo.v3.servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Emisor implements Runnable {

	private Socket socket;
	private Almacen almacen;
	private int id;

	public Emisor(Socket socket, Almacen almacen, int id) {
		this.socket = socket;
		this.almacen = almacen;
		this.id = id;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(socket.getInetAddress() + " (EMISOR " + id + ")");
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (!Thread.currentThread().isInterrupted()) {
				String s = almacen.retirar();
				if (s != null)
					out.writeUTF(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(socket.getInetAddress() + ": FIN EMISOR");
	}

}

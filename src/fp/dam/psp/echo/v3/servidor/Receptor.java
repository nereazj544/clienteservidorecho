package fp.dam.psp.echo.v3.servidor;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class Receptor implements Runnable {
	
	private Socket socket;
	private Almacen almacen;
	
	public Receptor(Socket socket, Almacen almacen) {
		this.socket = socket;
		this.almacen = almacen;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(socket.getInetAddress() + " (RECEPTOR)");
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String s;
			while (true) {
				s = in.readUTF();
				System.out.println(socket.getInetAddress() + " -> " + s);
				almacen.almacenar(s);
			}
		} catch (EOFException e) {
			System.out.println(socket.getInetAddress() + ": EOF");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

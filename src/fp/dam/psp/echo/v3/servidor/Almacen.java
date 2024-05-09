package fp.dam.psp.echo.v3.servidor;

import java.util.LinkedList;

public class Almacen {

	private LinkedList<String> almacen = new LinkedList<>();
	private static final int MAX = 1000;
	
	public synchronized void almacenar(String s) {
		while (almacen.size() == MAX)
			try {
				wait();
			} catch (InterruptedException e) {}
		almacen.offer(s);
		notify();
	}
	
	public synchronized String retirar() {
		while (almacen.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {}
		String s = almacen.poll();
		notify();
		return s;
	}
}

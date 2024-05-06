package fp.dam.psp.echo.version2.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private Conector con = new Conector(this);
	private JTextArea texto = new JTextArea();
	private JTextArea echo = new JTextArea();
	private JButton enviar = new JButton("Enviar");

	public Main() {
		super("Cliente ECHO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(con, BorderLayout.NORTH);
		
		texto.setColumns(80);
		texto.setRows(50);
		texto.setEditable(false);
		texto.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		JScrollPane sp = new JScrollPane(texto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp, BorderLayout.WEST);
		echo.setColumns(80);
		echo.setRows(50);
		echo.setEditable(false);
		echo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		sp = new JScrollPane(echo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp, BorderLayout.EAST);
		enviar = new JButton("enviar");
		enviar.setEnabled(false);
		enviar.addActionListener(this::enviar);
		add(enviar, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void conexionOn() {
		texto.setEditable(true);
		enviar.setEnabled(true);
	}
	
	public void conexionOff() {
		texto.setEditable(false);
		enviar.setEnabled(false);
	}
	
	private void enviar(ActionEvent e) {
		con.enviar(texto.getText());
		texto.setText("");
	}
	
	public void mostrarEcho(String echo) {
		this.echo.append(echo);
	}
	
	private void iniciar() {
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main()::iniciar);
	}
	
	
}

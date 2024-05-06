package fp.dam.psp.echo.version2.cliente;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Conector extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Main frame;
	JTextField dir = new JTextField();

	public Conector(Main frame) {
		this.frame = frame;
		add(new JLabel("Dirección:"));
		dir.setColumns(15);
		add(dir);
		JButton con = new JButton("Conectar");
		con.setActionCommand("conectar");
		con.addActionListener(this::conectarDesconectar);
		add(con);
	}
	
	private void conectarDesconectar(ActionEvent cmd) {
		JButton src = (JButton) cmd.getSource();
		if (cmd.getActionCommand().equals("conectar")) {
			src.setText("Desconectar");
			src.setActionCommand("desconectar");
			dir.setEditable(false);
			// TODO completar proceso de conexión habilitando el botón de enviar en el frame
			
		}
		else {
			src.setText("Conectar");
			src.setActionCommand("conectar");
			dir.setEditable(true);
			// TODO completar proceso de desconexión deshabilitando el botón de enviar en el frame
			
		}
	}
	
	
	public void enviar(String texto) {
		
	}
	
}

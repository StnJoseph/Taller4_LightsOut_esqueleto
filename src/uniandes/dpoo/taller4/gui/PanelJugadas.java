package uniandes.dpoo.taller4.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJugadas extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel labelJugadas;
	private JLabel labelJugador;
	
	public JTextField txtJugadas;
	public JTextField txtJugador;
	
	public PanelJugadas() 
	{
		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(500, 30));
		
		labelJugadas = new JLabel("Jugadas:");
		labelJugadas.setPreferredSize(new Dimension(50, 20));
		
		labelJugador = new JLabel("Jugador:");
		labelJugador.setPreferredSize(new Dimension(50, 20));
				
		txtJugadas = new JTextField("0");
		txtJugadas.setPreferredSize(new Dimension(100, 20));
		txtJugadas.setEditable(false);
		
		txtJugador = new JTextField();
		txtJugador.setPreferredSize(new Dimension(100, 20));
		txtJugador.setEditable(true);
		
		add(labelJugadas);
		add(txtJugadas);
		add(labelJugador);
		add(txtJugador);
	}
	
	public String getNombre() {
		String nombre = txtJugador.getText();
		return nombre;
	}
	
	public void setNombre(String nombre) {
		txtJugador.setText(nombre);
	}

	public int getJugadas() {
		int jugadas = Integer.parseInt(txtJugadas.getText());
		return jugadas;
	}
	
	public void setJugadas(String valor) {
		txtJugadas.setText(valor);
	}
}

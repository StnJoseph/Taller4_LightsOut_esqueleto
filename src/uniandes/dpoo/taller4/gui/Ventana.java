package uniandes.dpoo.taller4.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import uniandes.dpoo.taller4.modelo.Top10;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public Top10 top10;
	public VentanaTop10 top10jugadores;
	public PanelBotones panelBotones;
	public PanelDificultad panelDificultad;
	public PanelJugadas panelJugadas;
	public PanelTablero panelTablero;
	private static final File best = new File("Data\\top10.csv");

	
	public Ventana()
	{
		setLayout(new BorderLayout());
			
		top10 = new Top10();
		top10.cargarRecords(best);
		panelJugadas = new PanelJugadas();
		panelTablero = new PanelTablero(this, 5);
		panelDificultad = new PanelDificultad(this);
		panelBotones = new PanelBotones(this);
		
		add(panelDificultad, BorderLayout.NORTH);
		add(panelBotones, BorderLayout.EAST);
		add(panelJugadas, BorderLayout.SOUTH);
		add(panelTablero, BorderLayout.WEST);
		
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent x)
			{
				try {
					top10.salvarRecords(best);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		setSize(new Dimension(700,500));
		setResizable(false);
		setTitle("LightsOut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public PanelTablero getPanelTablero() {
		return panelTablero;
	}

	public void setPanelTablero(PanelTablero panelTablero) {
		this.panelTablero = panelTablero;		
	}
	
	public PanelBotones getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public PanelDificultad getPanelDificultad() {
		return panelDificultad;
	}

	public void setPanelDificultad(PanelDificultad panelDificultad) {
		this.panelDificultad = panelDificultad;
	}

	public PanelJugadas getPanelJugadas() {
		return panelJugadas;
	}

	public void setPanelJugadas(PanelJugadas panelJugadas) {
		this.panelJugadas = panelJugadas;
	}
	
	public Top10 getTop10() {
		return top10;
	}

	public void setTop10(Top10 top10) {
		this.top10 = top10;
	}

	public void cambiarTablero(int tamano) {
		remove(panelTablero);		
        setPanelTablero(new PanelTablero(this, tamano));
        add(panelTablero);
        revalidate();
        repaint();	
	}

	public void ventanaTop10() {
		VentanaTop10 top10jugadores = new VentanaTop10(this, true);
		top10jugadores.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		new Ventana();
	}
}

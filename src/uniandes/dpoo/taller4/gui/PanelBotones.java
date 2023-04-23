package uniandes.dpoo.taller4.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelBotones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonNuevo;
	private JButton botonReiniciar;
	private JButton botonTOP;
	private JButton botonCambiarJugador;

	
	public PanelBotones(Ventana papa) 
	{
		
		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(180, 50));
		
		botonNuevo = new JButton("NUEVO");
		botonNuevo.setPreferredSize(new Dimension(170, 20));
		botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
            	if (papa.panelJugadas.getNombre().isEmpty()==false) {
            		papa.panelJugadas.txtJugador.setEditable(false);
            		papa.getPanelTablero().getTablero().desordenar(papa.getPanelDificultad().getDificultad());;
                	papa.getPanelTablero().setTablero(papa.getPanelTablero().getTablero());
                	papa.getPanelTablero().pintarCasillas();
				}
        		                    
            }
        });
		
		botonReiniciar = new JButton("REINICIAR");
		botonReiniciar.setPreferredSize(new Dimension(170, 20));				
		botonReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             	
            	papa.getPanelTablero().getTablero().reiniciar();
            	papa.getPanelTablero().setTablero(papa.getPanelTablero().getTablero());
            	papa.getPanelTablero().cambiarJugadas();
            	papa.getPanelTablero().pintarCasillas();
            }
        });
		
		botonTOP = new JButton("TOP-10");
		botonTOP.setPreferredSize(new Dimension(170, 20));
		botonTOP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  papa.ventanaTop10();
            }
        });
				
		botonCambiarJugador = new JButton("CAMBIAR JUGADOR");
		botonCambiarJugador.setPreferredSize(new Dimension(170, 20));
		botonCambiarJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	papa.panelJugadas.txtJugador.setEditable(true);                	
            }
        });

		add(botonNuevo);
		add(botonReiniciar);
		add(botonTOP);
		add(botonCambiarJugador);
	}
}

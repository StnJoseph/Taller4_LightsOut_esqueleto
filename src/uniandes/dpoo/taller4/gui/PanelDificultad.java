package uniandes.dpoo.taller4.gui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDificultad extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private int dificultad = 3;
	private int tamano = 5;
	private String strTamano;
	private JLabel labelTamano;
	private JComboBox<String> listaTamanos;
	private JLabel labelDificultad;
	private JRadioButton botonFacil;
	private JRadioButton botonMedio;
	private JRadioButton botonDificil;
	private ButtonGroup grupoBotones;	
		
	public PanelDificultad(Ventana papa) 
	{					
		setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(500, 30));
		
		labelTamano = new JLabel("Tamaño:");
		labelTamano.setPreferredSize(new Dimension(50, 20));
		
		listaTamanos = new JComboBox<>(new String[]{"5x5","6x6","7x7"});
		listaTamanos.setPreferredSize((new Dimension(80, 20)));
		listaTamanos.addActionListener(new ActionListener() {						
            @Override
            public void actionPerformed(ActionEvent e) {
            	strTamano = (String) listaTamanos.getSelectedItem();                           	                
                if (strTamano=="5x5")   
                	tamano=5;
                	papa.cambiarTablero(tamano); 
                	//panelTablero.actualizarTablero(tamano);
                	
                if (strTamano=="6x6") 
                	tamano=6;
                	papa.cambiarTablero(tamano);
                	//panelTablero.actualizarTablero(tamano);
                	
                if (strTamano=="7x7") 
                	tamano=7;
                	papa.cambiarTablero(tamano);
                	//panelTablero.actualizarTablero(tamano);
                		
            }
        });
		
						
		labelDificultad = new JLabel("Dificultad:");
		labelDificultad.setPreferredSize(new Dimension(60, 20));
		
		botonFacil = new JRadioButton("Fácil",true);
		botonFacil.setPreferredSize(new Dimension(60, 20));
		botonFacil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setDificultad(5);
            }
        });
		
		
		botonMedio = new JRadioButton("Medio",false);
		botonMedio.setPreferredSize(new Dimension(60, 20));
		botonMedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setDificultad(10);
            }
        });
		
		botonDificil = new JRadioButton("Difícil",false);
		botonDificil.setPreferredSize(new Dimension(60, 20));
		botonDificil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setDificultad(15);
            }
        });		
		
		grupoBotones = new ButtonGroup();
		grupoBotones.add(botonFacil);
		grupoBotones.add(botonMedio);
		grupoBotones.add(botonDificil);	
		
		add(labelTamano);
		add(listaTamanos);
		add(labelDificultad);
		add(botonFacil);
		add(botonMedio);
		add(botonDificil);		

	}	
	
	
	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	
}

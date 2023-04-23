package uniandes.dpoo.taller4.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


public class PanelTablero extends JPanel implements ActionListener,MouseListener{	
		
	private static final long serialVersionUID = 1L;
	private int largo = 520;
	private int alto = 440;
	private String nombre;
	private int puntaje=0;
	private JLabel[][] tableroLabel;
	private Tablero tableroInit;
	private Ventana papa;
	
	public PanelTablero(Ventana papa, int tamano) 
	{			
		this.papa = papa;
		
		tableroLabel = new JLabel[tamano][tamano];
		tableroInit = new Tablero(tamano);
					
		setBorder(BorderFactory.createTitledBorder(""));
        setLayout(new GridLayout(tamano,tamano));               
        setPreferredSize(new Dimension(largo, alto));
        
        for (int i = 0; i < tamano; i++)
			for (int ii = 0; ii < tamano; ii++)
			{
				JLabel casilla = new JLabel(new ImageIcon("Data\\luz.png"));				
				casilla.setPreferredSize(new Dimension(largo/(tamano+10), alto/(tamano+10)));				
				casilla.addMouseListener(this);	
				casilla.setBackground(Color.orange);
				casilla.setOpaque(true);
				casilla.addMouseListener(new CambiarColorMouseListener(i,ii));
				tableroLabel[i][ii] = casilla;		        
				add(casilla);
			}
	}
	
	private class CambiarColorMouseListener extends MouseAdapter {
        private int fila;
        private int columna;

        public CambiarColorMouseListener(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            tableroInit.jugar(fila, columna);
            pintarCasillas();
            cambiarJugadas(); 
            
            if(tableroInit.tableroIluminado() && papa.panelJugadas.getNombre().isEmpty()==false) {
            	nombre = papa.panelJugadas.getName();
            	puntaje = tableroInit.darJugadas(); 
            	papa.top10.agregarRegistro(papa.panelJugadas.getName(), tableroInit.darJugadas());
            }
        }
	}
	
	public void pintarCasillas() {
		boolean[][] tablero = tableroInit.darTablero();
		
		for (int i=0; i<tablero.length; i++){
			for (int j=0; j<tablero.length; j++) {
				boolean casilla = tablero[i][j];
				if (casilla == false) {
					tableroLabel[i][j].setBackground(Color.lightGray);
				}
				else
					tableroLabel[i][j].setBackground(Color.orange);
			}
		}		
	}
	
	public void cambiarJugadas() {
		papa.panelJugadas.txtJugadas.setEditable(true);
		papa.panelJugadas.setJugadas(Integer.toString(tableroInit.darJugadas()));
		papa.panelJugadas.txtJugadas.setEditable(false);
	}
	
	public Tablero getTablero() {
		return tableroInit;
	}
	
	public void setTablero(Tablero tableroInit) {
		this.tableroInit = tableroInit;
	}

	public void actualizarTablero(int n) {
		
		new PanelTablero(papa, n);
        revalidate();
		repaint();
	}
	
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	
}	

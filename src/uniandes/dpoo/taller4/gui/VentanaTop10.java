package uniandes.dpoo.taller4.gui;

import java.util.Collection;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class VentanaTop10 extends JDialog{
	
	private static final long serialVersionUID = 1L;
    private int puesto=1;
	private Collection<RegistroTop10> registros;
	private JList<String> lista;
	private DefaultListModel<String> modelo;
	private JScrollPane barra;
	

	public VentanaTop10(Ventana papa, boolean modal) 
	{
        super(papa, modal);
        setSize(150, 220);
        setResizable(true);
        setTitle("Top 10");
        setLocationRelativeTo(papa);
        
        registros = papa.getTop10().darRegistros();                
        modelo = new DefaultListModel<>();
              
        modelo.addElement("# NOMBRE");
              
		for (RegistroTop10 registro : registros) {
			modelo.addElement(puesto+"..."+registro.darNombre()+"..."+registro.darPuntos());
			puesto++;
		}
	
		lista = new JList<>(modelo);
		barra = new JScrollPane(lista);
		
		add(barra);
           
    }
}

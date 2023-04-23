package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class PanelTop10 extends JDialog {
	private Top10 top= new Top10();
	private File archivo= new File ("../Taller4_LightsOut_esqueleto\\data\\top10.csv");
	private String stringRecords[]= new String [10]; 
	private VentanaPrincipal padre;
	
	public PanelTop10(VentanaPrincipal papa){
		this.padre=papa;
		
		
		setVisible (true);
		setPreferredSize((new Dimension(200,400)));
		setResizable(true);
		setTitle("REDIMENSIONAR PARA VER EL TOP 10");
		top.cargarRecords(archivo);
		Collection<RegistroTop10> registros = top.darRegistros();
		Iterator<RegistroTop10> iterador = registros.iterator();
		int i=0;
		while (iterador.hasNext()) {
		    RegistroTop10 registroActual = iterador.next();
		   stringRecords[i]= registroActual.toString();
		   i+=1;
		}
		 
		JList listaTop= new JList(stringRecords);
		listaTop.setPreferredSize(new Dimension (300,600));
		JScrollPane scrollPane = new JScrollPane(listaTop);
		scrollPane.setPreferredSize(new Dimension (320,620));
		add (scrollPane);
	
	}

	public void checarTop10(int puntaje) throws FileNotFoundException, UnsupportedEncodingException {
		
		if (top.esTop10(puntaje)) {
			
			String nombre= padre.pedirNombre();
			top.agregarRegistro(nombre, puntaje);
			top.salvarRecords(archivo);
		}
		// TODO Auto-generated method stub
		
	}
	

}

package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEste extends JPanel implements ActionListener{
	private VentanaPrincipal padre;
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiarJugadores;
	
	PanelEste(VentanaPrincipal papa){
		this.padre= papa;
		
	GridLayout layout= new GridLayout(6,1);
	layout.setVgap(50);
	setLayout(layout);
	setPreferredSize(new Dimension (200,600));
	
	nuevo= new JButton("Nuevo");
	nuevo.setBackground(new Color(61, 140, 215 ));
	nuevo.setPreferredSize(new Dimension (200,50));
	nuevo.addActionListener(this);
	nuevo.setActionCommand("nuevo");
	
	reiniciar= new JButton("Reiniciar");
	reiniciar.setBackground(new Color(61, 140, 215 ));
	reiniciar.setPreferredSize(new Dimension (200,50));
	reiniciar.addActionListener(this);
	reiniciar.setActionCommand("reiniciar");
	
	top10= new JButton("Top 10");
	top10.setBackground(new Color(61, 140, 215 ));
	top10.setPreferredSize(new Dimension (200,50));
	top10.addActionListener(this);
	top10.setActionCommand("top10");
	
	cambiarJugadores= new JButton("Cambiar Jugadores");
	cambiarJugadores.setBackground(new Color(61, 140, 215 ));
	cambiarJugadores.setPreferredSize(new Dimension (200,50));
	cambiarJugadores.addActionListener(this);
	cambiarJugadores.setActionCommand("cambiarJugadores");
	
	JLabel label= new JLabel("");
	label.setPreferredSize(new Dimension(200,100));
	
	JLabel label2= new JLabel("");
	label2.setPreferredSize(new Dimension(200,100));
	
	add (label);
	add(nuevo);
	add(reiniciar);
	add(top10);
	add(cambiarJugadores);
	add(label2);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals("nuevo")) {
			padre.nuevo();
		}
		else if (grito.equals("top10")){padre.top10();}
		else if (grito.equals("reiniciar")) {padre.reiniciar();}
		else if (grito.equals("cambiarJugadores")){padre.cambiarJugadores();};
		
	}
	
	
}

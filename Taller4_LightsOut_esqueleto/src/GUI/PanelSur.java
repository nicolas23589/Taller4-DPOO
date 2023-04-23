package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSur extends JPanel {
	private JLabel jugadas;
	private JTextField tJugadas;
	private JLabel jugador;
	private JTextField tJugador;
	private JLabel avisos;
	private JLabel avisosR;
	
	public PanelSur() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension (900,100));
		
		jugadas= new JLabel("Jugadas: ");
		jugadas.setPreferredSize(new Dimension (100,50));
		
		tJugadas= new JTextField ("0");
		tJugadas.setPreferredSize(new Dimension (100,50));
		
		jugador= new JLabel("Jugador: ");
		jugador.setPreferredSize(new Dimension (100,50));
		
		tJugador= new JTextField ("AAA");
		tJugador.setPreferredSize(new Dimension (100,50));
		
		avisos = new JLabel ("Jugador: AAA");
		avisos.setVisible(true);
		avisos.setPreferredSize(new Dimension (320,100));
		
	
		
		add(jugadas);
		add(tJugadas);
		add(jugador);
		add(tJugador);
		add (avisos);
		
		
		
	}
	public void actualizarJugadas(int jugadas) {
		this.tJugadas.setText(Integer.toString(jugadas));
	}
	public void gano () {
		avisos.setText("¡FELICIDADES! ha ganado, las luces están encendidas");
	}
	public void cambiarJugadores() {
		avisos.setText("Cambiando jugador a: " + tJugador.getText());
		avisos.setText ("El jugador se ha cambiado correctamente a: " + tJugador.getText() );
	}
	public String darNombre() {
		// TODO Auto-generated method stub
		return this.tJugador.getText();
	}
	
	
}

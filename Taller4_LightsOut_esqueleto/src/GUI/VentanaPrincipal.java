package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class VentanaPrincipal extends JFrame{
	
	private Cuadricula cuadricula;
	private PanelNorte panelNorte;
	private PanelEste panelEste;
	private PanelSur panelSur;
	private PanelTop10 panelTop10;
	
	

	public VentanaPrincipal() throws IOException {
	setLayout(new BorderLayout());
	setVisible(true);
	setSize(new Dimension (900,800));
	setTitle("Lights Out. ATENCIÓN:  DEBE REDIMENSIONAR LA VENTANA PARA USAR EL PROGRAMA CORRECTAMENTE");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	
	 cuadricula= new Cuadricula (3, this);
	cuadricula.setPreferredSize(new Dimension (600,600));
	add(cuadricula, BorderLayout.CENTER);
	
	 panelNorte= new PanelNorte();
	panelNorte.setPreferredSize(new Dimension (900,70));
	add(panelNorte, BorderLayout.NORTH);
	
	 panelEste= new PanelEste(this);
	add(panelEste, BorderLayout.EAST);
	panelEste.setPreferredSize(new Dimension (300,600));
	
	 panelSur= new PanelSur();
	add(panelSur, BorderLayout.SOUTH);
	panelSur.setPreferredSize(new Dimension (900,100));
	
	panelTop10= new PanelTop10(this);
	panelTop10.setVisible(false);
	panelTop10.setPreferredSize(new Dimension (330,630));
	
	nuevo();
	
	
	}
	
	public void nuevo() {
		int dificicultad= this.panelNorte.darDificultad();
		int nuevotamanio= this.panelNorte.darTamanio();
		cuadricula.setTamanio(nuevotamanio);
		cuadricula.nuevo(dificicultad);
	}

	@SuppressWarnings("deprecation")
	public void top10() {
		
		panelTop10.show(true);;
	}
	public void reiniciar() {
		cuadricula.reiniciar();

	}
	public void actualizarJugadas(int jugadas) {
		panelSur.actualizarJugadas(jugadas);
	}
	
	public void cambiarJugadores() {
		panelSur.cambiarJugadores();
	}
	public String pedirNombre () {
		return panelSur.darNombre();
	}
	public void gano(int puntos) throws FileNotFoundException, UnsupportedEncodingException {
		panelSur.gano();
		panelTop10.checarTop10(puntos);
	}
	
	
	public static void main(String[] args) throws IOException {
		VentanaPrincipal vc = new VentanaPrincipal();
	}



	

}

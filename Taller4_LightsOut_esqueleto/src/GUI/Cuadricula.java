package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Cuadricula extends JPanel {
	private EventosDeRaton eventos;
	private int tamanio;
	private Image image;
	private VentanaPrincipal padre;
	public void setTamanio(int nuevoTamanio) {
		this.tamanio= nuevoTamanio;
	}
	public Cuadricula (int tamanio, VentanaPrincipal papa) throws IOException {
		
		this.tamanio= tamanio;
		this.eventos= new EventosDeRaton (tamanio, this);
		this.padre= papa;
	setPreferredSize(new Dimension (600,600));
	
	image = ImageIO.read(new File ("../Taller4_LightsOut_esqueleto\\data\\luz.png"));

	addMouseListener(eventos);
	}
	
	public void paint(Graphics g) {
		
		//addMouseListener(eventos);
		
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255,241,118));
		
		int tamanioCuadrados;
		if (tamanio==3) {tamanioCuadrados= 196;}
		else if (tamanio==5) {tamanioCuadrados= 116;}
		else {tamanioCuadrados= 71;}//tamanio= 8
		
		ArrayList<ArrayList<RoundRectangle2D.Double>> listaCasillas= new ArrayList<ArrayList<RoundRectangle2D.Double>> ();
		int x=0;
		int y=0;
		
		for (int j=0; j<tamanio; j++) {
			x=0;
			ArrayList<RoundRectangle2D.Double> l1= new ArrayList<RoundRectangle2D.Double>();
			
			for (int i=0; i<tamanio; i++) {
			
			l1.add(new RoundRectangle2D.Double (x,y,tamanioCuadrados,tamanioCuadrados,10,10));
			x+= (tamanioCuadrados+4);
			}
			listaCasillas.add(l1);
			y+= (tamanioCuadrados+4);
		}
		Tablero tableroActual= eventos.darTablero();
		boolean[][] tablerodef= tableroActual.darTablero();
		
		for (int x2=0; x2<tamanio; x2++) {
			
			for (int y2=0; y2<tamanio; y2++) {
				if (tablerodef[x2][y2]==false) {
					g2d.setColor(new Color(255,241,118)); 
					}
				else {g2d.setColor(new Color (54, 64, 73));};
				g2d.fill(listaCasillas.get(x2).get(y2));
			}
		}
		for (int t=0; t<tamanio; t++) {
			for (int t2=0; t2<tamanio; t2++) {
			g2d.drawImage(image, (t*tamanioCuadrados+8)+((tamanioCuadrados+8)/2)-25, (t2*tamanioCuadrados+8)+((tamanioCuadrados+8)/2)-25, getFocusCycleRootAncestor());
			}
			
		}
		//repaint();
}

	public void nuevo(int dificultad) {
		eventos.setTamanio(tamanio);
		eventos.nuevo(dificultad);
	}
	public void reiniciar() {
		eventos.reiniciar();
	}
	public void actualizarJugadas(int jugadas) {
		padre.actualizarJugadas(jugadas);
	}
	public void gano(int puntos) throws FileNotFoundException, UnsupportedEncodingException {
		padre.gano(puntos);
	}
}



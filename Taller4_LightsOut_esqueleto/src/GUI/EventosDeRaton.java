package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import uniandes.dpoo.taller4.modelo.Tablero;

public class EventosDeRaton implements MouseListener{
	private int tamanio;
	private Tablero tablero;
	private Cuadricula padre;
	
	public EventosDeRaton (int tamanio, Cuadricula papa) {
		this.tamanio=tamanio;
		padre=papa;
		this.tablero= new Tablero(tamanio);
	}

	public Tablero darTablero(){
		return this.tablero;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	int click_x = e.getX();
	int click_y = e.getY();
	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	//cantidades[casilla[0]][casilla[1]]++;
	tablero.jugar(casilla[0], casilla[1]);
	padre.repaint();
	padre.actualizarJugadas(tablero.darJugadas());
	boolean gano =checarVictoria();
	if (gano) { int puntos= tablero.calcularPuntaje();
		try {
			padre.gano(puntos);
		} catch (FileNotFoundException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				 
				}
	
	//this.ultima_fila = casilla[0];
	//this.ultima_columna = casilla[1];
	
	}
	private boolean checarVictoria() {
		for (int i=0; i<tamanio; i++) {
			for (int j=0; j<tamanio; j++) {
				if (tablero.darTablero()[i][j]== true) {
					return false;
					
				} 
			}
		}
		return true;
	}

	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tamanio;
	int altoPanelTablero = 600;
	int anchoPanelTablero = 600;
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void nuevo(int dificultad) {
		tablero= new Tablero (this.tamanio);
		tablero.tableroIluminado();
		tablero.desordenar(dificultad);
		padre.repaint();
		padre.actualizarJugadas(0);
	}

	public void setTamanio(int tamanio) {
	this.tamanio=tamanio;
	}
	
	public void reiniciar() {
		tablero.reiniciar();
		padre.actualizarJugadas(0);
		padre.repaint();
	}
	
}

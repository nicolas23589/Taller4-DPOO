package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class PanelNorte extends JPanel implements ActionListener{
	
	private JLabel tamanio;
	private JComboBox<String> comboTamanio;
	private JLabel dificultad;
	private JRadioButton facil;

	private JRadioButton medio;

	private JRadioButton dificil;

	
	public PanelNorte(){
		setPreferredSize(new Dimension (899,100));
		setBackground(new Color(61, 140, 215 ));
		setLayout (new FlowLayout());
		setVisible (true);
		
		tamanio = new JLabel("Tamaño: ");
		tamanio .setPreferredSize(new Dimension(70, 50));
		
		comboTamanio= new JComboBox<String>();
		comboTamanio.addItem("3x3");
		comboTamanio.addItem("5x5");
		comboTamanio.addItem("8x8");
		comboTamanio .setPreferredSize(new Dimension(70, 50));
		
		dificultad= new JLabel("Dificultad: ");
		dificultad.setPreferredSize(new Dimension(70,50));
		
		facil= new JRadioButton("Fácil");
		facil.setPreferredSize(new Dimension(150,50));
		facil.setBackground(new Color(61, 140, 215 ));
		facil.addActionListener(this);
		facil.setActionCommand("facil");
		facil.setSelected(true);
		
		medio= new JRadioButton("Medio");
		medio.setPreferredSize(new Dimension(150,50));
		medio.setBackground(new Color(61, 140, 215 ));
		medio.addActionListener(this);
		medio.setActionCommand("medio");
		
		
		dificil= new JRadioButton("Difícil");
		dificil.setPreferredSize(new Dimension(150,50));
		dificil.setBackground(new Color(61, 140, 215 ));
		dificil.addActionListener(this);
		dificil.setActionCommand("dificil");


		
		add(tamanio);
		add(comboTamanio);
		add(dificultad);
		add (facil);
		add (medio);
		add (dificil);


		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals("facil")) {
			medio.setSelected(false);;
			dificil.setSelected(false);
		}
		else if(grito.equals("medio")) {
			facil.setSelected(false);;
			dificil.setSelected(false);
		}
		else{ //dificil
			facil.setSelected(false);;
			medio.setSelected(false);
		}
		
	}
	public int darDificultad() {
		if (facil.isSelected()) {
			return 1;
		}
		else if (facil.isSelected()) {
			return 2;
		}
		else {
			return 3;
		}
		
	}
	public int darTamanio() {
		if (comboTamanio.getSelectedItem().equals("3x3")) {
			return 3;
		}
		else if (comboTamanio.getSelectedItem().equals("5x5")) {
			return 5;
		}
		else {return 8;}
	}

}

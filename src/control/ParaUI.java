package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.GestionDatos;
import view.UI;

public class ParaUI extends UI{
	GestionDatos gestion;
	private ActionListener botonBehaviour;
	public ParaUI() {
		super();
		//INIT GESTION, Y ALTO Y ANCHO DE TABLERO
		gestion = new GestionDatos(getBotones().length, getBotones()[0].length);
		printTablero();
		botonBehaviour = createBehaviour();
		recorrerBotonesYaddComp();
		
	}
	
	public ActionListener createBehaviour() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gestion.hacerMovimiento(((MyButton)e.getSource()).getPosY(), ((MyButton)e.getSource()).getPosX());
				printTablero();
			}
		};
	}
	
	
	
	public void recorrerBotonesYaddComp() {
		for(int y=0;y<getBotones().length;y++) {
			for(int x=0;x<getBotones()[0].length;x++) {
				getBotones()[y][x].addActionListener(botonBehaviour);
			}
		}
	}
	
	public void printTablero() {
		for(int y=0;y<getBotones().length;y++) {
			for(int x=0;x<getBotones()[0].length;x++) {
				getBotones()[y][x].setText(Integer.toString(gestion.getTablero().getTablero()[y][x]));
				
				//SI ES EL ULTIMO VALOR
				if(Integer.parseInt(getBotones()[y][x].getText()) == gestion.getTablero().getUltimaPosValor()) {
					getBotones()[y][x].setText("");
				}
			}
		}
	}
	

}

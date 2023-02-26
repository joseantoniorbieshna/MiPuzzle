package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import modelo.GestionDatos;
import modelo.MyImagen;
import view.UI;

public class ParaUI extends UI{
	GestionDatos gestion;
	private ActionListener botonBehaviour;
	private MyImagen imagen = new MyImagen();
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
				int numeroValorTablero = gestion.getTablero().getTablero()[y][x];
				getBotones()[y][x].setValue(numeroValorTablero);
				
				//SCALE IMAGE
				Image scaleImg = this.imagen.getSplitImage()[numeroValorTablero-1].getScaledInstance((int)Math.round(getPanel().getWidth()/3), (int)Math.round(getPanel().getHeight()/3), Image.SCALE_DEFAULT);
				getBotones()[y][x].setIcon(new ImageIcon(scaleImg));
				
				//SI ES EL ULTIMO VALOR
				if(getBotones()[y][x].getValue() == gestion.getTablero().getUltimaPosValor()&& !gestion.hasGanado()) {
					getBotones()[y][x].setIcon(null);
				}
			}
		}
	}
	

}

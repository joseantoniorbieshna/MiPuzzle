package modelo;

import java.util.Random;

public class Tablero {
	private int [][] tablero;
	private int ancho;
	private int alto;
	private int ultimaPosValor;
	public static int numActual=1;
	
	public Tablero(int ancho,int alto) {
		this.ancho=ancho;
		this.alto=alto;
		this.ultimaPosValor = ancho*alto;
		tablero = new int[alto][ancho];
		//GENERAR TABLERO
		for(int y=0;y<tablero.length;y++) {
			for(int x=0;x<tablero[0].length;x++) {
				this.tablero[y][x] = numActual;
				//SUMAR 1 VALOR
				numActual++;
			}
		}
	}
	public void mixTablero() {
		Random rand = new Random();
		
		//numero de iteraciones de mezclado
		for(int numMixeo=0;numMixeo<15;numMixeo++) {
			//GENERAR POS RANDOM
			int pos1[] = {rand.nextInt(tablero.length),rand.nextInt(tablero[0].length)};
			int pos2[] = {rand.nextInt(tablero.length),rand.nextInt(tablero[0].length)};
			//GUARDAR VALOR POS 1
			int guardado = tablero[pos1[0]][pos1[1]];
			this.tablero[ pos1[0]] [pos1[1] ] = this.tablero[ pos2[0]] [pos2[1] ];
			this.tablero[ pos2[0]] [pos2[1] ] = guardado;
		}
		
	}
	
	public int[][] getTablero() {
		return tablero;
	}
	
	public int getUltimaPosValor() {
		return ultimaPosValor;
	}
	
	public int[] getPosUltimaFicha() {
		for(int y=0;y<tablero.length;y++) {
			for(int x=0;x<tablero[0].length;x++) {
				if(tablero[y][x]==ultimaPosValor) {
					return new int[]{y,x};
				}
			}
		}
		return null;
	}
	
	
	
}

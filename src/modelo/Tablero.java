package modelo;

import java.util.Random;

public class Tablero {
	private int[][] tablero;
	private int ancho;
	private int alto;
	private int ultimaPosValor;
	public static int numActual = 1;

	public Tablero(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		this.ultimaPosValor = ancho * alto;
		tablero = new int[alto][ancho];
		// GENERAR TABLERO
		for (int y = 0; y < tablero.length; y++) {
			for (int x = 0; x < tablero[0].length; x++) {
				this.tablero[y][x] = numActual;
				// SUMAR 1 VALOR
				numActual++;
			}
		}
	}

	public void mixTablero() {
		//NO PUEDO HACER SWAP ALEATORIOS PORQUE SI NO PODRÍA HACER UN MOVIMIENTO ILEGAL
		//HE OPTADO POR ESTO
		Random rand = new Random();
		for (int rep = 0; rep < 50; rep++) {
			int[][] posicionesComprobar = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0,-1 } };
			int contadorPosibilidades = 0;
			// CONTAR CUANTAS FICHAS HAY DE POSIBLES MOVIMIENTOS, (PARA DAR TAMAÑO AL ARRAY)"HASTA QUE DEMOS ARRAY LIST"
			for (int i = 0; i < 4; i++) {
				//COMPROBAR SI EL MOVIMIENTOS ES POSIBLE
				if ((getPosUltimaFicha()[0] + posicionesComprobar[i][0]) < 3 && (getPosUltimaFicha()[1] + posicionesComprobar[i][1]) < 3 &&
				(getPosUltimaFicha()[0] + posicionesComprobar[i][0]) >= 0 && (getPosUltimaFicha()[1] + posicionesComprobar[i][1]) >= -1){
					contadorPosibilidades++;
				}
			}
			// ALMACENAR POS DE LOS MOVIMIENTOS POSIBLES
			int[][] posGuardadas = new int[contadorPosibilidades][2];
			int contador = 0;
			for (int i = 0; i < posicionesComprobar.length && contador < contadorPosibilidades; i++) {
				//COMPROBAR SI EL MOVIMIENTOS ES POSIBLE Y ALMACENAR POS
				if ((getPosUltimaFicha()[0] + posicionesComprobar[i][0]) < 3 && (getPosUltimaFicha()[1] + posicionesComprobar[i][1]) < 3 &&
						(getPosUltimaFicha()[0] + posicionesComprobar[i][0]) >= 0 && (getPosUltimaFicha()[1] + posicionesComprobar[i][1]) >= 0){
					posGuardadas[contador][0] = getPosUltimaFicha()[0] + posicionesComprobar[i][0];
					posGuardadas[contador][1] = getPosUltimaFicha()[1] + posicionesComprobar[i][1];
					contador++;
				}
			}
			int posMover[] = posGuardadas[rand.nextInt(posGuardadas.length)];
			// SWAP FICHAS
			int guardado = tablero[getPosUltimaFicha()[0]][getPosUltimaFicha()[1]];
			this.tablero[getPosUltimaFicha()[0]][getPosUltimaFicha()[1]] = tablero[posMover[0]][posMover[1]];
			this.tablero[posMover[0]][posMover[1]] = getUltimaPosValor();
		}
	}

	public int[][] getTablero() {
		return tablero;
	}

	public int getUltimaPosValor() {
		return ultimaPosValor;
	}

	public int[] getPosUltimaFicha() {
		for (int y = 0; y < tablero.length; y++) {
			for (int x = 0; x < tablero[0].length; x++) {
				if (tablero[y][x] == ultimaPosValor) {
					return new int[] { y, x };
				}
			}
		}
		return null;
	}

}

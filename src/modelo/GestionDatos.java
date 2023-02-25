package modelo;

import java.awt.Color;

public class GestionDatos {
	private Tablero tablero;
	private boolean hasGanado = false;

	public GestionDatos(int alto, int ancho) {
		this.tablero = new Tablero(alto, ancho);
		this.tablero.mixTablero();
	}

	public void hacerMovimiento(int posY, int posX) {
		if (comprobarPosibleMover(posY, posX) && !hasGanado) {
			// MOVER FICHA SELEC
			int[] posUltimafichaGuardado = tablero.getPosUltimaFicha();
			this.tablero.getTablero()[tablero.getPosUltimaFicha()[0]][tablero.getPosUltimaFicha()[1]] = this.tablero.getTablero()[posY][posX];
			this.tablero.getTablero()[posY][posX] = this.tablero.getUltimaPosValor();
			
			if(comprobarGanas()) {
				System.out.println("HAS GANADO!!");
				hasGanado=true;
			}
			
		}

	}

	public Tablero getTablero() {
		return tablero;
	}

	public boolean comprobarPosibleMover(int posY, int posX) {
		int diferenciaY = tablero.getPosUltimaFicha()[0] - posY;
		int diferenciaX = tablero.getPosUltimaFicha()[1] - posX;
		return (diferenciaY == 1 || diferenciaY == -1) && diferenciaX == 0
				|| (diferenciaX == 1 || diferenciaX == -1) && diferenciaY == 0;
	}

	public boolean comprobarGanas() {
		boolean hasGanado = true;
		int contador = 1;
		for (int y = 0; y < this.tablero.getTablero().length && hasGanado; y++) {
			for (int x = 0; x < this.tablero.getTablero()[0].length && hasGanado; x++) {
				if (tablero.getTablero()[y][x] != contador) {
					hasGanado = false;
					return hasGanado;
				}
				contador++;
			}
		}
		return hasGanado;

	}
	public boolean hasGanado() {
		return hasGanado;
	}
}

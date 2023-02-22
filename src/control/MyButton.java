package control;

import javax.swing.JButton;
public class MyButton extends JButton {
	private int posX;
	private int posY;
	public MyButton(int posY,int posX) {
		super("");
		this.posX=posX;
		this.posY=posY;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	

}

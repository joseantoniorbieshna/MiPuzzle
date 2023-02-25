package modelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MyImagen {
	boolean isLoaded=false;
	private BufferedImage Myimagen;
	private BufferedImage [] splitImage = new BufferedImage[9];
	
	public MyImagen() {
		File file = new File("src/modelo/2.jpg");
		try {
			this.Myimagen = ImageIO.read(file);
			isLoaded=true;
			
			int widhtSizeSplitImage = (int)Math.round(Myimagen.getWidth()/3);
			int heightSizeSplitImage = (int)Math.round(Myimagen.getHeight()/3);
			System.out.println(widhtSizeSplitImage+"   "+ heightSizeSplitImage);
			int separarXsizeAcum = 0;
			int separarYsizeAcum = 0;
			//HACER ARRAY IMAGEN
			for(int y=0, contador=0;y<3;y++) {
				separarXsizeAcum=0;
				for(int x=0;x<3;x++,contador++) {
					splitImage[contador] = Myimagen.getSubimage(separarXsizeAcum, separarYsizeAcum, widhtSizeSplitImage, heightSizeSplitImage);
					separarXsizeAcum += widhtSizeSplitImage;
				}
				separarYsizeAcum += heightSizeSplitImage;
			}
		} catch (Exception e) {
			System.out.println("ERROR AL CARGAR LA IMAGEN.");
		}
		
		
	}

	public boolean isLoaded() {
		return isLoaded;
	}

	public BufferedImage[] getSplitImage() {
		return splitImage;
	}

	public Image getMyimagen() {
		return Myimagen;
	}
	
	
}

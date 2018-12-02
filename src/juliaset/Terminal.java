package juliaset;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Terminal {
	public Terminal(String[] args) {
		
		DrawZone drawzone = new DrawZone();
		BufferedImage image = new BufferedImage(getPositiveInt(args[0]), getPositiveInt(args[1]), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setBackground(Color.red);
		drawzone.drawImage(image);		
		g.drawImage(image, 0, 0, null);
		try {
			ImageIO.write((RenderedImage) image, "PNG", 
			new File(System.getProperty("user.dir") + File.separator + "Julia set.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	int getPositiveInt (String arg)
	{
		int res = -1;
		try {
			res = Integer.parseUnsignedInt(arg);
		} catch (NumberFormatException e) {
			System.err.println("Il faut ecrire un nombre positif !");
			System.exit(1);
		}
		return res;
	}
}

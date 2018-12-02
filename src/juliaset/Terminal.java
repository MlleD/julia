package juliaset;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Terminal {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	public Terminal(String[] args) {
		
		DrawZone drawzone = new DrawZone();
		
		int height = getDimension(args[0], Terminal.DEFAULT_HEIGHT);
		int width = getDimension(args[1], Terminal.DEFAULT_WIDTH);
		BufferedImage image = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
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
	private int getPositiveInt (String arg)
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
	/**
	 * Obtenir la String a ecrire pour utiliser la valeur par default
	 * @return String a ecrire pour utiliser la valeur par default
	 */
	public static String useDefaultMode ()
	{
		return "d";
	}
	private int getDimension (String arg, int defaultVal)
	{
		return arg.equalsIgnoreCase(Terminal.useDefaultMode()) ? defaultVal : getPositiveInt(arg);
	}
}

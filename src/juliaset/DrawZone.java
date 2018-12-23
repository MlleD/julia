package juliaset;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe représentant la zone de dessin de la fenêtre graphique.
 * 
 * @author Adrien Cavalieri
 * @author Dorothée Hyunh
 * @version 1.0
 */
public class DrawZone extends JPanel
{
	private Complex c;
	private Complex x0;
	private int maxIter;
	
	private static Complex C_DEFAULT = new Complex(-0.7, 0.27015);
	
	private double zoom;
	private double moveX;
	private double moveY;
	
	private BufferedImage image;
	
	/**
	 * Constructeur par défaut de la classe.
	 */
	public DrawZone()
	{
		this(DrawZone.getDefaultComplex());
	}

	/**
	 * Constructeur membres à membres de la classe.
	 * 
	 * @param c Un nombre complexe
	 */
	public DrawZone(Complex c) 
	{
		this.c = c;
		this.x0 = new Complex();
		this.maxIter = 300;

		this.zoom = 1;
		this.moveX = 0;
		this.moveY = 0;
	}

	/**
	 * Accesseur du niveau de zoom.
	 * 
	 * @return Le niveau de zoom.
	 */
	public double getZoom()
	{
		return this.zoom;
	}
	
	/**
	 * Mutateur du niveau de zoom.
	 * 
	 * @param zoom Niveau de zoom
	 */
	public void setZoom(double zoom)
	{
		if (zoom > 0)
			this.zoom = zoom;
	}
	
	/**
	 * Accesseur du niveau de décalage horizontal.
	 * 
	 * @return Le niveau de décalage horizontal
	 */
	public double getMoveX()
	{
		return moveY;
	}
	
	/**
	 * Mutateur du niveau de décalage horizontal.
	 * 
	 * @param moveX Niveau de décalage horizontal
	 */
	public void setMoveX(double moveX)
	{
		this.moveX = moveX;
	}
	
	/**
	 * Accesseur du niveau de décalage vertical.
	 * 
	 * @return Le niveau de décalage vertical
	 */
	public double getMoveY()
	{
		return moveY;
	}
	
	/**
	 * Mutateur du niveau décalage vertical
	 * 
	 * @param moveY Niveau de décalage vertical
	 */
	public void setMoveY(double moveY)
	{
		this.moveY = moveY;
	}
	
	/**
	 * Mutateur du nombre complexe.
	 * 
	 * @param c Nombre complexe
	 */
	public void setC(Complex c)
	{
		this.c = c;
	}

	/**
	 * Méthode retournant le nombre complexe par défaut.
	 * 
	 * @return Le nombre complexe par défaut.
	 */
	public static Complex getDefaultComplex()
	{
		return DrawZone.C_DEFAULT;
	}

	/**
	 * Méthode permettant de dessiner l'ensemble de Julia.
	 * 
	 * @param image Image sur laquelle l'ensemble de Julia doit être dessiné
	 */
	public void drawImage(BufferedImage image)
	{
		for (int i = 0; i < image.getWidth(); i++) 
		{
			for (int j = 0; j < image.getHeight(); j++) 
			{
				// Initialisation de x0.
				double real = 1.5 * (i - image.getWidth() / 2) / (0.5 * zoom * image.getWidth()) + moveX;
				double imaginary = (j - image.getHeight() / 2) / (0.5 * zoom * image.getHeight()) + moveY;
				x0 = new Complex(real, imaginary);

				// Appel de divergenceIndex.
				float iter = QuadraticJuliaSet.divergenceIndex(x0, c, maxIter);
				
				// Colorisation.
				image.setRGB(i, j, Color.HSBtoRGB((maxIter / iter) % 1, 1, 
						iter > 0 ? 1 : 0));
			}
		}
	}
	
	/**
	 * Méthode permettant de sauvegarder l'ensemble de Julia dans un fichier image.
	 * 
	 * @throws IOException
	 */
	public void saveToFile() throws IOException
	{
        ImageIO.write(image, "PNG", new File(System.getProperty("user.home") + File.separator + "Julia set.png"));
    }
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D gg = (Graphics2D) g;
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		drawImage(image);
		gg.drawImage(image, 0, 0, null);
	}
}


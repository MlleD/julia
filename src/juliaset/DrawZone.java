package juliaset;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawZone extends JPanel
{
	private Complex c;
	private Complex x0;
	
	private double zoom;
	private double moveX;
	private double moveY;
	
	private int width;
	private int height;
	private BufferedImage image;
	
	private final int maxIter = 300;
	
	public DrawZone()
	{
		this.c = new Complex(-0.7, 0.27015);
		this.x0 = new Complex();
		
		this.zoom = 1;
		this.moveX = 0;
		this.moveY = 0;
	}
	
	public double getZoom()
	{
		return this.zoom;
	}
	
	public void setZoom(double zoom)
	{
		if (zoom > 0)
			this.zoom = zoom;
	}
	
	public double getMoveX()
	{
		return moveY;
	}
	
	public void setMoveX(double moveX)
	{
		this.moveX = moveX;
	}
	
	public double getMoveY()
	{
		return moveY;
	}
	
	public void setMoveY(double moveY)
	{
		this.moveY = moveY;
	}
	
	public void setC(Complex c)
	{
		this.c = c;
	}
	
	private void drawQuadraticJuliaSet(Graphics2D gg) 
	{
		width = getWidth();
		height = getHeight();
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		 
		double real, imaginary; // Déclaration de x0.
	        
		for (int i = 0; i < width; i++) 
		{
			for (int j = 0; j < height; j++) 
			{
				// Initialisation de x0.
				real = 1.5 * (i - width / 2) / (0.5 * zoom * width) + moveX;
				imaginary = (j - height / 2) / (0.5 * zoom * height) + moveY;
				x0 = new Complex(real, imaginary);
	            
				// maxIteration
				float iter = maxIter; 
	                
				// divergenceIndex
				while (x0.modulus() <= 2 && iter-- > 0) 
					x0 = c.plus(x0.times(x0));
				
				// Colorisation.
				image.setRGB(i, j, Color.HSBtoRGB((maxIter / iter) % 1, 1, 
						iter > 0 ? 1 : 0));
			  }
		 }
		
		gg.drawImage(image, 0, 0, null); 
	}
	
	public void saveToFile() throws IOException
	{
        ImageIO.write(image, "PNG", new File(System.getProperty("user.home") + File.separator + "Julia set.png"));
    }
	
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D gg = (Graphics2D) g;
		drawQuadraticJuliaSet(gg);
	}
}


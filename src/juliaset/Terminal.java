package juliaset;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class Terminal 
{
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	public Terminal(String[] args) 
	{
		
		Number[] ar = checkArguments(args);		
		BufferedImage image = new BufferedImage(ar[0].intValue(), ar[1].intValue(), BufferedImage.TYPE_INT_RGB);
		DrawZone drawzone = new DrawZone(getComplex(args[2]));
		Graphics2D g = image.createGraphics();
		g.setBackground(Color.red);
		drawzone.drawImage(image);		
		g.drawImage(image, 0, 0, null);
		
		try 
		{
			ImageIO.write((RenderedImage) image, "PNG", 
			new File(System.getProperty("user.dir") + File.separator + "Julia set.png"));
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
		catch (NullPointerException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifie les arguments (type, valeur) passes en parametre
	 * 
	 * @param args : arguments
	 * @return number : conversion de args en nombres
	 */
	private Number[] checkArguments(String[] args)
	{
		if (args.length != 3) 
		{
			System.err.println("Argument error : term <height> <width> <complex : " + Terminal.useDefaultMode() + " or real!imaginary without any space>");
			System.err.println("Write "  + Terminal.useDefaultMode() +  " to use the default value)");
			System.exit(1);
		}
		
		int height = getDimension(args[0], Terminal.DEFAULT_HEIGHT);
		int width = getDimension(args[1], Terminal.DEFAULT_WIDTH);
		Number[] ar = {height, width};
		
		return ar;
	}
	
	private int getPositiveInt (String arg)
	{
		int res = -1;
		
		try 
		{
			res = Integer.parseUnsignedInt(arg);
		} 
		
		catch (NumberFormatException e) 
		{
			System.err.println("A positive integer must be written instead of "+ arg + "!");
			System.exit(1);
		}
		
		return res;
	}
	
	private double getDouble (String arg)
	{
		double res = -1.0;
		
		try 
		{
			res = Double.parseDouble(arg);
		} 
		
		catch (NumberFormatException e) 
		{
			System.err.println("A decimal number must be written instead of "+ arg +"!");
			System.exit(1);
		}
		
		return res;
	}
	
	/**
	 * Obtenir la String a ecrire pour utiliser la valeur par default
	 * @return String a ecrire pour utiliser la valeur par default
	 */
	public static String useDefaultMode()
	{
		return "d";
	}
	
	private int getDimension (String arg, int defaultVal)
	{
		return arg.equalsIgnoreCase(Terminal.useDefaultMode()) ? defaultVal : getPositiveInt(arg);
	}
	
	private Complex getComplex (String arg) 
	{
		String[] numbers = arg.split("!");
		
		if (numbers[0].equalsIgnoreCase(Terminal.useDefaultMode())) 
		{
			return DrawZone.getDefaultComplex();
		}
		
		Double real = getDouble(numbers[0]);
		Double im = getDouble(numbers[1]);
		
		return new Complex(real, im);
	}
}

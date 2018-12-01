package juliaset;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main 
{
	public static void main(String[] args) 
	{
		// Récupération de la taille de l'écran.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screen.getWidth();
		int height = (int) screen.getHeight();
		
		// Création de la fenêtre graphique.
		new MandelbrotWindow("Mandelbrot", width * 4 / 5, height * 4 / 5);
	}
}
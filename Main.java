import java.awt.Dimension;
import java.awt.Toolkit;

public class Main 
{
	public static void main(String[] args) 
	{
		// Récupération de la taille de l'écran.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		// Création de la fenêtre graphique.
		MandelbrotWindow window = new MandelbrotWindow("Mandelbrot", width / 2, height / 2);
	}
}
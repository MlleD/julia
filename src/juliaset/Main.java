package juliaset;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;

public class Main 
{
	public static void main(String[] args) 
	{
		// Récupération de la taille de l'écran.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screen.getWidth();
		int height = (int) screen.getHeight();
		
		if (args.length < 1) {
			System.err.println("Erreur d'argument : <mode> (\"ig\" ou autre)");
			return;
		}
		if (args[0].equalsIgnoreCase("ig")) {
			// Création de la fenêtre graphique.
			new MandelbrotWindow("Mandelbrot", width * 4 / 5, height * 4 / 5);
		}
		else {
			if (args.length != 3) {
				System.err.println("Erreur d'argument : term <hauteur> <largeur> (ecrire "  + Terminal.useDefaultMode() +  " pour utiliser la valeur par defaut)");
				return;
			}
			new Terminal(Arrays.copyOfRange(args, 1, args.length));
		}
	}
}
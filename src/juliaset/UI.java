package juliaset;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;

public class UI {
    public UI (String[] args) {
        if (args[0].equalsIgnoreCase("ig")) {
            // Récupération de la taille de l'écran.
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screen.getWidth();
            int height = (int) screen.getHeight();
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
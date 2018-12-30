package juliasets;

import juliasets.ui.UI;

/**
 * Point d'entrée du programme.
 * 
 * @author Adrien Cavalieri
 * @author Dorothée Huynh
 * @version 1.0
 */
public class Main 
{
	public static void main(String[] args) 
	{		
		if (args.length < 1) 
		{
			System.err.println("Argument error : <mode> (\"ig\" or something else)");
			
			System.exit(1);
		}
		
		new UI(args);
	}
}
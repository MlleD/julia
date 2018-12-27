package juliasets;

import juliasets.ui.UI;

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
package juliaset;

public class Main 
{
	public static void main(String[] args) 
	{		
		if (args.length < 1) {
			System.err.println("Erreur d'argument : <mode> (\"ig\" ou autre)");
			return;
		}
		new UI (args);
	}
}
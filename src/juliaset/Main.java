package juliaset;

public class Main 
{
	public static void main(String[] args) 
	{		
		if (args.length < 1) {
			System.err.println("Argument error : <mode> (\"ig\" or something else)");
			return;
		}
		new UI (args);
	}
}
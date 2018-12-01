package juliaset;

public class QuadraticJuliaSet 
{
	public static int divergenceIndex(Complex x0, Complex c, int maxIteration) 
	{
		int ite = 0; 
		Complex xn = x0;
		
		while (ite++ < maxIteration && xn.modulus() <= 2.) 
			xn = c.plus(xn.times(xn));
		
		return ite;
	}
}

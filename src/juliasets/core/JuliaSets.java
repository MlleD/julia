package juliasets.core;

public final class JuliaSets 
{
	public static int divergenceIndex(Complex x0, Complex c, int maxIter) 
	{
		int iter = maxIter; 
		Complex xn = x0;
		
		while (iter-- > 0 && xn.modulus() <= 2.) 
			xn = c.plus(xn.times(xn));
		
		return iter;
	}
}

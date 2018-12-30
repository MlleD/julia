package juliasets.core;

/**
 * Classe contenant diverses méthodes nécessaires au dessin
 * des ensembles de Julia et de Mandelbrot.
 * 
 * @author Adrien Cavalieri
 * @author Dorothée Huynh
 * @version 1.0
 */
public final class JuliaSets 
{
	/**
	 * Méthode calculant le nombre d'itérations à partir duquel
	 * on est sûr que la séquence diverge.
	 * 
	 * @param x0 Complexe sur lequel on itère
	 * @param c Complexe choisi par l'utilisateur
	 * @param maxIter Nombre maximal d'itérations
	 * @return Le nombre d'itérations à partir duquel la séquence diverge
	 */
	public static int divergenceIndex(Complex x0, Complex c, int maxIter) 
	{
		int iter = maxIter; 
		Complex xn = x0;
		
		while (iter-- > 0 && xn.modulus() <= 2) 
			xn = c.plus(xn.times(xn));
		
		return iter;
	}
}

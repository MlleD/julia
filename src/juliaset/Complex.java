package juliaset;

/**
 * Classe représentant les nombres complexes.
 * 
 * @author Adrien Cavalieri
 * @author Dorothée Huynh
 * @version 1.0
 */
public final class Complex 
{
	private final double real;
	private final double imaginary;
	
	/**
	 * Constructeur membres à membres de la classe. 
	 * 
	 * @param real Partie réelle
	 * @param imaginary Partie imaginaire
	 */
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	 * Constructeur par défaut de la classe.
	 */
	public Complex()
	{
		this(0, 0);
	}
	
	/**
	 * Accesseur de la partie entière du nombre complexe.
	 * 
	 * @return La partie entière du nombre complexe.
	 */
	public Double getReal()
	{
		return this.real;
	}
	
	/**
	 * Accesseur de la partie imaginaire du nombre complexe.
	 * 
	 * @return La partie imaginaire du nombre complexe.
	 */
	public Double getImaginary()
	{
		return imaginary;
	}
	
	/**
	 * Méthode additionnant 2 nombres complexes.
	 * 
	 * @param other Un autre nombre complexe
	 * @return Un nouveau nombre complexe.
	 */
	public Complex plus(Complex other) 
	{
        double r = this.real + other.getReal();
        double i = this.imaginary + other.getImaginary();
        
        return new Complex(r, i);
    }
	
	/**
	 * Méthode multipliant 2 nombres complexes.
	 * 
	 * @param other Un autre nombre complexe
	 * @return Un nouveau nombre complexe.
	 */
	public Complex times(Complex other)
	{
		double r = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double i = this.real * other.getImaginary() + this.imaginary * other.getReal();
        
        return new Complex(r, i);
	}
	
	/**
	 * Méthode renvoyant le module d'un
	 * nombre complexe.
	 * 
	 * @return La valeur absolue du nombre complexe.
	 */
	public double modulus()
	{
		return this.real * this.real + this.imaginary * this.imaginary;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return real + " + " + imaginary + "i";
	}
}

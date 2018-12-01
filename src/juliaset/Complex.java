package juliaset;
public final class Complex 
{
	private final double real; // Partie réelle du nombre complexe.
	private final double imaginary; // Partie imaginaire du nombre complex.
	
	/**
	 * Constructeur de la classe.
	 * 
	 * @param real
	 * @param imaginary
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
	 * Accesseur de la partie réelle du nombre complexe.
	 * 
	 * @return
	 */
	public double getReal()
	{
		return this.real;
	}
	
	/**
	 * Accesseur de la partie imaginaire du nombre complexe.
	 * 
	 * @return
	 */
	public double getImaginary()
	{
		return imaginary;
	}
	
	/**
	 * Méthode additionnant 2 nombres complexes et
	 * renvoyant le résultat sou la forme d'un nouveau
	 * complexe.
	 * 
	 * @param other
	 * @return
	 */
	public Complex plus(Complex other) 
	{
        double r = this.real + other.getReal();
        double i = this.imaginary + other.getImaginary();
        
        return new Complex(r, i);
    }
	
	/**
	 * Méthode multipliant 2 nombres complexes et 
	 * renvoyant le résultat sous la formes d'un nouveau
	 * nombre complexe.
	 * 
	 * @param other
	 * @return
	 */
	public Complex times(Complex other)
	{
		double r = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double i = this.real * other.getImaginary() + this.imaginary * other.getReal();
        
        return new Complex(r, i);
	}
	
	/**
	 * Méthode renvoyant la valeur absolue d'un
	 * nombre complexe.
	 * 
	 * @return
	 */
	public double modulus()
	{
		return this.real * this.real + this.imaginary * this.imaginary;
	}
}

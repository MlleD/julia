public final class Complex 
{
	private final double real;
	private final double imaginary;
	
	public Complex (double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public double getReal()
	{
		return this.real;
	}
	
	public double getImaginary()
	{
		return this.imaginary;
	}
	
	public Complex plus(Complex other) 
	{
        double r = this.real + other.getReal();
        double i = this.imaginary + other.getImaginary();
        
        return new Complex(r, i);
    }
	
	public Complex times(Complex other)
	{
		double r = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double i = this.real * other.getImaginary() + this.imaginary * other.getReal();
        
        return new Complex(r, i);
	}
	
	public double modulus()
	{
		return Math.hypot(this.real, this.imaginary);
	}
}

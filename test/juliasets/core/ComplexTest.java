package juliasets.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexTest 
{
	@Test
	void testGetReal() 
	{
		Complex c1 = new Complex(3.2, 5.0);
		assertEquals(3.2, c1.getReal());
		
		Complex c2 = new Complex(-9.4, 4.0);
		assertEquals(-9.4, c2.getReal());
	}

	@Test
	void testGetImaginary() 
	{
		Complex c1 = new Complex(8.0, 2.5);
		assertEquals(2.5, c1.getImaginary());
		
		Complex c2 = new Complex(7.0, -1.0);
		assertEquals(-1.0, c2.getImaginary());
	}

	@Test
	void testPlus() 
	{
		Complex c1 = new Complex(11.4, 24.2);
		Complex c2 = new Complex(10.1, 5.8);
		Complex c3 = c1.plus(c2);
		assertEquals(21.5, c3.getReal());
		assertEquals(30.0, c3.getImaginary());
		
		Complex c4 = new Complex(21.7, 7.2);
		Complex c5 = new Complex(-10.2, 5.2);
		Complex c6 = c4.plus(c5);
		assertEquals(11.5, c6.getReal());
		assertEquals(12.4, c6.getImaginary());
		
		Complex c7 = new Complex(9.8, -17.0);
		Complex c8 = new Complex(1.5, 14.0);
		Complex c9 = c7.plus(c8);
		assertEquals(11.3, c9.getReal());
		assertEquals(-3.0, c9.getImaginary());
	}

	@Test
	void testTimes() 
	{
		Complex c1 = new Complex(2.5, 5.0);
		Complex c2 = new Complex(11.0, 7.7);
		Complex c3 = c1.times(c2);
		assertEquals(-11.0, c3.getReal());
		assertEquals(74.25, c3.getImaginary());
		
		Complex c4 = new Complex(-6.0, 14.5);
		Complex c5 = new Complex(7.2, 1.4);
		Complex c6 = c4.times(c5);
		assertEquals(-63.5, c6.getReal());
		assertEquals(96.0, c6.getImaginary());

		Complex c7 = new Complex(14.6, 3.0);
		Complex c8 = new Complex(9.3, -4.5);
		Complex c9 = c7.times(c8);
		assertEquals(149.28, c9.getReal());
		assertEquals(-37.8, c9.getImaginary());
	}

	@Test
	void testModulus() 
	{
		Complex c1 = new Complex(7.1, 8.3);
		assertEquals(15.4, c1.modulus());
		
		Complex c2 = new Complex(-1.0, 5.0);
		assertEquals(6.0, c2.modulus());
		
		Complex c3 = new Complex(6.5, -4.5);
		assertEquals(11.0, c3.modulus());
		
		Complex c4 = new Complex(-2.8, -3.5);
		assertEquals(6.3, c4.modulus());
	}
	
	@Test
	void testToString() 
	{
		Complex c1 = new Complex(10.4, 7.6);
		assertEquals("10.4 + 7.6i", c1.toString());
		
		Complex c2 = new Complex(9.1, -5.7);
		assertEquals("9.1 + -5.7i", c2.toString());
		
		Complex c3 = new Complex(-6.8, 0.4);
		assertEquals("-6.8 + 0.4i", c3.toString());
		
		Complex c4 = new Complex(-14.3, -8.4);
		assertEquals("-14.3 + -8.4i", c4.toString());
		
		
	}
	
	@Test
	void testEqualsObject() 
	{
		Complex c1 = new Complex(3.7, -2.1);
		Complex c2 = new Complex(3.7, -2.1);
		Complex c3 = new Complex(-5.5, 4.8);
		Complex c4 = null;
		String s = "test";
		
		assertTrue(c1.equals(c2));
		assertFalse(c2.equals(c3));
		assertFalse(c3.equals(c4));
		assertFalse(c3.equals(s));
	}
}

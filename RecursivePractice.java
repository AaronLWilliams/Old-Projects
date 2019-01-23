/*	Aaron Williams
 * 	COSC 3331
 * 	RecursivePractice
 * 	
 * 	This program will ask the user for the dividend and the divisor.  It then will calculate and output the quotient and modulus using recursion.
 */
import java.util.Scanner;

public class RecursivePractice 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the divident. ");
		int divident = sc.nextInt();
		System.out.print("Please enter the divisor. ");
		int divisor = sc.nextInt();
		int quotient = 0;
		int modulus;
		
		quotient = divide(divident, divisor, quotient);
		modulus = modulus(divident, divisor);
		
		System.out.println("The Quotient is: " + quotient);
		System.out.println("The Modulus is: " + modulus);
	}
	public static int divide(int divident, int divisor, int quotient)//returns the quotient
	{
		if(divisor > divident)
			return quotient;
		return divide((divident - divisor), divisor, quotient + 1);
	}
	
	public static int modulus(int dividend, int divisor)//returns the modulus
	{
		if(divisor > dividend)
			return dividend;
		return modulus(dividend - divisor, divisor);
	}

}

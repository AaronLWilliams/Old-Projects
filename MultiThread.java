/*Program Name: Java Multithreading Tasks
 *Programmer: Aaron Williams, 1587411
 *Assignment Number: Project 2
 *
 *Purpose: 
 * The purpose of this program is to create an array of 10 random integers(1-100). It will find the average, minimum, and maximum using different threads. The program will state when the threads
 * starts and when the threads end.  A thing to note is that while average is called first, it outputs last.  This is most likely due to it taking a longer time to finish than min and max.
 */
import java.util.Random;

//Receives an array and finds the average
class Average extends Thread
{
	private int numbers[];
	
	public Average (int array[])
	{
		this.numbers = array;
	}
	public void run()
	{
		double avg = 0;
		for(int i = 0; i<= 9; i++)
		{
			avg = avg + numbers[i];
		}
		avg = avg / numbers.length;
		System.out.println("The average is " + avg);
	}
}
//Receives an array the size of 10 and returns the maximum
class Max extends Thread
{
	private int numbers[];
	
	public Max (int array[])
	{
		this.numbers = array;
	}
	public void run()
	{
		int max = numbers[0];
		
		for(int i = 1; i<= 9; i++)
		{
			if(numbers[i] > max)
				max = numbers[i];
		}
		System.out.println("The maximum is " + max);
	}
}
//Receives an array the size of 10 and returns the minimum
class Min extends Thread
{
	private int numbers[];
	
	public Min (int array[])
	{
		this.numbers = array;
	}
	public void run()
	{
		int min = numbers[0];
		
		for(int i = 1; i<= 9; i++)
		{
			if(numbers[i] < min)
				min = numbers[i];
		}
		System.out.println("The minimum is " + min);
	}
}

public class MultiThread
{
	public static void main(String[]args) throws InterruptedException
	{
		Random rand = new Random();
		//Create a 10 integer array of random numbers 
		int array[] = new int [10];
		for(int i = 0; i <= 9; i++)
		{
			array[i] = rand.nextInt(100) + 1;
		}
		Average average = new Average(array);
		Max max = new Max(array);
		Min min = new Min(array);
		
		System.out.println("Now we start to print out!");
		average.start();
		max.start();
		min.start();
		average.join();
		max.join();
		min.join();
		//*.join is needed to allow the next output to appear last
		System.out.println("All threads are finished!");
	}
}

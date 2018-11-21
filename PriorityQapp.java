/*
 * Aaron Williams
 * COSC 3331
 * PrioityQ
 * 
 * This program (using the priorityQ class from PriorityQ) is similar to the program found in the book.  The main difference is that this finds the highest priority on removal rather
 * that insertion.
 */
import java.io.IOException;

public class PriorityQapp 
{
	public static void main (String[] args) throws IOException
	{
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		
		while(!thePQ.isEmpty())
		{
			System.out.print(thePQ.remove() + " ");
		}
		System.out.println("");
	}
}

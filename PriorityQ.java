/*
 * Aaron Williams
 * COSC 3331
 * PriorityQ
 * 
 * Please refer to PriorityQapp for description
 */
public class PriorityQ 
{
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ(int s)
	{
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	public void insert(long item)// insert now just inserts
	{
			queArray[nItems++] = item;
	}
	public long remove()//finds the minimum and shifts the following to the left
	{
		long min = queArray[0];
		int index = 0;
		for(int i = 1; i < nItems; i++)
		{
			if(min > queArray[i])
			{
				min = queArray[i];
				index = i;
			}
		}
		for(int i = index + 1; i < nItems; i++)
		{
			queArray[i - 1] = queArray[i];
		}
		--nItems;
		return min;
	}
	public long peekMin()
	{
		return queArray[nItems-1];
	}
	public boolean isEmpty()
	{
		return (nItems==0);
	}
	public boolean isFull()
	{
		return (nItems == maxSize);
	}
}

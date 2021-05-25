package package_8;

public class ArrayLabClass 
{
	private int min, max;
	private double average;
	private int arraySize = 20;
	private int[] intArray;
	
	public ArrayLabClass(int[] inputtedArray)
	{
		intArray = inputtedArray;
	
		
	}
	
	public void calcMin()
	{
		int low = intArray[0];
		int index;
		for(index = 0; index < arraySize; index ++)
		{
			if (intArray[index] < low)
			{
				low = intArray[index];
			}
		}
		min = low;
	}
	
	public void calcMax()
	{
		int high = intArray[0];
		int index;
		for(index = 0; index < arraySize; index ++)
		{
			if (intArray[index] > high)
			{
				high = intArray[index];
			}
		}
		max = high;
	}
	
	public int getMin()
	{
		return min;
	}
	
	public int getMax()
	{
		return max;
	}
	public void calcAverage()
	{
		int accumulator = 0;
		int index;
		for(index = 0; index < arraySize; index++)
		{
			accumulator += intArray[index];
		}
		average = accumulator / arraySize;
	}
	public double getAverage()
	{
		return average;
	}
	
	public void printArray()
	{
		int index;
		for (index = 0; index < arraySize; index++)
		{
			if (index != arraySize -1)
			{
				System.out.print(intArray[index] + ", " );
			}
			else 
			{
				System.out.print(intArray[index]);
			}


			 
		}
	}
	
}

package p5_package;

public class SimpleStackClass 
{
	private int capacity;
	private int DEFAULT_CAPACITY = 10;
	private int FAILED_ACCESS = -999999;
	private int size;
	private int[] stackData;
	private int stackTopIndex;
	
	SimpleStackClass()
	{
		capacity = DEFAULT_CAPACITY;
		stackData = new int[capacity];
		clear();
		
		
	}
	SimpleStackClass(int capacitySetting)
	{
		capacity = capacitySetting;
		stackData = new int[capacity];
		clear();
	}
	SimpleStackClass( SimpleStackClass copied)
	{
		capacity = copied.capacity;
		stackData = new int[capacity];
		int index;
		for(index = 0; index < capacity; index++)
		{
			stackData[index] = copied.stackData[index];
		}
		size = copied.size;
		stackTopIndex = copied.stackTopIndex;
		
		
	}
	
	//Checks for resize and resizes to twice the current capacity if needed
	private boolean checkForReSize()
	{
		int index;
		//if the capacity is the same as the size, then it needs to be resized, which is essentailly
		//re-capacitating.
    	if( capacity == size)
    	{
    		
    		capacity *=2;
    		int[] copyArray = new int[capacity];
    		for(index = 0; index < size; index++ )
    		{
    			copyArray[index] = stackData[index];
    		}
    		stackData = copyArray;
    		
    		//returns true if resize is nessesary
    		return true;
    	}
    	return false;
	}
	public void clear()
	{
		//Clears stack by setting size to zero
		size = 0;
		//and top index to negative one
		stackTopIndex = -1;
	}
	public boolean isEmpty()
	{
		//Reports stack empty status
		//Does not use if/else
		while( size == 0)
		{
			return true;
		}
		return false;
	}
	public int peekTop()
	{
		//provides peek at top of stack

		if(!isEmpty())
		{
			return stackData[stackTopIndex];
		}
		return FAILED_ACCESS;
	}
	public int pop()
	{
		//Removes and returns data from top of stack
		
		if(!isEmpty())
		{
			int toBeRemoved = stackData[stackTopIndex];
			stackTopIndex--;
			size--;
			return toBeRemoved;
		}
		return FAILED_ACCESS;
	}
	public void push(int newValue)
	{
		//Checks for resize
		checkForReSize();
		// then pushes value onto stack
		//end of array is always the top of the stack; 
		//index is incremented 
		stackTopIndex++;
		//and then value is appended to array
		stackData[stackTopIndex] = newValue;
		size++;
		
		
	}
	
}

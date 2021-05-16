package p5_package;

public class SimpleQueueClass 
{
	private int capacity;
	private int DEFAULT_CAPACITY = 10;
	static int FAILED_ACCESS = -999999;
	private int headIndex;
	private int tailIndex;
	private int[] queueData;
	private int size;
	public SimpleQueueClass()
	{
		capacity = DEFAULT_CAPACITY;
		queueData = new int[capacity];
		headIndex = 0;
		tailIndex = -1; 
		
		
	}
	public SimpleQueueClass(int capacitySetting)
	{
		capacity = capacitySetting;
		queueData = new int[capacity];
		headIndex = 0;
		tailIndex = -1;
		size =0;
	}
	public SimpleQueueClass(SimpleQueueClass copied)
	{
		capacity = copied.capacity;
		queueData = new int[capacity];
		int index;
		headIndex = copied.headIndex;
		tailIndex = copied.tailIndex;
		size = copied.size;
		for(index = headIndex; index < capacity; index++)
		{
			queueData[index] = copied.queueData[index];
			updateHeadIndex();
		}
		
	}
	public void enqueue(int newValue)
	{
		//Checks for resize
		checkForReSize();
		
		//Updates tail index,
		updateTailIndex();
		
		//then enqueues value
		queueData[tailIndex] = newValue;
		size++;
	}
	public int dequeue()
	{
		//Removes and returns value from front of queue
		//: Acquires data from head of queue
		if(!isEmpty())
		{
			int removedQueueData;
			removedQueueData = queueData[headIndex];
			
			// then updates head index
			updateHeadIndex();
			size--;
			return removedQueueData;
		}
		return FAILED_ACCESS;
		
	}
	public int peekFront()
	{
		//Provides peek at front of queue
		
		if(!isEmpty())
		{
			return queueData[headIndex];
		}
		return FAILED_ACCESS;
		
	}
	public boolean isEmpty()
	{
		//Reports queue empty state
		
		//Does not use if/else
		while( size == 0)
		{
			return true;
		}
		return false;
	}
	
	
	//Checks for resize and resizes to twice the current capacity if needed
	private boolean checkForReSize()
	{
		 int index;
	    	if( capacity == size)
	    	{
	    		//had a bug here made me sad D: but then i fixed it!
	    		
	    		//: This method must transfer the data into the array such that the resized array starts with a head 
	    		//index of zero and a tail index of size - 1
	    		
	    		//trying to implement comment above breaks everything
	    		capacity *= 2;
	    		int[] copyArray = new int[capacity];
	    		for(index = 0; index < size; index++ )
	    		{
	    			copyArray[index] = queueData[index];
	    			
	    		}
	    		queueData = copyArray;
	    		
	    		
	    		
	    		//Returns true if resize is necessary and is conducted
	    		return true;
	    	}
	    	//returns false if no action is taken
	    	return false;
	}
	private void updateHeadIndex()
	{
		//Updates queue head index to wrap around array as needed

		headIndex++;
		
		headIndex %= capacity;
	}
	private void updateTailIndex()
	{
		//Updates queue tail index to wrap around array as needed
		
		tailIndex++;
		
		tailIndex %= capacity;
	}
	public void clear()
	{
		//Clears the queue by setting the size to zero
		size = 0;
		//the tail index to -1
		tailIndex = -1;
		//and the head index to zero
		headIndex = 0;
	}
	
}

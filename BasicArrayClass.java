package p6_package;

public class BasicArrayClass
{
	private int arrayCapacity;
	private int arraySize;
	private static int DEFAULT_CAPACITY = 10;
	static int FAILED_ACCESS = -999999;
	static int INSERT_AFTER = 1003;
	static int INSERT_BEFORE = 1002;
	private int[] localArray;
	static int REMOVE = 1004;
	static int REPLACE = 1001;
	static int RETRIEVE = 1005;
	
	protected BasicArrayClass()
	{
		arrayCapacity = DEFAULT_CAPACITY;
		localArray = new int[arrayCapacity];
		arraySize = 0;
	}
	protected BasicArrayClass(int capacity)
	{
		arrayCapacity = capacity;
		localArray = new int[arrayCapacity];
		arraySize = 0;
	}
	protected BasicArrayClass(BasicArrayClass copied)
	{
		
	}
	
	private int accessAtIndex(int controlCode,
            int index)
	{
		//Utility method used by getAtIndex and removeAtIndex to access and possibly remove element depending on control code
		
		if(controlCode == RETRIEVE)
		{
			return localArray[index];
		}
		if(controlCode == REMOVE)
		{
			int removedValue;
			int toBePushed;
			int pushIndex;
			//Each data item from the element immediately above the remove index to the end of the array is moved down by one element
			removedValue = localArray[index];
			for(pushIndex = index; pushIndex < arraySize; pushIndex++)
			{
				toBePushed = localArray[pushIndex + 1];
				localArray[pushIndex] = toBePushed;
			}
			arraySize--;
			return removedValue;
		}
		return FAILED_ACCESS;
		//Uses only one loop
	}
	protected void checkForResize()
	{
		//Checks for need to resize; if this is necessary, creates new array with double the original capacity, loads data from original array to new one, then sets localArray to new array
		 int index;
	    	if( arrayCapacity == arraySize)
	    	{
	    		
	    		
	    		arrayCapacity *= 2;
	    		int[] copyArray = new int[arrayCapacity];
	    		for(index = 0; index < arraySize; index++ )
	    		{
	    			copyArray[index] = localArray[index];
	    			
	    		}
	    		localArray = copyArray;	
	    	}
	    	
	}
	protected void clear()
	{
		//Clears array of all valid values by setting array size to zero, values remain in array but are not accessible
		arraySize = 0;
		
	}
	protected int getAtIndex(int accessIndex)
	{
		//Accesses item in array at specified index if index within array size bounds
			//calls accessAtIndex with RETRIEVE to conduct action
			return accessAtIndex(RETRIEVE, accessIndex);
		
		
	}
	protected int getCurrentCapacity()
	{
		return arrayCapacity;
	}
	protected int getCurrentSize()
	{
		return arraySize;
	}
	protected boolean isEmpty()
	{
		if(arraySize == 0)
		{
			return true;
		}
		return false;
	}
	protected int removeAtIndex(int removeIndex)
	{
		if(removeIndex < arraySize)
		{
			//: Must call accessAtIndex with REMOVE to conduct action
			return accessAtIndex(REMOVE, removeIndex);
		}
		return FAILED_ACCESS;
		//Removes item from array at specified index if index within array size bounds
		//Each data item from the element immediately above the remove index to the end of the array is moved down by one element
		//: Must call accessAtIndex with REMOVE to conduct action
	}
	protected boolean setAtIndex(int setIndex,
            int newValue,
            int replaceFlag)
	{
		int storedValue;
		int loopStoredValue;
		int index;
		//Description: sets item in array at specified index
		//If constant REPLACE is used, new value overwrites value at given index
		if(replaceFlag == REPLACE)
		{
			localArray[setIndex] = newValue;
			return true;
		}
		//If constant INSERT_BEFORE is used, new value is inserted prior to the value at the given index moving all other elements up by one
		if(replaceFlag == INSERT_BEFORE)
		{
			
			//If either constant INSERT_BEFORE or INSERT_AFTER is used with index zero and an empty array, new value is inserted at index zero
			if(setIndex == 0 && isEmpty())
			{
				localArray[0] = newValue;
				arraySize++;
				return true;
			}
			//Method checks for available array capacity and adjusts it as needed prior to inserting new item
			
			///Method must also check for correct array boundaries depending upon INSERT/REPLACE state
			arraySize++;
			checkForResize();
			
			for(index = arraySize; index > setIndex; index--)
			{
				localArray[index] = localArray[index -1];
			}
			localArray[setIndex] = newValue;
			return true;
			
		}
		// If constant INSERT_AFTER is used, new value is inserted after the value at the given index moving all other elements up by one
		if(replaceFlag == INSERT_AFTER)
		{
			
			//If either constant INSERT_BEFORE or INSERT_AFTER is used with index zero and an empty array, new value is inserted at index zero
			if(setIndex == 0 && isEmpty())
			{
				localArray[setIndex] = newValue;
				arraySize++;
				return true;
			}
			//Method checks for available array capacity and adjusts it as needed prior to inserting new item
			///Method must also check for correct array boundaries depending upon INSERT/REPLACE state
			arraySize++;
			checkForResize();
			storedValue = localArray[setIndex + 1];
			localArray[setIndex + 1] = newValue;
			for(index = setIndex + 2; index < arraySize; index++)
			{
				localArray[index] = storedValue;
				storedValue = localArray[index + 1];
			}
			return true;
		}
		return false;
		
		
		
	}
	


	






}
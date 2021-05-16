package p2_package;

public class GenericDataMgmtClass<GenericData extends java.lang.Comparable<GenericData>> 
{
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] localArray;
	private int arraySize;
	private int arrayCapacity;
	
	public GenericDataMgmtClass()
	{
		arrayCapacity = DEFAULT_CAPACITY;
		localArray = new Object[arrayCapacity];
	}
	public GenericDataMgmtClass(int capacity)
	{
		arrayCapacity = capacity;
		localArray = new Object[arrayCapacity];
	}
	public GenericData accessItemAt(int accessIndex)
	{
		//Accesses item in array at specified index if index within array size bounds
		if(accessIndex <= arraySize)
		{
			return (GenericData)localArray[accessIndex];
		}
		return null;
	}
	public boolean appendItem(GenericData newValue)
	{
		if(!isFull())
		{
			localArray[arraySize] = newValue;
			arraySize++;
			return true;
		}
		return false;
	}
	public void clear()
	{
		int index;
		for(index = 0; index < arraySize; index++)
		{
			localArray[index] = null;
		}
		arraySize = 0;
	}
	public int getCurrentSize()
	{
		return arraySize;
	}
	public boolean insertData(int insertIndex, GenericData newValue)
	{
		int index;
		if(!isFull())
		{
			arraySize++;
			//put resize here
			for(index = arraySize; index > insertIndex; index--)
			{ 
				localArray[index] = localArray[index - 1];
			}
			localArray[insertIndex] = newValue;
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(arraySize == 0)
		{
			return true;
		}
		return false;
	}
	public boolean isFull()
	{
		if(arraySize == arrayCapacity)
		{
			return true;
		}
		return false;
	}
	public GenericData removeData(int removeIndex)
	{
		int index;
		Object[] removeArray = new Object[arrayCapacity];
		GenericData removedData;
		if(!isEmpty())
		{
			removedData = (GenericData) localArray[removeIndex];
			arraySize--;
			for(index = removeIndex; index < arraySize; index++)
			{
				localArray[index] = localArray[index+1];
			}
			
			return removedData;
		}
		return null;
	}
	public boolean resize(int newCapacity)
	{
		int index;
		if( arraySize < arrayCapacity )
		{
			return false;
		}
		else
		{
			arrayCapacity = newCapacity;
			Object[] resizeArray = new Object[arrayCapacity];
			for(index = 0; index < arraySize; index++)
			{
				resizeArray[index] = localArray[index];
			}
			localArray = resizeArray;
			return true;
		}
	}
	public void runBubbleSort()
	{
		int index;
		boolean swapped = true;
		while(swapped)
		{
			swapped = false;
			index = 0;
			//loop until next to last item
			while(index < arraySize -1 )
			{
				//check for first one greater than second one
				if( ((Comparable<GenericData>) localArray[index]).compareTo
						((GenericData) localArray[index+1]) > 0)
				{
					//swap elements
					swapElements(index, index+1);
					swapped = true;
				}
				index++;
			}
		}
	}
	public void runInsertionSort()
	{
		
		int searchIndex, listIndex = 1;
		java.lang.Object tempObject;
		while(listIndex < arraySize )
		{
			//store test char found at listIndex given by outer loop
			tempObject = localArray[listIndex];
			
			//start at index given by outer loop
			searchIndex = listIndex;
			
			//loop while not at bottom, and while the test character is less than the itemin the slot below
			while( searchIndex > 0 && 
					((Comparable<GenericData>) tempObject).compareTo
						((GenericData) localArray[searchIndex-1]) <0)
			{
				localArray[ searchIndex ] = localArray[searchIndex -1];
				searchIndex--;
			}
			//end insercion loop and insert object
			localArray[searchIndex] = tempObject;
			//increment list loop index
			listIndex++;
		}
		//end list loop
		
		
	}
	public void runSelectionSort()
	{
		int listIndex, lowestIndex, currentSearchIndex;
		//loop across list
		//loop up to but not including last item
		for( listIndex = 0; listIndex < arraySize -1; listIndex++)
		{
			//set initial lowestIndex at first element to be serached
			lowestIndex = listIndex;
			//loop across list from current element to end
			for(currentSearchIndex = listIndex +1;
					currentSearchIndex < arraySize; currentSearchIndex++)
			{
				//check for current element less than currently lowest element
				if( ((Comparable<GenericData>) localArray[currentSearchIndex]).compareTo
						((GenericData)localArray[lowestIndex])  < 0)
				{
					lowestIndex = currentSearchIndex;
				}
			}
			//end search loop
			
			//swap the item at the present position
			// with the item at the lowest value positon
			swapElements(listIndex, lowestIndex);
		}
	}
	public void runShellSort()
	{
		int gap, index, indexforIndex;
		Object temp;
		for(gap = arraySize/2; gap > 0; gap /= 2)
		{
			//Do a gapped insertion sort for this gap size
			//the first gap elements are already in gapped order 
			//to keep adding one more element
			//until the entire array si gap sorted
			for( index = gap; index < arraySize; index++)
			{
				
				temp = localArray[index];
				
				for(indexforIndex = index; indexforIndex >= gap && 
						((Comparable<GenericData>) localArray[indexforIndex - gap]).compareTo((GenericData) temp) > 0; indexforIndex -=gap)
				{
					localArray[indexforIndex] = localArray[indexforIndex - gap];
					
				}
				localArray[indexforIndex] = temp;
			}
		}
	}
	private void swapElements(int oneIndex, int otherIndex)
	{
		Object storedValue = localArray[oneIndex];
		localArray[oneIndex] = localArray[otherIndex];
		localArray[otherIndex] = storedValue;
		
	}
	
 }

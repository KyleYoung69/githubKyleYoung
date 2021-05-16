package p3_package;

public class LogN_StudentMgmtClass 
{
	
	
	public LogN_StudentMgmtClass()
	{
		
	}
	public static int compareStrings(java.lang.String strOne,
            java.lang.String strTwo)
	{
		int lengthOne = strOne.length();
		int lengthTwo = strTwo.length();
		int lengthMinimum = Math.min(lengthOne, lengthTwo);
		int strOneChar, strTwoChar;
		int index;
		//this part lets us know if strOne is greater than strTwo if its a positive or negative number
		for(index = 0; index < lengthMinimum; index++ )
		{
			strOneChar = (int)strOne.charAt(index);
			strTwoChar = (int)strTwo.charAt(index);
			
			if(strOneChar != strTwoChar )
			{
				return strOneChar - strTwoChar;
			}
		}
		
		//check to see if part of word is in other word.
		
		if(lengthOne != lengthTwo)
		{
			return lengthOne - lengthTwo;
		}
		
		else
		{
			return 0;
		}
		
		
		
		
	}
	private static void runMerge(StudentClass[] localArray,
            int lowIndex,
            int middleIndex,
            int highIndex)
	{
		
		int index, otherIndex, constrIndexOne, constrIndexTwo, mergeIndex;
		//find size for arrays
		int sizeOne = middleIndex - lowIndex + 1;
		int sizeTwo = highIndex - middleIndex;
		
		//create new temp arrays
		StudentClass leftTemp[] = new StudentClass[sizeOne];
		StudentClass rightTemp[] = new StudentClass[sizeTwo];
		
		//copy data from local array to temp arrays
		for(constrIndexOne = 0; constrIndexOne < sizeOne; ++constrIndexOne)
		{
			leftTemp[constrIndexOne] = localArray[lowIndex + constrIndexOne];
		}
		for(constrIndexTwo = 0; constrIndexTwo < sizeTwo; ++constrIndexTwo)
		{
			rightTemp[constrIndexTwo] = localArray[middleIndex + 1 + constrIndexTwo];
		}
		
		index =0;
		otherIndex = 0;
		
		//merging temp arrays
		
		mergeIndex = lowIndex;
		while(index < sizeOne && otherIndex < sizeTwo)
		{
			if(compareStrings(leftTemp[index].name, rightTemp[otherIndex].name) < 0)
			{
				localArray[mergeIndex] = leftTemp[index];
				index++;
			}
			else
			{
				localArray[mergeIndex] = rightTemp[otherIndex];
				otherIndex++;
			}
			mergeIndex++;
		}
		
		//copy remaining elements of leftTemp if available
		while(index < sizeOne)
		{
			localArray[mergeIndex] = leftTemp[index];
			mergeIndex++;
			index++;
			
		}
		while(otherIndex < sizeTwo)
		{
			localArray[mergeIndex] = rightTemp[otherIndex];
			mergeIndex++;
			otherIndex++;
		}
	}
	public static void runMergeSort(StudentClass[] localArray,
            int size)
	{
		//lower index of the list
		int low = 0;
		int high = size-1;
		//find midpoint
		int mid = low +(high - low)/2;
		//call the merge sort process for the left side of the list
		runMergeSortHelper(localArray, low, high);
		//call the merge sort process for the right side of the list
		//then merge the two lists back together as sorted data
		runMerge(localArray, low, mid, high);
	}
	private static void runMergeSortHelper(StudentClass[] localArray,
            int lowIndex,
            int highIndex)
	{
		if(lowIndex < highIndex)
		{
			//middle point
			int midIndex = lowIndex +(highIndex - lowIndex)/2;
			//sort first and second halves
			runMergeSortHelper(localArray, lowIndex, midIndex);
			runMergeSortHelper(localArray, midIndex+1, highIndex);
			
			//merge two halves
			runMerge(localArray, lowIndex, midIndex, highIndex);
			
			
		}
	}
	private static int runPartition(StudentClass[] localArray,
            int lowIndex,
            int highIndex)
	{
		int workingIndex;
		int smallerElementIndex = lowIndex -1;
		StudentClass pivotIndex;
		pivotIndex = localArray[highIndex];
		for(workingIndex = lowIndex; workingIndex < highIndex; workingIndex++)
		{
			//if current element is smaller than the pivot
			if(compareStrings(localArray[workingIndex].name, pivotIndex.name) < 0)
			{
				smallerElementIndex++;
				
				swapValues(localArray,workingIndex, smallerElementIndex );
				
			}
		}
		
		swapValues(localArray, smallerElementIndex + 1, highIndex);
		
		return smallerElementIndex+1;
		
	}
	public static void runQuickSort(StudentClass[] localArray,
            int size)
	{
		int low = 0;
		int high = size -1;
		
		
		if(low < high)
		{
			//partitionindex being set assumes localArray[partitionIndex]
			//is in correct spot
			
			
			runQuickSortHelper(localArray, low, high); 
			
			
			
			
		}
	}
	private static void runQuickSortHelper(StudentClass[] localArray,
            int lowIndex,
            int highIndex)
	{
		int partitionIndex;
		if(lowIndex < highIndex)
		{
			partitionIndex = runPartition(localArray, lowIndex, highIndex);
			
			runQuickSortHelper(localArray, lowIndex, partitionIndex - 1); 
			runQuickSortHelper(localArray, partitionIndex, highIndex);
		}
	}

	private static void swapValues(StudentClass[] localArray,
            int indexOne,
            int indexOther)
	{
		//yoinked from last weeks assignment
		StudentClass heldValue = localArray[indexOne];
		localArray[indexOne] = localArray[indexOther];
		localArray[indexOther] = heldValue;
		
	}
	public char toLowerCase( char testChar )
    {
     if( testChar >= 'A' && testChar <= 'Z' )
        {
         testChar = (char)( testChar - 'A' + 'a' );
        }
     
     return testChar;
    }
}

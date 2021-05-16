package p10_package;

public class StudentHeapClass {

	private int arrayCapacity;
	private int arraySize;
	int DEFAULT_ARRAY_CAPACITY = 10;
	//Display flag can be set to observe bubble up and trickle down operations
	private boolean displayFlag;
	private StudentClass[] heapArray;
	int LEFT = 2002;
	int PARENT = 1001;
	int RIGHT = 3003;
	
	public StudentHeapClass()
	{
		arrayCapacity = DEFAULT_ARRAY_CAPACITY;
		heapArray = new StudentClass[arrayCapacity];
		arraySize = 0;
		displayFlag = false;
		
	}
	public StudentHeapClass(StudentHeapClass copied)
	{
		arraySize = copied.arraySize;
		arrayCapacity = copied.arrayCapacity;
		heapArray = new StudentClass[arrayCapacity];
		displayFlag = false;
		int index;
		for(index = 0; index < arraySize; index++)
		{
			heapArray[index] = new StudentClass(copied.heapArray[index]);
		}
	}
	public void addItem(StudentClass newItem)
	{
		//Accepts StudentData item and adds it to heap
		//Note: uses bubbleUpArrayHeap to resolve unbalanced heap after data addition
		//Note: must check for resize before attempting to add an item
		checkForResize();
		heapArray[arraySize] = newItem;
		arraySize++;
		bubbleUpArrayHeap(arraySize-1);
		
		





	}
	private void bubbleUpArrayHeap(int currentIndex)
	{
		//Recursive operation to reset data in the correct order 
		//for the max heap after new data addition 
		int parentIndex = ( currentIndex - 1 ) / 2;
		//if the current is greater than the value at my parent index
		if(heapArray[currentIndex].compareTo(heapArray[parentIndex]) > 0)
		{
			//swap 
			StudentClass swapped = heapArray[currentIndex];
			heapArray[currentIndex] = heapArray[parentIndex];
			heapArray[parentIndex] = swapped;
			
			//recurse
			bubbleUpArrayHeap(parentIndex);
		}

	}
	private void checkForResize()
	{
		//Automatic resize operation used prior to any new data addition in the heap
		//Tests for full heap array, and resizes to twice the current capacity as required
		int index;
		if(this.arraySize == arrayCapacity)
		{
			arrayCapacity *=2;
			StudentClass[] copyArray = new StudentClass[arrayCapacity];
			for(index = 0; index < arraySize ;index++)
			{
				copyArray[index] = heapArray[index];
			}
			heapArray = copyArray;
		}
	}
	
	public boolean isEmpty()
	{
		//Tests for empty heap
		return arraySize == 0;

	}
	//*****************************
	  public StudentClass removeItem()
	  {
	    StudentClass temp = null;
	    if(!isEmpty())
	    {
	      if(displayFlag)
	      {
	        System.out
	            .println("\nRemoving process: " + this.heapArray[0].toString());

	      }
	      temp = this.heapArray[0];
	      this.heapArray[0] = this.heapArray[arraySize - 1];
	      this.arraySize--;
	      this.trickleDownArrayHeap(0);
	    }
	    return temp;
	  }
	
	public void setDisplayFlag(boolean setState)
	{
		//Utility method to set the display flag for displaying internal operations
		//of the heap bubble and trickle operations
		displayFlag = setState;

	}
	public void showArray()
	{
		//Dumps array to screen as is, no filtering or management
		int index;
		for(index = 0; index < arraySize; index++)
		{
			System.out.print(heapArray[index].toString());
		}

	}
	private void trickleDownArrayHeap(int currentIndex)
	{
		//Recursive operation to reset data in the correct order for the max heap after data removal
		int leftIndex = 2 * currentIndex + 1;
		int rightIndex = 2 * currentIndex + 2;
		if(leftIndex < arraySize)
		{
			if(rightIndex < arraySize)
			{
				if(heapArray[leftIndex].compareTo
						(heapArray[rightIndex]) > 0)
				{
					//left index greater than right
					//compare left index to current index
					if(heapArray[leftIndex].compareTo
							(heapArray[currentIndex]) > 0)
					{
						//if the left index is greater than the current
						//swap
						StudentClass swapped = heapArray[currentIndex];
						heapArray[currentIndex] = heapArray[leftIndex];
						heapArray[leftIndex] = swapped;
						//and recurse
						trickleDownArrayHeap(leftIndex);
					}
				}
				else if(heapArray[rightIndex].compareTo
						(heapArray[leftIndex]) > 0)
				{
					//right index greater than left
					//compare right index to current index
					if(heapArray[rightIndex].compareTo
							(heapArray[currentIndex]) >0)
					{
						//if the right index is greater
						//swap
						StudentClass swapped = heapArray[currentIndex];
						heapArray[currentIndex] = heapArray[rightIndex];
						heapArray[leftIndex] = swapped;
						//and recurse
						trickleDownArrayHeap(rightIndex);
					}
				}
			}
			else
			{
				//if the right index is not less than array size
				//assume one child
					if(heapArray[leftIndex].compareTo
							(heapArray[currentIndex]) > 0)
					{
						//if the left index is greater than the current
						//swap
						StudentClass swapped = heapArray[currentIndex];
						heapArray[currentIndex] = heapArray[leftIndex];
						heapArray[leftIndex] = swapped;
						//and recurse
						trickleDownArrayHeap(leftIndex);
					}
			}
			
		}
		//if left index is less than arraysize, must still check for right, right?
		else if(rightIndex < arraySize)
		{
			 if(heapArray[rightIndex].compareTo
					 (heapArray[leftIndex]) > 0)
				{
					//right index greater than left
					//compare right index to current index
					if(heapArray[rightIndex].compareTo
							(heapArray[currentIndex]) > 0)
					{
						//if the right index is greater
						//swap
						StudentClass swapped = heapArray[currentIndex];
						heapArray[currentIndex] = heapArray[rightIndex];
						heapArray[leftIndex] = swapped;
						//and recurse
						trickleDownArrayHeap(rightIndex);
					}
				}
		}
		
		
	}
	private void trickleDownArrayHeap( int currentIndex )

    {

     int leftChildIndex = 2 * currentIndex + 1;

     int rightChildIndex = 2 * currentIndex + 2;

     int largestFlag = PARENT;

     StudentClass leftChildData = heapArray[ leftChildIndex ];

     StudentClass rightChildData = heapArray[ rightChildIndex ] ;

     StudentClass parentData = heapArray[ currentIndex ];

 

     if( leftChildIndex < arraySize )

        {

         if( leftChildData.compareTo( parentData ) > 0 )

            {

             largestFlag = LEFT;

            }

           

         if( rightChildIndex < arraySize )

            {

             if( rightChildData.compareTo( parentData ) > 0

                        && rightChildData.compareTo( leftChildData ) > 0 )

                {

                 largestFlag = RIGHT;

                }

            }

                  

         if( largestFlag != PARENT )

            {

             if( largestFlag == LEFT )

                {

                 heapArray[ currentIndex ] = leftChildData;

                 heapArray[ leftChildIndex ] = parentData;

                

                 trickleDownArrayHeap( leftChildIndex );

                }

               

             else  // assume right child is largest

                {

                 heapArray[ currentIndex ] = rightChildData;

                 heapArray[ rightChildIndex ] = parentData;

                

                 trickleDownArrayHeap( rightChildIndex );           

                }

            }

        }

    }






	




	
}

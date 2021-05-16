package p7_package;

public class BasicLLClass
{
	private class BasicNode
	{
		BasicNode nextRef;
		int value;
		
		public BasicNode(int newVal)
		{
			value = newVal;
			nextRef = null;
		}
		public BasicNode(BasicNode copied)
		{
			value = copied.value;
			nextRef = null;
			if(copied.nextRef !=null)
			{
				nextRef = new BasicNode(copied.nextRef);
			}
		}
	}
	static int FAILED_ACCESS =-9999999;
	BasicNode headRef;
	static int INSERT_AFTER =1003;
	static int INSERT_BEFORE = 1002;
	static int REMOVE = 1004;
	static int REPLACE = 1001;
	static int RETRIEVE = 1005;
	
	public BasicLLClass()
	{
		headRef = null;
	}
	public BasicLLClass( BasicLLClass copied)
	{
		//copy constructor
		headRef = new BasicNode(copied.headRef);
		if(headRef!= null)
		{
			BasicNode currNode = headRef;
			BasicNode copiedNode = headRef;
			while(currNode != null)
			{
				currNode.nextRef = new BasicNode(copiedNode.nextRef);
				
				currNode = currNode.nextRef;
				
				copiedNode = copiedNode.nextRef;
			}
		}
		
		
	}
	  private int accessAtIndex(int controlCode, int index)
	  {
	    if(index >= 0 && index < getCurrentSize())
	    {
	      if(controlCode == RETRIEVE)
	      {
	        return getRefAtIndex(this.headRef, index).value;
	      }
	      else if(index == 0)
	      {
	        this.headRef = headRef.nextRef;
	      }
	      BasicNode tempNode = getRefAtIndex(this.headRef, index);
	      getRefAtIndex(this.headRef, index - 1).nextRef = getRefAtIndex(
	          this.headRef, index + 1);

	      return tempNode.value;
	    }
	    return FAILED_ACCESS;

	  }
	public void clear()
	{
		//Clears array of all valid values by setting array size to zero, values remain in array but are not accessible
		headRef = null;

	}
	public int getAtIndex(int accessIndex)
	{
		//Accesses item in array at specified index if index within array size bounds
		//Note: Calls accessAtIndex with RETRIEVE to conduct action
			return accessAtIndex(RETRIEVE, accessIndex);
	}
	public int getCurrentSize()
	{
		return getCurrentSizeHelper(headRef);
		
	}
	private int getCurrentSizeHelper(BasicNode wkgRef)
	{
		//Note: size of array indicates number of valid or viable values in the array
		//checks if reference is null and so ends the recursion
		if(wkgRef == null)
		{
			return 0;
		}
		//adds 
		return 1 + getCurrentSizeHelper(wkgRef.nextRef);


	}
	private BasicNode getRefAtIndex(BasicLLClass.BasicNode wkgRef,
            int index)
	{
		//Gets reference for pseudo index using recursive process
		if(index !=0)
		{
			if(wkgRef.nextRef != null)
			{
				wkgRef = wkgRef.nextRef;
				return getRefAtIndex(wkgRef, index-1);
			}
		}
		return wkgRef;
	}
	public boolean isEmpty()
	{
		//Tests for size of array equal to zero, no valid values stored in array
		if(headRef == null)
		{
			return true;
		
		}
		return false;
	}
	public int removeAtIndex(int removeIndex)
	{
		//Description: Removes item from array at specified index if index within array size bounds
		//Note: Each data item from the element immediately above the remove index to the end of the array is moved down by one element
		//Note: Each data item from the element immediately above the remove index to the end of the array is moved down by one element
		if(removeIndex >=0 && removeIndex < getCurrentSize())
		{
			return accessAtIndex(REMOVE,removeIndex );
		}
		return FAILED_ACCESS;


	}
	 public boolean setAtIndex(int setIndex, int newValue, int replaceFlag)
	  {
	    BasicNode tempNode;
	    if(setIndex == 0 && this.isEmpty()
	        && (replaceFlag == INSERT_BEFORE || replaceFlag == INSERT_AFTER))
	    {
	      this.headRef = new BasicNode(newValue);
	      return true;
	    }
	    else if(setIndex >= 0 && setIndex < this.getCurrentSize())
	    {
	      if(replaceFlag == REPLACE)
	      {
	        tempNode = getRefAtIndex(this.headRef, setIndex);
	        getRefAtIndex(this.headRef, setIndex - 1).nextRef = new BasicNode(
	            newValue);
	        getRefAtIndex(this.headRef, setIndex).nextRef = tempNode.nextRef;
	        return true;
	      }
	      else if(replaceFlag == INSERT_BEFORE)
	      {
	        if(setIndex == 0)
	        {
	          tempNode = getRefAtIndex(this.headRef, setIndex);
	          this.headRef = new BasicNode(newValue);
	          this.headRef.nextRef = tempNode;
	        }
	        else
	        {
	          tempNode = getRefAtIndex(this.headRef, setIndex);
	          getRefAtIndex(this.headRef, setIndex - 1).nextRef = new BasicNode(
	              newValue);
	          getRefAtIndex(this.headRef, setIndex).nextRef = tempNode;
	        }

	        return true;
	      }
	      else if(replaceFlag == INSERT_AFTER)
	      {
	        tempNode = getRefAtIndex(this.headRef, setIndex + 1);
	        getRefAtIndex(this.headRef, setIndex).nextRef = new BasicNode(newValue);
	        getRefAtIndex(this.headRef, setIndex + 1).nextRef = tempNode;
	        return true;
	      }

	    }
	    return false;
	  }
}







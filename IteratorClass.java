package p7_package;

public class IteratorClass
{
	private int currentIndex;
	private char LEFT_BRACKET = '[';
	BasicLLClass llData;
	private char RIGHT_BRACKET = ']';
	private char SPACE = ' ';
	
	IteratorClass()
	{
		llData = new BasicLLClass();
		currentIndex = 0;
	}
	IteratorClass(IteratorClass copied)
	{
		llData = copied.llData;
		currentIndex =0;
	}
	public void clear()
	{
		llData.clear();
	}
	public int getAtCurrent()
	{
		return llData.getAtIndex(currentIndex);
	}
	public boolean isAtFirstElement()
	{
		if(!isEmpty())
		{
			return currentIndex == 0;
		}
		return false;
	}
	public boolean isAtLastElement()
	{
		if(!isEmpty())
		{
			return currentIndex == llData.getCurrentSize() -1;
		}
		return false;
	}
	public boolean isEmpty()
	{
		return llData.isEmpty();
	}
	public boolean moveNext()
	{
		//Must consider whether list is empty
		if(!isEmpty())
		{
			//If possible, moves iterator cursor one position to the right, or next
			if(!isAtLastElement())
			{
				currentIndex++;
				return true;
			}
			
		}
		return false;
		
	}
	public boolean movePrev()
	{
		//Must consider whether list is empty
		if(!isEmpty())
		{
			//If possible, moves iterator cursor one position to the left, or previous
			if(!isAtFirstElement())
			{
				currentIndex++;
				return true;
			}
		}
		return false;
	}
	public int removeAtCurrent()
	{
		//Removes and returns a data value from the iterator cursor position
		//Note: cursor must be located at succeeding element unless last item removed
		return llData.removeAtIndex(currentIndex);
		
	}
	public boolean replaceAtCurrent(int newValue)
	{
		//Replaces value at iterator cursor with new value
		return llData.setAtIndex(currentIndex, newValue, llData.REPLACE);
	}
	public void runDiagnosticDisplay()
	  {
	    int index = 0;
	    while(index < llData.getCurrentSize())
	    {
	      if(index == currentIndex)
	      {
	        System.out.print(LEFT_BRACKET);
	        System.out.print(llData.getAtIndex(index));
	        System.out.print(RIGHT_BRACKET);
	        System.out.print(SPACE);
	      }
	      else
	      {
	        System.out.print(llData.getAtIndex(index));
	        System.out.print(SPACE);
	      }

	      index++;
	    }
	    System.out.println();
	  }
	public boolean setAfterCurrent(int newValue)
	{
		//Inserts new value after value at iterator cursor
		//Note: Current value must remain the same after data set
		return llData.setAtIndex(currentIndex, newValue, llData.INSERT_AFTER);

	}
	public boolean setBeforeCurrent(int newValue)
	{
		//Inserts new before value at iterator cursor
		//Current value must remain at the same index after data set
				
		boolean setBeforeCheck = llData.setAtIndex(currentIndex, newValue, llData.INSERT_BEFORE);
		moveNext();
		return setBeforeCheck;
	}
	public boolean setToFirstElement()
	{
		//Sets iterator cursor to beginning of list
		if(!isEmpty())
		{
			currentIndex = 0;
			return true;
		}
		return false;
	}
	public boolean setToLastElement()
	{
		if(!isEmpty())
		{
			currentIndex = llData.getCurrentSize() -1;
			return true;
		}
		return false;
	}







	

	
}

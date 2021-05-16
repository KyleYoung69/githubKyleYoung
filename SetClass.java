package p1_package;





/**
 * Class for managing sets of integers,
 * has capacity to generate various sets
 * 
 * @author Michael Leverington
 * 
 *Dear grader, i dont know where to put this but may you have sympathy with me.
 *my computer crashed during 1/19/21's class and i lost all data
 *my program was done
 *it was perfect
 *i now have to rewrite it
 *i want to die
 *thank you
 *
 */
public class SetClass
   {
    /**
     * constant with default array capacity
     */
    public static final int DEFAULT_ARRAY_CAPACITY = 10;
    
    /**
     * integer array for data
     */
    int[] setArray;
    
    /**
     * capacity of array
     */
    int arrayCapacity;
    
    /**
     * number of values in array
     */
    int arraySize;
    
    /**
     * constants for specifying set data
     */
    public static final int INCREMENTED = 101;
    public static final int ODD = 102;
    public static final int EVEN = 103;
    public static final int PRIME = 104;
    
    /**
     * Default constructor
     * <p>
     * Initializes set array but sets power set array to null
     */
    public SetClass()
       {
         
         arrayCapacity = DEFAULT_ARRAY_CAPACITY;
         setArray = new int[ arrayCapacity ];
         arraySize = 0;
       }

    /**
     * Initialization constructor
     * <p>
     * Allows specification of set array capacity
     * <p>
     * Initializes set array but sets power set array to null
     * 
     * @param initialCapacity integer that specifies array capacity
     */
    public SetClass( int initialCapacity )
       {
    	
    	arrayCapacity = initialCapacity;
    	setArray = new int[ arrayCapacity ];
    	arraySize = 0;
       }

    /**
     * Copy constructor
     * <p>
     * Duplicates copied set class
     * <p>
     * Also responsible for correct initialization/update 
     * of power set array
     * 
     * @param copied SetClass object to be copied
     */
    public SetClass( SetClass copied)
       {
    	arraySize = copied.arraySize;
    	arrayCapacity = copied.arrayCapacity;
    	checkForResize();
    	setArray = new int[arrayCapacity];
        int index;
        for( index = 0; index < arraySize; index++)
        {
        	setArray[index] = copied.setArray[index];
        }
       }

    /**
     * Adds integer to set
     * <p>
     * increases capacity using checkForResize if array is full
     * <p>
     * does not allow duplicate values in set
     * 
     * @param item integer value to be added to set
     */
    public void addItem( int item )
       {
    	//check if the item has already been added
    	if(!hasElement(item))
    	{
    		checkForResize();
        	setArray[arraySize] = item;
        	arraySize++;
    	}
    	
       }

    /**
     * Local function tests for resize of the set array
     * <p>
     * If array needs to be resized, array capacity is doubled;
     * otherwise, no change
     * 
     * @return boolean report that resize was conducted
     */
    private boolean checkForResize()
       {
        int index;
    	if( arrayCapacity == arraySize)
    	{
    		arrayCapacity *=2;
    		int[] copyArray = new int[arrayCapacity];
    		for(index = 0; index < arraySize; index++ )
    		{
    			copyArray[index] = setArray[index];
    		}
    		setArray = copyArray;
    		
    		
    		return true;
    	}
    	return false;

    	// temporary stub return
       }
    
    /**
     * Returns the intersection of THIS set and the given other set
     * 
     * @param other SetClass data with which intersection is found
     * 
     * @return SetClass object with intersection of two sets
     */
    public SetClass findIntersection(SetClass other)
	{
		SetClass intersectionClass = new SetClass();
		int index;
		for(index = 0; index < other.arraySize; index++)
		{
			if(hasElement(other.setArray[index]))
			{
				intersectionClass.addItem(other.setArray[index] );
			}
		}
		return intersectionClass;
	}
    
    /**
     * Returns the union of THIS set and the given other set
     * 
     * @param other SetClass data with which union is found
     * 
     * @return SetClass object with union of two sets
     */
    public SetClass findUnion(SetClass other)
	{
		SetClass unionClass = new SetClass( other );
		int index;
		for(index = 0; index < this.arraySize; index++)
		{
			
			unionClass.addItem(this.setArray[index]);
		}
		return unionClass;
	}
    
    /**
     * Finds relative complement of THIS set in given other set
     * <p>
     * Returns other set having removed any items intersecting 
     * with THIS set
     * 
     * @param other SetClass object from which THIS SetClass items 
     * will be removed
     * 
     * @return SetClass object with data as specified
     */
    public SetClass findRelativeComplementOfThisSetIn( SetClass other )
       {
    	int index;
    	
    	SetClass relativeComplementClass = new SetClass();
    	//check if THIS set is a sub set of other set
        if( this.isSubsetOf(other))
        {
        	 for(index = 0; index < other.arraySize; index++)
        	 {
        		 //before adding the element, check if THIS set has the element
        		 //if so skip, if not add the item
            	 if(!this.hasElement(other.setArray[index]))
            	 {
            		 relativeComplementClass.addItem(other.setArray[index]);
            	 }
        	 } 
        } 
        return relativeComplementClass;  // temporary stub return
       }
    
    /**
     * Seeks and finds prime starting at given value
     * 
     * @param value integer value to start search for prime
     * 
     * @return next prime number
     */
    private int getNextPrime( int value)
	{
		while(!isPrime(value))
		{
			value++;
		}
		return value;
	}
    
    /**
     * Tests to indicate if integer value is one
     * of the set elements
     * 
     * @param testElement integer element to be found in set
     * 
     * @return boolean result of test
     */
    public boolean hasElement( int testElement )
       {
    	int index;
        for(index = 0; index < arraySize; index++)
        {
        	if(setArray[ index ] == testElement)
        	{
        		return true;
        	}
        }
        
        return false;  // temporary stub return
       }
    
    /**
     * Tests for even, reports
     * 
     * @param value integer value to be tested
     * 
     * @return boolean result as specified
     */
    private boolean isEven( int value )
       {
    	
    	return value % 2 == 0;
    
       }
    
    /**
     * Tests to indicate if set is subclass of another given set
     * 
     * @param other SetClass object to be tested
     * if THIS set is a subset of it
     * 
     * @return boolean result of test
     */
    public boolean isSubsetOf(SetClass other)
	 {
		 int thisIndex, otherIndex;
		 for(thisIndex = 0; thisIndex < this.arraySize; thisIndex++)
		 {
			 for(otherIndex = 0; otherIndex < other.arraySize; otherIndex++)
			 {
				 if(this.hasElement(other.setArray[otherIndex]))
				 {
					 return true;
				 }
			 }
			 if(other.hasElement(this.setArray[thisIndex]))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
    
    /**
     * Removes value at given index;
     * moves all succeeding data down in array
     * 
     * @param indexToRemove integer index of element value to remove
     */
    private void removeAtIndex( int indexToRemove )
       {
    	int index;
        for( index = indexToRemove; index < arraySize; index++)
        {
        	setArray[index] = setArray[index + 1];
        	
        }
        arraySize--;
       }    
    
    /**
     * Removes value if it is found in set
     * 
     * @param valToRemove integer value to be removed
     * 
     * @return boolean result of operation success
     */
    public boolean removeValue( int valToRemove )
       {
    	int index;
    	if (hasElement(valToRemove))
    		{
    		for(index = 0; index < arraySize; index++)
    			{
    			if( setArray[index] == valToRemove)
           	 		{
           		 	removeAtIndex(index);
           		 	
           		 	return true;
           	 		}
    			}
    		}
    	return false;
       }
    
////////////////////////////////////////////////////////////////////////////////
// DO NOT MODIFY CODE BELOW THIS LINE (but you may use the methods)
////////////////////////////////////////////////////////////////////////////////
    /**
     * Tests to indicate if given integer value is prime
     * 
     * @param testVal integer value given
     * 
     * @return boolean result of test
     */
    private boolean isPrime( int testVal )
       {
        int modVal = 2;
        int testDivide = (int)( Math.ceil( Math.sqrt( (double)testVal ) ) );
        
        while( modVal <= testDivide ) 
           {
            if( testVal % modVal == 0 )
               {
                return false;
               }
            
            modVal++;
           }
        
        return true;
       }
    
    /**
     * Loads a number of specified integers to set
     * <p>
     * Characteristics may be odd, even, incremented, or prime
     * <p> 
     * Parameter four is only used with INCREMENTED
     * 
     * @param startValue integer value indicates starting value
     * 
     * @param numItems integer number of items to load
     * 
     * @param valueCharacteristic integer characteristic code 
     * (ODD, EVEN, INCREMENTED, PRIME )
     * 
     * @param incrementBy integer value used to specify increment
     * if INCREMENTED characteristic is set
     */
    public void loadItems( int startValue, int numItems, 
                                   int valueCharacteristic, int incrementBy )
       {
        int index, runningValue = startValue;
        
        if( valueCharacteristic == ODD || valueCharacteristic == EVEN )
           {
            if( valueCharacteristic == ODD && isEven( runningValue ) 
                || valueCharacteristic == EVEN && !isEven( runningValue ) )
               {
                runningValue++;
               }
            
            for( index = 0; index < numItems; index++ )
               {
                addItem( runningValue );
                
                runningValue += 2;
               }
           }
        
        else if( valueCharacteristic == PRIME )
           {
            // decrement by one for the first iteration
            runningValue--;
            
            for( index = 0; index < numItems; index++ )
               {
                runningValue = getNextPrime( runningValue + 1 );
                
                addItem( runningValue );
               }
           }
        
        else  // assume incremented
           {
           for( index = 0; index < numItems; index++ )
              {
               addItem( runningValue );
               
               runningValue += incrementBy;
              }
           }
       }

    /**
     * Provides list of set array elements
     * as comma-delimited string
     */
    @Override
    public String toString()
       {
        int index;
        String outString = "";
        
        for( index = 0; index < arraySize; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
            
            outString += setArray[ index ];
           }
        
        return outString;        
       }
   
}
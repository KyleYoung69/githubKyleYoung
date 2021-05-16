package p11_package;

public class ProbingStateHashClass
{
	private final int DEFAULT_TABLE_SIZE =11;
	public final int ITEM_NOT_FOUND = -1;
	public static final int LINEAR_PROBING = 101;
	private int probeFlag;
	public static final int QUADRATIC_PROBING =102;
	private StateDataClass[] tableArray;
	private int tableSize;
	
	public ProbingStateHashClass()
	{
		//Initializes to default table size with probe flag set to linear probing
		clearHashTable();
		tableSize = DEFAULT_TABLE_SIZE;
		probeFlag = LINEAR_PROBING;
		tableArray = new StateDataClass[tableSize];
		
	}
	public ProbingStateHashClass(int inProbeFlag)
	{
		clearHashTable();
		tableSize = DEFAULT_TABLE_SIZE;
		probeFlag = inProbeFlag;
		tableArray = new StateDataClass[tableSize];
	}
	public ProbingStateHashClass(int inTableSize,
            int inProbeFlag)
	{
		
		clearHashTable();
		if(inTableSize < DEFAULT_TABLE_SIZE)
		{
			inTableSize = DEFAULT_TABLE_SIZE;
		}
		tableSize = inTableSize;
		probeFlag = inProbeFlag;
		tableArray = new StateDataClass[tableSize];
	}
	public ProbingStateHashClass(ProbingStateHashClass copied)
	{
		clearHashTable();
		tableSize = copied.tableSize;
		probeFlag = copied.probeFlag;
		int index;
		tableArray = new StateDataClass[tableSize];
		for(index =0; index < tableSize; index++)
		{
			tableArray[index] = new StateDataClass( copied.tableArray[index]);
		}
	}
	public boolean addItem(StateDataClass newItem)
	  {
	    int probeAttempts = 0;
	    int originalHashIndex = generateHash(newItem);
	    int tempHashIndex = originalHashIndex;
	    String probedString = "" + tempHashIndex;

	    // if the current bin is taken and we have not exceeded probe attempts
	    while(this.tableArray[tempHashIndex] != null
	        && probeAttempts < this.tableSize)
	    {
	      // increase probe attempts and check which probe flag is active
	      probeAttempts++;
	      if(this.probeFlag == LINEAR_PROBING)
	      {
	        // linear probing only increases the hash index by one each time
	        tempHashIndex = originalHashIndex + probeAttempts;
	      }
	      else
	      {
	        // quadratic probing increases hash index squared
	        tempHashIndex = originalHashIndex + toPower(probeAttempts, 2);
	      }
	      // modulos division in case hashIndex becomes larger than table size
	      tempHashIndex = tempHashIndex % this.tableSize;
	      probedString = probedString + ", " + tempHashIndex;
	    }
	    // check if current bin is empty
	    if(tableArray[tempHashIndex] == null)
	    {
	      System.out.println("Indices probed: " + probedString);
	      System.out.println(newItem.toString() + ", " + generateHash(newItem)
	          + " -> " + tempHashIndex);
	      // add item to table at current index and return true
	      tableArray[tempHashIndex] = newItem;
	      return true;
	    }
	    return false;
	  }
	public void clearHashTable()
	{
		//Clears hash table by setting all bins to null
		int index;
		for(index = 0; index < tableSize; index++)
		{
			tableArray[index] = null;
		}

	}
	public StateDataClass findItem(StateDataClass searchItem)
	{
		int index= findItemIndex(searchItem);
		// loop while value not found at the current index
		// AND value not equal to search value
		if(index != ITEM_NOT_FOUND)
		{
			return tableArray[index];
		}
		return null;

		//Returns item found

	}
	private int findItemIndex(StateDataClass searchItem)
	{
		//Searches for item index in hash table
		int probeAttempts =0;
		int hashIndex =  generateHash(searchItem);
		int probe;
		for(probeAttempts = 0; probeAttempts < tableSize; probeAttempts++)
		{
			
			if(probeFlag == LINEAR_PROBING)
			{
				probe = (hashIndex + probeAttempts) % tableSize;
				
			}
			else
			{
				probe = (hashIndex + toPower(probeAttempts, 2)) % tableSize;
				
			}
			if(tableArray[probe] != null)
			{
				if(tableArray[probe].compareTo(searchItem) == 0)
				{
					return probe;
				}
			}
		}
		//Note: Uses linear or quadratic probing as configured
				//Note: probing attempts limited to table size (capacity)
				//Note: Probed indices are reported to screen
				return ITEM_NOT_FOUND;
		
	}





	
	public int generateHash(StateDataClass item)
	{
		//Method converts StateDataClass hash value to index for use in hash table
		//Sums the Unicode/ASCII values of all letters in the state name; then finds index
		int generatedHash = 0, index;
		for(index = 0; index < item.state.length(); index++)
		{
			generatedHash += (int)item.state.charAt(index);
			
		}
		return generatedHash % tableSize;
		
		



	}
	public StateDataClass removeItem(StateDataClass toBeRemoved)
	{
		//Removes item from hash table
		int probeAttempts;
		int hashIndex = generateHash(toBeRemoved);
		int foundItemIndex = findItemIndex(toBeRemoved);
		int probe;
		
		for(probeAttempts = 0; probeAttempts < tableSize; probeAttempts++)
		{
			if(probeFlag == LINEAR_PROBING)
			{
				probe = (hashIndex + probeAttempts) % tableSize;
				if(tableArray[(hashIndex + probeAttempts) % tableSize] != null)
				{
					if(tableArray[(hashIndex + probeAttempts) % tableSize].compareTo(toBeRemoved) == 0 
							&& (hashIndex + probeAttempts) % tableSize == foundItemIndex)
					{
						tableArray[(hashIndex + probeAttempts) % tableSize] = null;
					}
				}
				
			}
			else if(probeFlag == QUADRATIC_PROBING)
			{
				if(tableArray[(hashIndex + toPower(probeAttempts, 2)) % tableSize] != null)
				{
					if(tableArray[(hashIndex + toPower(probeAttempts, 2)) % tableSize].compareTo(toBeRemoved) ==0
							&& (hashIndex + toPower(probeAttempts, 2)) % tableSize == foundItemIndex)
					{
						tableArray[(hashIndex + toPower(probeAttempts, 2)) % tableSize] = null;
					}
					
				}
				
			}
			
		}
		
		
		return toBeRemoved;
		

	}
	public String showHashTableStatus()
	{
		//traverses through all array bins, finds min and max number of contiguous elements, and number of empty nodes; also shows table loading
		//NOTE: Generates string of used and unused bins in addition to displaying results on screen
		int probeAttempts;
		String hashTableStatus = "";
		int emptyBins = 0;
		int maxContigousBins = 0;
		int minContigousBins =0;
		int currentContigousBin = 0;
		StateDataClass currentSearchItem;
		int index, hashIndex, foundItemIndex;
		for(index = 0; index < tableSize; index++)
		{
			if(tableArray[index] !=null)
			{
				currentContigousBin+= 1;
				hashTableStatus += 'D';
			}
			else
			{
				if(currentContigousBin < minContigousBins || minContigousBins ==0)
				{
					minContigousBins = currentContigousBin;
				}
				if(currentContigousBin > maxContigousBins)
				{
					maxContigousBins = currentContigousBin;
				}
				currentContigousBin = 0;
				emptyBins++;
				hashTableStatus += 'N';
			}
		}
	
		
		System.out.printf("\nHash Table Status: " + hashTableStatus + "\n");
		
		System.out.printf("Minimum contigous bins: " + minContigousBins + "\n");
		System.out.printf("Maximum contigous bins: " + maxContigousBins + "\n");
		System.out.printf("Number of empty bins: " + emptyBins + "\n");
		
		System.out.println("Array Dumpy: ");
		for(index = 0; index < tableSize; index++)
		{
			if(tableArray[index] == null)
			{
				System.out.println("null");
			}
			else
			{
				System.out.println(tableArray[index].toString());
			}
		}
		return hashTableStatus;


	}
	private int toPower(int base,
            int exponent)
	{
		//Local recursive method to calculate exponentiation with positive integers
		if(exponent > 1)
		{
			return base * toPower(base, exponent -1);
		}
		return 1;

	}




 




}

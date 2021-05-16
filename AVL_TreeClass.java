package p9_package;

public class AVL_TreeClass 
{
	private class Node
	{
		private char data;
		private Node rightChildRef;
		private Node leftChildRef;
		
		Node( Node copied )
		{
			//copy constructor for AVL tree node
			data = copied.data;
			leftChildRef = null;
			rightChildRef = null;

		}
		Node(char inData)
		{
			data = inData;
			leftChildRef = null;
			rightChildRef = null;
		}
		Node(char inData, AVL_TreeClass.Node leftRef, AVL_TreeClass.Node rightRef)
		{
			//Initialization constructor for data and child references
			data = inData;
			leftChildRef = leftRef;
			rightChildRef = rightRef;

		}
		
		
	}
	
	private static char DASH = 45;
	private final char NULL_CHAR = 0;
	private boolean rowStartFlag;
	private static final char SPACE = 32;
	private Node treeRoot;
	
	public AVL_TreeClass()
	{
		this.treeRoot = null;
		rowStartFlag = false;
		//Default class constructor
		

	}
	public AVL_TreeClass( AVL_TreeClass copied)
	{
		
		this.treeRoot = copyConstructorHelper(copied.treeRoot);
		rowStartFlag = false;
	}
	public void clearTree()
	{
		this.treeRoot = null;
	}
	private Node copyConstructorHelper(Node wkgRef)
	{
		//Note: Uses preorder strategy to copy nodes
		if(wkgRef !=null)
		{
			Node node = wkgRef;
			node.leftChildRef = copyConstructorHelper(wkgRef.leftChildRef);
			node.rightChildRef = copyConstructorHelper(wkgRef.rightChildRef);
			return node;
		}
		return null;
	}
	private void displayChars(int numChars,
            char outChar)
	{
		if(numChars > 0)
		{
			System.out.print(outChar);
			displayChars(numChars -1, outChar);
			
			
		}
	}
	public int findTreeHeight()
	{
		return getTreeHeight(treeRoot);
	}
	private int getBalanceFactor(Node wkgLocalRef)
	{
//		/gets balance factor indicating if tree is unbalanced from given root down
		//The balance factor is found by subtracting the left child's height from the 
		//right child's height.
		if(wkgLocalRef == null)
		{
			return 0;
		}
		return getTreeHeight(wkgLocalRef.rightChildRef)-
							getTreeHeight(wkgLocalRef.leftChildRef);
		
		
	}
	private int getMax(int one,
            int other)
	{
		//Finds maximum of two given numbers
		if(one > other)
		{
			return one;
		}
		else
		{
			return other;
		}

	}
	private int getTreeHeight(Node wkgLocalRef)
	{
		//Tree height helper method
		if(wkgLocalRef != null)
		{
		 int leftHeight = getTreeHeight(wkgLocalRef.leftChildRef);
		 int rightHeight = getTreeHeight(wkgLocalRef.rightChildRef);
		 //uses getMax
		 if(getMax(leftHeight, rightHeight) == 
				 leftHeight)
		 {
			 return leftHeight + 1;
		 }
		 else
		 {
			 return rightHeight + 1;
		 }
			
		}
		return -1;
	}
	public void inOrderDisplay()
	{
		inOrderDisplayHelper(this.treeRoot);
	}
	private void inOrderDisplayHelper(AVL_TreeClass.Node wkgLocalRef)
	{
		if(wkgLocalRef != null)
		{
			//go left
			inOrderDisplayHelper(wkgLocalRef.leftChildRef);
			System.out.print(wkgLocalRef.data);
			//go right
			inOrderDisplayHelper(wkgLocalRef.rightChildRef);
		}
	}

	public void insert(char inData)
	{
		treeRoot = insertHelper(treeRoot, inData);
		
	}
	private Node insertHelper(Node wkgLocalRef,
            char inData)
	{
		if(wkgLocalRef != null)
		{
			if( wkgLocalRef.data > inData)
			{
				wkgLocalRef.leftChildRef = insertHelper(wkgLocalRef.leftChildRef, inData);
			}
			else if(wkgLocalRef.data < inData)
			{
				wkgLocalRef.rightChildRef = insertHelper(wkgLocalRef.rightChildRef, inData);
			}
			else
			{
				wkgLocalRef.data = inData;
			}
		}
		else
		{
			wkgLocalRef = new Node(inData);
			//find balance factor and assing it to a variable
			int balanceFactor = getBalanceFactor(wkgLocalRef);
			//Once the balance factor is found, there are five possible conditions:

			//If the balance factor is not more than one 
			//or less than negative one, 
			//nothing happens and the method completes
			if( balanceFactor != 0)
				{
					//If the balance factor is greater than one,
					//and the new data is less than its parent data, 
						//there is a Left Left condition

						if(balanceFactor > 1 && inData < wkgLocalRef.data)
						{
							//there is a Left Left condition
							wkgLocalRef = rotateLeft(rotateLeft(wkgLocalRef));
						}
						//If the balance factor is less than negative one,
						//and the new data is greater than its parent data,
						else if(balanceFactor  < -1 && inData > wkgLocalRef.data)
						{
							 //there is a Right Right condition
							wkgLocalRef = rotateRight(rotateRight(wkgLocalRef));

						}
						//If the balance factor is greater than one, 
						//and the new data is greater than its parent data, 
						else if(balanceFactor > 1 && inData > wkgLocalRef.data)
						{
							//there is a Left Right condition
							wkgLocalRef = rotateLeft(rotateRight(wkgLocalRef));
						}
						//If the balance factor is less than negative one, 
						//and the new data is less than its parent data,
						else if(balanceFactor < -1 && inData < wkgLocalRef.data)
						{
							//there is a Right Left condition
							wkgLocalRef = rotateRight(rotateLeft(wkgLocalRef));

						}
					}
			
		}
		
		return wkgLocalRef;
	}
	public boolean isEmpty()
	{
		return treeRoot == null;
	}
	private Node rotateLeft(Node wkgLocalRef)
	{
		//assign the right childs left child to temporary
		Node newParent = wkgLocalRef.rightChildRef;
		Node subTree = newParent.leftChildRef;
		newParent.leftChildRef = wkgLocalRef;
		wkgLocalRef.rightChildRef = subTree;
		displayTreeStructure();
		return newParent;
	}
	private Node rotateRight(Node wkgLocalRef)
	{
		   
		// assign the left child right child to a temporary
		Node newParent = wkgLocalRef.leftChildRef;
		Node subTree = newParent.rightChildRef;
		//assign the reference tof hte node to left nodes right child./
		newParent.rightChildRef = wkgLocalRef;
		//assing temporary to  left child
		wkgLocalRef.leftChildRef = subTree;
		displayTreeStructure();
		return newParent;
		
	}
	public char search(char searchData)
	{
		//Searches for data in AVL Tree given char with necessary key
		return searchHelper(treeRoot, searchData);
	}
	private char searchHelper(AVL_TreeClass.Node wkgLocalRef,
            char searchData)
	{
		if(wkgLocalRef != null)
		{
			if(wkgLocalRef.data > searchData)
			{
				return searchHelper(wkgLocalRef.leftChildRef, searchData);
			}
			else if(wkgLocalRef.data < searchData)
			{
				return searchHelper(wkgLocalRef.rightChildRef, searchData);
			}
			return wkgLocalRef.data;

		}
		return NULL_CHAR;
	}
	private int toPower(int base,
            int exponent)
	{
		//Local recursive method to calculate exponentiation with integers
		if(exponent > 0)
			{
				return base * toPower(base, exponent -1);
			}
			return 1;
		
		
	}
	
	 /**
     * [NOT ASSIGNED] Displays text-graphical representation of one level/line
     * of the AVL tree
     * 
     * @param workingNode node reference at current recursive level
     * 
     * @param nodeHeight height of tree plus two
     * for current height of nodes, including lowermost null children
     * 
     * @param displayLevel level of tree at which the current line
     * of display is to be presented
     * 
     * @param workingLevel current level during recursive actions
     */
    private void displayAtTreeLevel( Node workingNode, int nodeHeight, 
                                       int displayLevel, int workingLevel )
       {
        char charOut = workingNode.data;
        
        if( workingLevel == displayLevel )
           {
            displayValue( charOut, nodeHeight, workingLevel );
    
            return;
           }
        
        if( workingNode.leftChildRef != null )
           {
            displayAtTreeLevel( workingNode.leftChildRef, nodeHeight,
                                           displayLevel, workingLevel + 1 );
           }
        
        else
           {
            displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
           }
            
        if( workingNode.rightChildRef != null )
           {
            displayAtTreeLevel( workingNode.rightChildRef, nodeHeight,
                        displayLevel, workingLevel + 1 );
           }
    
        else
           {
            displayEmptyNodeSpaces( nodeHeight, displayLevel, workingLevel + 1 );
           }              
       }

    /**
     * [NOT ASSIGNED] Method that displays null or blank nodes
     * for a tree at null locations
     * <p>
     * Note: used by displayAtTreeLevel
     * 
     * @param nodeHeight height of tree plus two
     * for current height of nodes, including lowermost null children
     * 
     * @param displayLevel level of the tree at which
     * the display will be applied
     * 
     * @param workingLevel level of tree just below
     * non-null node at which method is currently working
     */
    private void displayEmptyNodeSpaces( int nodeHeight, 
                                        int displayLevel, int workingLevel )
       {
        int nodesToDisplay = toPower( 2, displayLevel - workingLevel ); 
        char charOut = SPACE;
        
        if( displayLevel == workingLevel )
           {
            charOut = DASH;
           }
        
        while( nodesToDisplay > 0 )
           {
            displayValue( charOut, nodeHeight, displayLevel );
            
            nodesToDisplay--;
           }
       }

    /**
     * [NOT ASSIGNED] Displays text-graphical representation of AVL tree
     *  
     */
    public void displayTreeStructure()
       {
        int displayLevel, nodeHeight = getTreeHeight( treeRoot ) + 2;
        int workingLevel = 1;
        
        if( treeRoot != null )
           {
            for( displayLevel = 1; displayLevel <= nodeHeight; displayLevel++ )
               {
                rowStartFlag = true;
                
                displayAtTreeLevel( treeRoot, nodeHeight, 
                                             displayLevel, workingLevel );
                
                System.out.println();
               }
           }
        
        else
           {
            System.out.println( "\nEmpty Tree - No Display");
           }
       }

    /**
     * [NOT ASSIGNED] Method used to display a character or color letter
     * along with calculated leading spaces
     * <p>
     * Note: used in displayAtTreeLevel and displayEmptyNodeSpaces
     * 
     * @param data data value to display, either letter or color data
     * 
     * @param nodeHeight height of tree plus two
     * for current height of nodes, including lowermost null children
     * 
     * @param workingLevel current level during recursive actions
     */
    private void displayValue( char data, int nodeHeight, int workingLevel )
       {
        int leadingSpaces;
        
        if( rowStartFlag )
           {
            leadingSpaces = toPower( 2, nodeHeight - workingLevel );
    
            rowStartFlag = false;
           }
        
        else
           {
            leadingSpaces = toPower( 2, nodeHeight - workingLevel + 1 ) - 1;
           }
    
        displayChars( leadingSpaces, SPACE );
        
        System.out.print( data );         
       }





	



}

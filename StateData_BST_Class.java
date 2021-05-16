package p8_package;

public class StateData_BST_Class
{
	private int displayCounter;
	static int IN_TRAVERSE = 102;
	static int POST_TRAVERSE = 103;
	static int PRE_TRAVERSE = 101;
	private StateDataClass rootNode;
	
	StateData_BST_Class()
	{
		this.rootNode = null;
		displayCounter = 0;
	}
	StateData_BST_Class(StateData_BST_Class copied)
	{
		this.rootNode = copyConstructorHelper(copied.rootNode);
		
	}
	
	void clearTree()
	{
		this.rootNode = null;
	}
	int compareStrings(String one, String other)
	{
		//If first string parameter is greater than the second, method returns positive value
		//if first string parameter is less than second, return negative value;
		//if first string parameter and second string parameter are equal, returns zero
       
		
		int lengthMinimum = Math.min(one.length(), other.length());
		int strOneChar, strTwoChar;
		int index;
		//this part lets us know if strOne is greater than strTwo if its a positive or negative number
		for(index = 0; index < lengthMinimum; index++ )
		{
			strOneChar = (int)one.charAt(index);
			strTwoChar = (int)other.charAt(index);
			
			if(strOneChar != strTwoChar )
			{
				return strOneChar - strTwoChar;
			}
		}
		
		//check to see if part of word is in other word.
		
			return one.length() - other.length();
        
     
	}
	private StateDataClass copyConstructorHelper(StateDataClass wkgRef)
	{
		//Copy constructor helper
		//Recursively copies nodes using pre order traversal
		if(wkgRef != null)
		{
			StateDataClass node = wkgRef;
			node.leftChildRef = copyConstructorHelper(wkgRef.leftChildRef);
			node.rightChildRef = copyConstructorHelper(wkgRef.rightChildRef);
			
			//check left
			return node;
		}
		return null;
		
		
		


	}
	private void displayInOrder(StateDataClass wkgRef)
	{
		//Provides inOrder traversal action using recursion
		// In order means go left, print parent, then go right
		// The method only needs about a half dozen lines all together
		// In order means go left
		if(wkgRef != null)
		{
		
			displayInOrder(wkgRef.leftChildRef);
			//print parent
			displayCounter++;
			System.out.print(displayCounter + ": ");
			System.out.println(wkgRef.toString());
			//go right
			displayInOrder(wkgRef.rightChildRef);
		}
			
			
		

	}
	private void displayPostOrder(StateDataClass wkgRef)
	{
		if(wkgRef != null)
		{

			displayPostOrder(wkgRef.leftChildRef);
			displayPostOrder(wkgRef.rightChildRef);
			displayCounter++;
			System.out.print(displayCounter + ": ");
			System.out.println(wkgRef.toString());
			
		}
		
		//Provides postOrder traversal action using recursion

	}
	private void displayPreOrder(StateDataClass wkgRef)
	{
		//Provides preOrder traversal action using recursion
		if(wkgRef != null)
		{
			
			displayCounter++;
			System.out.print(displayCounter + ": ");
			System.out.println(wkgRef.toString());
			displayPreOrder(wkgRef.leftChildRef);
			displayPreOrder(wkgRef.rightChildRef);
		}
		

	}
	public void displayTree(int traverseCode)
	{
		displayCounter =0;
		if(traverseCode == IN_TRAVERSE)
		{
			displayInOrder(this.rootNode);
		}
		else if(traverseCode == POST_TRAVERSE)
		{
			displayPostOrder(this.rootNode);
		}
		else if(traverseCode == PRE_TRAVERSE)
		{
			displayPreOrder(this.rootNode);
		}
	}
	public void insert(StateDataClass inData)
	{
		//Insert method for BST
		//Note: calls the insert helper to implement all the data insertions
		rootNode = insertHelper(rootNode, inData);

	}
	private StateDataClass insertHelper(StateDataClass wkgRef,
            StateDataClass inData)
	{
		
		if(wkgRef != null)
		{
			int compareCheck = compareStrings(wkgRef.state, inData.state);
			if(compareCheck > 0)
			{
				wkgRef.leftChildRef =  insertHelper(wkgRef.leftChildRef, inData);
			}
			else if(compareCheck  < 0)
			{
				wkgRef.rightChildRef = insertHelper(wkgRef.rightChildRef, inData);
			}
			else
			{
				wkgRef.setData(inData);
			}
		}
		else
		{
			wkgRef = new StateDataClass(inData);
		}
		
		
		return wkgRef;
	}
	public boolean isEmpty()
	{
		//Test for empty tree
		return rootNode == null;
	}
	private StateDataClass removeFromMin(StateDataClass parentRef,
            StateDataClass childRef)
	{
		//Searches tree from given working reference to minimum value found below it in farthest left node,
		//stores data value found, unlinks the found node,
		//links the parent node's left node to the child's right node,
		//and returns the child/found node to the calling method
		if(parentRef.leftChildRef != null)
		{
			return removeFromMin(childRef, childRef.leftChildRef);
		}
		return parentRef.leftChildRef = childRef.rightChildRef;
		
		
	}
	public StateDataClass removeItem(StateDataClass outData)
	{
		//Removes data StateDataClass node from tree using given key
		//Note: uses remove helper method
		//Note: uses search initially to get value, if it is in tree; 
		//if value found, remove helper method is called, otherwise returns null
		
		//call search, and get the value (outdata)
		StateDataClass result = search(outData);
		
		//check if search result was not null
		if(result != null)
		{
			//assign the result reference to new node  using result object
			//call the remove helper, assign to rootnode
			result = new StateDataClass(result);
			rootNode = removeItemHelper(rootNode, result);
		}
			 
		
		//end if
		return result;
		//return result




	}
	private StateDataClass removeItemHelper(StateDataClass wkgRef,
            StateDataClass outData)
	{
		//Remove helper for BST remove action
		//Note: Recursive method returns updated local root to maintain tree linkage
		//Note: uses removeFromMin method
		//shopping list one
		if(wkgRef != null)
		{
			int key = compareStrings(wkgRef.state,outData.state);
			//1) is the value less than current node
			if(key > 0)
			{
				//-recurse left
				wkgRef = removeItemHelper(wkgRef.leftChildRef, outData);
			}
			//is node greater than current node
			else if(key < 0)
			{
				//-recurse right
				wkgRef = removeItemHelper(wkgRef.rightChildRef, outData);
			}
			//we found it
			else
			{
				//shopping list two
				
				//2) is the node to left of current empty/null
				if(wkgRef.leftChildRef == null)
				{
					//-return right node reference
					wkgRef = wkgRef.rightChildRef;
				}
				//is the node to the right of current empty/ null
				else if(wkgRef.rightChildRef == null)
				{
					//-return left node reference
					wkgRef = wkgRef.leftChildRef;
				}
				//there are two children
				else
				{
					//shopping list three
					//3) is the right child of the current node's left child null/ empty
					if(wkgRef.rightChildRef.leftChildRef != null)
					{
						//- take data from  left child and replace the current node data 
						// You have to  take the data out of this node and put it in the current node
						wkgRef = removeFromMin(wkgRef, wkgRef.rightChildRef);
					}
					else
					{
						//- link from current node to the left child's left child.
						// You have to take the data out of the right child and put it in the current node
						wkgRef.setData(wkgRef.rightChildRef); 
						wkgRef.rightChildRef = wkgRef.rightChildRef.rightChildRef;
					}
				}
				//There are two children
				
			}
		}
		
	
		return  wkgRef ;
		
		//Node removal shopping list
				//1) is the value less than current node
				//-recurse left
				//is node greater than current node
				//-recurse right
				
				//we found it
				
				//2) is the node to left of current empty/null
				//-return right node reference
				//is the node to the right of current empty/ null
				//-return left node reference
				
				//there are two children
				//3) is the right child of the current node's left child null/ empty
				//- take data from  left child and replace the current node data 
				//- link from current node to the left child's left child.
				//otherwise, assume left child has a right child





	}
	public StateDataClass search(StateDataClass searchData)
	{
		//Searches for data in BST given StateDataClass referencewith necessary key
		return searchHelper(rootNode, searchData);
	}
	private StateDataClass searchHelper(StateDataClass wkgRef,
            StateDataClass searchData)
	{
		//Helper method for recursive BST search action
		//case if ref is null or key is present
		
		   // check for root not null
		if(wkgRef != null )
		{
			int key = compareStrings(wkgRef.state,searchData.state);
			if(key > 0)
			{
				//search data's state is greater than wkgRef state
				return searchHelper(wkgRef.leftChildRef, searchData);
			}
			if(key < 0)
			{
				return searchHelper(wkgRef.rightChildRef, searchData);
			}
		
		}
		
		return wkgRef;
		
		

	}





	

	
	



}

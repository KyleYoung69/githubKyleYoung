package package_8;

public class TwoDimArrayClass
   {
      private static final int DEFAULT_MAX_CAPACITY = 100;
      private static final int DEFAULT_MIN_CAPACITY = 3;
      public static final int FAILED_ACCESS = -999999;
      private int[][] localTD_Array;
      private int rowCapacity;
      private int colCapacity;
      private int maxCapacity;
      
      public TwoDimArrayClass()
         {
            rowCapacity = DEFAULT_MIN_CAPACITY;
            colCapacity = DEFAULT_MIN_CAPACITY;
            maxCapacity = DEFAULT_MAX_CAPACITY;
            localTD_Array = new int[rowCapacity][colCapacity];
         }
      
      public TwoDimArrayClass( int rowCap, int colCap, int maxCap )
         {
            maxCapacity = maxCap;
            if ( rowCap < DEFAULT_MIN_CAPACITY )
               {
                 rowCapacity = DEFAULT_MIN_CAPACITY;
               }
             else
               {
                 rowCapacity = rowCap;
               }

             if ( rowCapacity > DEFAULT_MAX_CAPACITY )
               {
                 rowCapacity = DEFAULT_MAX_CAPACITY;
               }
             else
               {
                 rowCapacity = rowCap;
               }

             if ( colCap < DEFAULT_MIN_CAPACITY )
               {
                 colCapacity = DEFAULT_MIN_CAPACITY;
               }
             else
               {
                 colCapacity = colCap;
               }

             if ( colCap > DEFAULT_MAX_CAPACITY )
               {
                 colCapacity = DEFAULT_MAX_CAPACITY;
               }
             else
               {
                 colCapacity = colCap;
               }

            localTD_Array = new int[rowCapacity][colCapacity];
         }
      
      public TwoDimArrayClass( TwoDimArrayClass copied )
         {
            int rowIndex, colIndex;
            int[][] tempArray;
            rowCapacity = copied.rowCapacity;
            colCapacity = copied.colCapacity;
            maxCapacity = copied.maxCapacity;
            localTD_Array = copied.localTD_Array;
               
            tempArray = new int[rowCapacity][colCapacity];
            for (rowIndex = 0; rowIndex < rowCapacity; rowIndex++)
               {
                  for (colIndex = 0; colIndex < colCapacity; colIndex++)
                     {
                        tempArray[rowIndex][colIndex] = 
                                              localTD_Array[rowIndex][colIndex];
                     }
               }
            localTD_Array = tempArray;
         }


      
      
      
      
      public int accessItemAt( int rowAccessIndex, int colAccessIndex )
         {            
            if ( (rowAccessIndex < rowCapacity) && 
                           (colAccessIndex < colCapacity) )
               {
                  return localTD_Array[rowAccessIndex][colAccessIndex];
               }
            
            return FAILED_ACCESS;
     
         }
      
      public boolean arrayIndicesWithinMaxBounds( int testedRowIndex, 
                                                         int testedColIndex )
         {
            if ( (testedRowIndex < rowCapacity) && 
                              (testedColIndex < colCapacity) )
               {
                  return true;
               }
            else
               {
                  return false;
               }
         }
      
      public void dumpTwoDimArray()
         {
            int rowIndex, colIndex;
            
            for (rowIndex = 0; rowIndex < rowCapacity; rowIndex++)
               {
                  for (colIndex = 0; colIndex < colCapacity; colIndex++)
                     {
                        if (localTD_Array[rowIndex][colIndex]!= FAILED_ACCESS)
                           {
                              System.out.print(localTD_Array[rowIndex][colIndex] 
                                    + ",\t");
                                                
                           }
                     }
                  System.out.println(" ");
               }
         }
      
      public int getCurrentRowCapacity()
         {
            return rowCapacity;
         }
      
      public int getCurrentColCapacity()
         {
            return colCapacity;
         }
      
      public void resize( int newRowCapacity, int newColCapacity )
         {
            int[][] tempArray;
            int rowIndex, colIndex;
            
            tempArray = new int[newRowCapacity][newColCapacity];
                for ( rowIndex = 0; rowIndex < rowCapacity; rowIndex++)
                   {
                      for ( colIndex = 0; colIndex < colCapacity; 
                                                                  colIndex++)
                         {
                            tempArray[rowIndex][colIndex] = 
                                    localTD_Array[rowIndex][colIndex];
                         }
                   }
             
            localTD_Array = tempArray;
            rowCapacity = newRowCapacity;
            colCapacity = newColCapacity;

         }
      
      public boolean setItemAt( int rowIndexToSet, int colIndexToSet, 
                                                               int newValue)
         {
            if ((rowIndexToSet < rowCapacity) && (colIndexToSet < colCapacity))
               {
                  if (arrayIndicesWithinMaxBounds(rowIndexToSet, colIndexToSet))
                     {
                        localTD_Array[rowIndexToSet][colIndexToSet] = newValue;
                        return true;
                     }
               
                  else
                     {
                        resize(rowIndexToSet, colIndexToSet);
                        localTD_Array[rowIndexToSet][colIndexToSet] = newValue;
                        return true;
                     }
                            
                 }
            return false;
         }
   }

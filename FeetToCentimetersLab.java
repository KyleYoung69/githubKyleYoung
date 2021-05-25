package package_2;
import javax.swing.JOptionPane;
public class FeetToCentimetersLab
   {
    private static final char ENDLINE_CHAR = '\n';
    private static final char SPACE = ' ';
    private static final char LINE = '|' ;
    private static final char EQUAL = '=' ;
    private static final char DASH = '-' ;
    
    
    
    
    
      public static void main(String[] args)
         {
          // declare variables
    	  
          String inputHeightFeet, inputHeightInch, strWord ;
          double numHeightFeet, numHeightInch ;
          double outputHeightCenti ;
          double totalInches ; 
          int numChars , numBlockSize, numPer;
          JOptionPane userInput = new JOptionPane() ;
          
          
          // get input from user
          
          inputHeightFeet = userInput.showInputDialog("Enter Height in Feet") ;
          inputHeightInch = userInput.showInputDialog("Enter Height in Inches") ;
          
          // translate to integer values
          
          numHeightFeet = Double.parseDouble(inputHeightFeet);
          numHeightInch = Double.parseDouble(inputHeightInch) ;
          
          // calculate results
          totalInches = (numHeightFeet * 12) + numHeightInch ;
          outputHeightCenti = totalInches * 2.54; 
          

          // display results
          
          // line 1
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 25;
          printChars(numChars, EQUAL) ;
          numChars = 1;
          printChars(numChars, LINE) ; 
          numChars = 10;
          printChars(numChars, EQUAL) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 12;
          printChars(numChars, EQUAL) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          printEndLine();
          
          //line 2
          printChars(numChars, LINE) ;
          strWord = "Input Name";
          numBlockSize = 25;
          printCenterJustifiedString(strWord, numBlockSize);
          printChars(numChars, LINE) ;
          strWord = "Feet";
          numBlockSize = 10;
          printCenterJustifiedString(strWord, numBlockSize);
          printChars(numChars, LINE) ;
          strWord = "Inches";
          numBlockSize = 12;
          printCenterJustifiedString(strWord, numBlockSize);
          printChars(numChars, LINE) ;
          printEndLine();
          
          //Line 3
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 25;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ; 
          numChars = 10;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 12;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          printEndLine();

          //Line 4
          printChars(numChars, LINE) ;
          strWord = "Height";
          numBlockSize = 25;
          printLeftJustifiedString(strWord, numBlockSize);
          printChars(numChars, EQUAL) ;
          numBlockSize = 10;
          numPer = 1;
          printRightJustifiedDouble(numHeightFeet, numPer, numBlockSize);
          printChars(numChars, LINE) ;
          numBlockSize = 12;
          printRightJustifiedDouble(numHeightInch, numPer, numBlockSize);
          printChars(numChars, LINE) ;
          printEndLine();
          
          //line 5
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 25;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ; 
          numChars = 10;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 12;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          printEndLine();
          
          //line 6
          printChars(numChars, LINE);
          strWord = "Height in Centimeters";
          numBlockSize = 25;
          printLeftJustifiedString(strWord, numBlockSize);
          printChars(numChars, EQUAL) ;
          numBlockSize = 10;
          numPer = 2;
          printRightJustifiedDouble(outputHeightCenti, numPer, numBlockSize);
          printChars(numChars, LINE) ;
          printEndLine();
          
          //line 7
          numChars = 1;
          printChars(numChars, LINE) ;
          numChars = 25;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ; 
          numChars = 10;
          printChars(numChars, DASH) ;
          numChars = 1;
          printChars(numChars, LINE) ;
          printEndLine();


         }

// Supporting Methods - DO NOT MAKE ANY CHANGES TO THESE METHODS ///////////////

    public static void printEndLine()
       {
        System.out.print( ENDLINE_CHAR );
       }
          
    public static void printChars( int numChars, char outChar )
       {
        if( numChars > 0 )
           {
            printChars( numChars - 1, outChar );
                
            System.out.print( outChar );
           }
       }     
      
    public static void printCenterJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int preSpaces = blockSize / 2 - outString.length() / 2;
        int postSpaces = blockSize - preSpaces - outString.length();
        
        printChars( preSpaces, SPACE );
        System.out.print( outString );
        printChars( postSpaces, SPACE );
       }
    
    public static void printLeftJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int postSpaces = blockSize - outString.length();
        
        System.out.print( outString );
        printChars( postSpaces, SPACE );
       }

    public static void printRightJustifiedString( String outString, 
                                                                 int blockSize )
       {
        int preSpaces = blockSize - outString.length();
        
        printChars( preSpaces, SPACE );
        System.out.print( outString );
       }

    public static void printCenterJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );

        printCenterJustifiedString( outStr, blockSize );
       }

    public static void printLeftJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );

        printLeftJustifiedString( outStr, blockSize );
       }

    public static void printRightJustifiedDouble( double outVal, 
                                                  int precision, int blockSize )
       {
        String outStr = setPrecision( outVal, precision );
        
        printRightJustifiedString( outStr, blockSize );
       }
     
    public static String setPrecision( double outVal, int precision )
       {
        int tempPrecision = precision + 1;
        int wkgIntVal, outValInt = (int)outVal;
        double outValFraction = Math.abs( outVal - outValInt );
        String outValStr = "";
        
        while( tempPrecision > 1 )
           {
            outValFraction *= 10;
            
            wkgIntVal = (int)outValFraction;
            
            outValStr += wkgIntVal;
            
            outValFraction -= wkgIntVal;
            
            tempPrecision--;
           }

        outValFraction *= 100;
        
        if( outValFraction > 45 )
           {
            wkgIntVal = Integer.parseInt( outValStr ) + 1;
            
            outValStr = Integer.toString( wkgIntVal );
           }
        
        outValStr = Integer.toString( outValInt ) + "." + outValStr;
        
        return outValStr;
       }


   }
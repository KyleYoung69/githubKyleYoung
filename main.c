/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    
    int array[8] = {1,4,7,3,2,9,12,5};
    int loop;
    
    int numberOfElements = sizeof(array);
    for (loop = 0; loop < numberOfElements; loop++)
        printf("%d",array[loop]);
        printf(" ")
    int maximum = max(array[], numberOfElements);
    int minimum = min(array[], numberOfElements);
    int average = avrg(array[], numberOfElements);
    int median = med(array[], numberOfElements);
    printf("%d", max);
    printf("%d", min);
    printf("%d", average);
    printf("%d", median)
    
    
    return 0;
}
int max(int array[], int size)
{
   int max = 0;
    for (loop = 0; loop < size; loop++)
        if (array[loop] > max)
            max = array[loop]; 
            
    return max;
}
int min(int array[], int size)
{
    int min = 500;
    for(loop = 0; loop < size; loop++)
        if(array[loop] > min)
            min = array[loop];
    return min;
    
}
int avrg(int array[], int size)
{  
    int mean = 0;
     for(loop = 0: loop < 8; loop++)
        mean = mean + array[loop];
    int average = (mean / size);
    return average:
}
double Med(int array[], int size) 
{ 
    // First we sort the array 
    sort(array, array+size); 
  
    // check for even case 
    if (n % 2 != 0) 
       return (double)array[size/2]; 
      
    return (double)(array[(size-1)/2] + array[size/2])/2.0; 
} 



import java.util.Arrays;

public class MergeSort {

  /**
   * Method that merges two sorted halves of a subarray (from Weiss,
   * Data Structures and Algorithm Analysis in Java)
   * 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param leftPos
   *          the left-most index of the subarray.
   * @param rightPos
   *          the index of the start of the second half.
   * @param rightEnd
   *          the right-most index of the subarray.
   */
  private static void merge(Integer[] a, Integer[] tmp, int leftPos, int rightPos, int rightEnd) {

        int aCtr = leftPos;
        int bCtr = rightPos; 
        int cCtr = leftPos; 

        while (aCtr < rightPos && bCtr <= rightEnd) {
            
            if (a[aCtr] <= a[bCtr]) 
                tmp[cCtr++] = a[aCtr++];
            else 
                tmp[cCtr++] = a[bCtr++];
        }
        
        if (aCtr >= rightPos )  // copy remaining elements in right partion 
            while (bCtr <= rightEnd) 
                tmp[cCtr++] = a[bCtr++];

        if (bCtr > rightEnd ) // copy remaining elements in left partion
            while (aCtr < rightPos) 
                tmp[cCtr++] = a[aCtr++]; 
            
        for (int i=leftPos; i<=rightEnd; i++) {
            a[i] = tmp[i];
        }

  }

 
  /* 
   * @param a
   *          an array of Comparable items.
   * @param tmpArray
   *          an array to place the merged result.
   * @param left
   *          the left-most index of the subarray.
   * @param right
   *          the right-most index of the subarray.
   */
  private static void mergeSort(Integer[] inputArray) {
       
      int subsize = 2;
	  int n = inputArray.length;
	  
	  if (n<2)
		  return;
	  // create a pointer that works from back to front
	  int pointer = n;
	  int index;
       
	  // at first form group of two and sort; igonre the last 1 element
	  while( (pointer - subsize) >= 0) {
		  index = n - pointer;
		  
		  if (inputArray[index+1] < inputArray[index]) {
			  // swap
			  int temp = inputArray[index+1];
			  inputArray[index+1] = inputArray[index];
			  inputArray[index] = temp;
		  }
		  pointer -= 2;
	  }
	  
	  // to merge  
	  int currentsize = 2;
	  Integer[] temp;
	  // while loop until current size is the half length of the input_array
	  // in each while loop round merge a certain size
	  while(currentsize <= n/2) {
		  int p = 0;
		  
		  while(n-p >= currentsize*2) {
			  temp = new Integer[n];			  
			  merge(inputArray, temp, p, p+currentsize, p+2*currentsize-1);
			  
			  for(int i = 0; i<currentsize*2;i++) 
				  inputArray[p+i] = temp[p+i];		  
			  p += currentsize*2;
  
		  }  	  
		  int last = n-p;
		  if (last>currentsize) {
			  temp = new Integer[n];
			  merge(inputArray, temp, p, p+currentsize, p+last-1);
			  for(int i =0; i<last;i++)
				  inputArray[p+i] = temp[p+i];
		  }		  
		  currentsize *= 2;	  
	  }
	  temp = new Integer[n];
	  merge(inputArray, temp, 0, currentsize,n-1);
	  inputArray = temp;

        return; 
  }

  public static void main(String[] args) {
    Integer[] a = {1,9,2,4,7,8,4,5,0};
    System.out.println(Arrays.toString(a)); 
    MergeSort.mergeSort(a);
    System.out.println(Arrays.toString(a)); 
    
    
  }
}

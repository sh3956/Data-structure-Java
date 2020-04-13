public class GenericMethods {
 /**
  *   This is a method to find the index of the smallest element in O(n)
  *   @param arr is the list in which we want to find the minimum
  *   @return the index of the minimum in arr
  */
  public static <T extends Comparable<T>> int findMin(T[] arr) {
    
    int minIndex = 0;
    for (int i = 0; i <= arr.length-1; i++) {
      if (arr[i].compareTo(arr[minIndex]) < 0) {
        minIndex = i;
      }
    }
    return minIndex; 
  }

  // This is a method to call min_index and print the index of the minimum value
  public static <T extends Comparable<T>> int findMinRecursive(T[] arr) {

    int i = arr.length;  
    return min_index(arr, arr.length-1, i); 
  }
  
   /**
	  *   This is a method to find the index of the smallest element in O(n) with recursive approach
	  * 
	  *   min_i = argmin(arr[min_i-1] , arr[i])
	  *   @param arr is the list in which we want to find the minimum
	  *   @param thMin_Index indicates the program is computing the nth minimum (will change through iteration)
	  *   @param i indicates the program is comparing the n-1th minimum with nth element (will change through iteration)
	  *   @return the index of the minimum in arr
	  */
  private static <T extends Comparable<T>> int min_index(T[] arr, int thMin_Index, int i){  
    // base case        
    if (thMin_Index == 0) {
      return 0;      
      } else if (arr[min_index(arr, thMin_Index-1, i-1)].compareTo(arr[i-1]) > 0) {
        // recursive
          return i - 1;          
        } else {
          return min_index(arr, thMin_Index-1, i-1);
        }
  }
  
  public static <T extends Comparable<T>> int binarySearch(T[] arr, T x) {
    
    int left = 0;
    int right = arr.length - 1;
    int mid;

    return binary_FindMin(arr, x, left, right);
    }
  
  /**
  *   This is a method to find the target element in O(logn) by Binary Search
  *   @param arr is the list in which we want to find the minimum
  *   @param x is the target
  *   @param left is the index of the most left element we are interested in 
  *   @param right is the index of the most right element we are interested in
  *   @return the index of the target in arr
  */ 
  
  private static <T extends Comparable<T>> int binary_FindMin(T[] arr, T x, int left, int right){
      // assume the array has already sorted from small to big
      if (right < left) {
        return -1;
      }
      int mid = (left + right) / 2;
      
      if (arr[mid].compareTo(x) == 0) {
        return mid;
      }
      if (arr[mid].compareTo(x) > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
      return binary_FindMin(arr, x, left, right);
    }
    
}













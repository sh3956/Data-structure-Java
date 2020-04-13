import shapes.*; 
import java.util.Arrays;


public class TestGenericMethods {

  public static void testBinarySearch(Shape[] testArr, Shape x, int target) {    
    int binSearchTest = GenericMethods.binarySearch(testArr, x);      
    
    System.out.print("GenericMethods.binarySearch for "+x.toString()+" returned index " +Integer.toString(binSearchTest)+": ");

    if (binSearchTest!=-1)
      System.out.print(testArr[binSearchTest].toString());
                     
    if (binSearchTest == target) {      
      System.out.println(" "+(char)27 + "[32mOK");
    } else {                       
      System.err.println("\n"+(char)27 + "[31mWas expecting: "+testArr[target].toString());
    }
    System.out.println((char)27+"[0m\n");
  }
    
  public static void main(String[] args) {
    
    Shape[] testArr = new Shape[6];
    testArr[0] = new Circle(3);
    testArr[1] = new Rectangle(2, 8);
    testArr[2] = new Circle(4);
    testArr[3] = new Rectangle(8, 2);
    testArr[4] = new Square(5);   
    testArr[5] = new Square(4);
   
    // test findMin
    int minTest = GenericMethods.findMin(testArr);
    int target = 1;
    if (minTest == -1) {
      System.err.println((char)27 + "[31mGenericMethods.findMin returned -1. Probably not yet implemented.");
    } else if (minTest!=target) { 
      System.err.println("GenericMethods.findMin returned index "+Integer.toString(minTest)+": "+testArr[minTest].toString()+" ");
      System.err.println((char)27 + "[31mWas expecting index "+Integer.toString(target)+": "+testArr[target].toString());
    } else {
      System.out.print("GenericMethods.findMin returned index "+Integer.toString(minTest)+": "+testArr[minTest].toString());
      System.out.println((char)27 + "[32m OK");
    }
    System.out.println((char)27+"[0m\n");
    
    // test findMinRecursive
    minTest = GenericMethods.findMinRecursive(testArr);
    target = 1;
    if (minTest == -1) {
      System.err.println((char)27 + "[31mGenericMethods.findMinRecursive returned -1. Probably not yet implemented.");
    } else if (minTest!=target) { 
      System.err.println("GenericMethods.findMinRecursive returned index "+Integer.toString(minTest)+": "+testArr[minTest].toString()+" ");
      System.err.println((char)27 + "[31mWas expecting index "+Integer.toString(target)+": "+testArr[target].toString());
    } else {
      System.out.print("GenericMethods.findMinRecursive returned index "+Integer.toString(minTest)+": "+testArr[minTest].toString());
      System.out.println((char)27 + "[32m OK");
    }
    System.out.println((char)27+"[0m\n");
        
    // test binarySearchGeneric   
    Arrays.sort(testArr); // sort the array
    testBinarySearch(testArr, new Circle(4), 5);
    testBinarySearch(testArr, new Rectangle(5,5), 3);
    
  }
  
}
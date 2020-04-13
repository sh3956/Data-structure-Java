# Homework 1 Programming  (60 pts)

Please remember that to submit the assignment you must click Mark as Complete under the Education menu in the toolbar.

Please make sure to look at the written portion of this assignment, which is available on Courseworks. 


## Problem 1 - Generic Methods, Comparable, and Recursion - 20 points

Take a look at the file `GenericMethods.java`.

There are three methods you must implement:

* `public static <T extends Comparable<T>> int findMin(T[] arr)`: Iterate through the array to find the index of the smallest element in the array. If there are two elements with the smallest value, the method should return the index of the first one. The method should run in O(n).
* `public static <T extends Comparable<T>> int findMinRecursive(T[] arr)`: Should behave just like `findMin`, but should be implemented **recursively**. Your method may not contain any while or for loops. Hint: the public `findMinRecursive` method should not, itself, be recursive. Instead, write an additional private helper method with additional parameters. This private helper method should be called from `findMinRecursive`. This must run in O(n) time. 
* `public static <T extends Comparable<T>> int binarySearch(T[] arr, T x)`: Implement a **recursive** binary search to find a value equal to `x`. Hint: The public `binarySearch` method, itself, should not be recursive. Instead, write an additional private helper method with additional parameters. This private helper method should be called from the public `binarySearch` method. This must run in O(log n) time. If the value is not found in the array, return -1. Else, return the index in the array where the value was found.

To test your code, you may compile and run `GenericMethodTester.java`. This tester class uses the types defined in the package `shapes`, which includes an interface `Shape` and concrete classes `Rectangle`, `Square`, and `Circle`. The `Shape` interface extends the `Comparable` interface, which means that the concrete classes all need to have a compareTo method. In this case, the differnt shapes are compared according to their **area**. Take a look at the code for these classes to make sure you understand how everything works. There is nothing you need to change in this package -- it's only here to test the GenericMethods. 
 
## Problem 2 - Range Iterable - 20 points

In Java, we typically iterate over a sequence of integers as follows:

```
for (int i=0; i<10; i = i + 2) {
  ...
}
```
i.e you define the initializer int i=0, termination condition i<10, and update i = i+2. 

Suppose we use a version of Java that only supports for-each loops, i.e. it only allows you to iterate through the elements of an `Iterable` (N.B.: in Python, all for-loops are for-each loops). 
In order to still be able to iterate over a sequence of numbers, you need to create such an `Iterable`, which we will call Range.

Modify the class `Range.java` so that it can be used as illustrated in `TestRange.java`.

```
            for(Integer j : new Range(1,8,1)) {
             System.out.print(j);
            }
            // Prints the sequence 1 2 3 4 5 6 7

            for(Integer j : new Range(1,8,2)) {
             System.out.print(j);
            }
            // Prints the sequence 1 3 5 7         

            for(Integer j : new Range(8,0,-1)) {
             System.out.print(j);
            }
            // Prints the sequence 8 7 6 5 4 3 2 1
```


The arguments passed to the constructor of Range are `new Range(int start, int stop, int step)`.
  * *start* - the first integer produced
  * *stop* - iteration stops before stop is reached
  * *step* - the increment each time around the loop. Note that the step can be negative, as illustrated in the third example. 

To implement Range, use an inner class for the Iterator that is returned by the iterator() method. The Iterator does not need to support the remove() operation.

## Problem 3 - Reversing a Linked List - 20 points 
The file `LinkedList.java` contains a doubly linked list, essentially identical to the implementation discussed in class.

Your task is to fill in the method `void reverse()`, which should reverse the linked list. The method should modify the list data structure by changing the `next` and `prev` references in the linked list nodes. 
Do not change anything else in the class. 

You can test your method by running the main method of SimpleLinkedList, which should print out a list in the original, and then in reversed order.
    
At the beginning of your void reverse() method insert a comment, answering the following question: What is the run-time of your reverse method as a function of the length of the list? Describe a different way to make reversal of the list a constant-time, i.e. O(1) operation, if you could change **anything** in the class (this is a bit of a trick question).
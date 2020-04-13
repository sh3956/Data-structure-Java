public class TestRange {

  public static void main(String[] args) {
    
    System.out.println("Range(1,8,1) should print 1 2 3 4 5 6 7");
    for(Integer j : new Range(1,8,1)) {
      System.out.print(j);
      System.out.print(" ");
    }
    System.out.println("\n");

    System.out.println("Range(1,8,2) should print 1 3 5 7");
    for(Integer j : new Range(1,8,2)) {
       System.out.print(j);
       System.out.print(" ");
    }
    System.out.println("\n");

    System.out.println("Range(8,0,-1) should print 8 7 6 5 4 3 2 1");
    for(Integer j : new Range(8,0,-1)) {
       System.out.print(j);
       System.out.print(" ");
    }
    System.out.println("\n");
  }
  
}
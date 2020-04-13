import java.util.Iterator; 

/**
 *  A Range iterable that can be used to iterate over a sequence of integers
 *  (similar to Python's range function).
 */
public class Range implements Iterable<Integer> {
  
  private class newIterator implements Iterator<Integer>{
    private int current = 0;
    
    public newIterator() {
        current = start - step;
        }
    
    // if step > 0 then follow from left to right (small to big)
    // if step < 0 then follow from right to left (big to small)
    public boolean hasNext() {
      if(step > 0) {
        return current < stop - 1;
      } else {
        return current > stop + 1;
      }
    }        
    // the next object of current is current value + step size
    public Integer next() {
        if(!hasNext()){
          return -1;        
        } 
        current = current + step;
        return current;                   
    }
    
    public void remove() {
        throw new UnsupportedOperationException("Can't remove values from a Range");
    }
    
  }
  
  private int start;
  private int stop;
  private int step;
  
  public Range(int start, int stop, int step) {
      this.start = start;
      this.stop = stop;
      this.step = step;
  }

  public Iterator<Integer> iterator() {
    return new newIterator();   
  }
  
}


import java.util.NoSuchElementException;
public class TwoStackQueue<T> implements Queue<T> {

    private ArrayStack<T> s1;
    private ArrayStack<T> s2;
    
    public TwoStackQueue() {
        s1 = new ArrayStack<T>();
        s2 = new ArrayStack<T>();
    }
    
    public void enqueue(T x) {
        s1.push(x);
    }
    
    public T dequeue() throws NoSuchElementException {
        // while s2(the out stack) is not empty, keep poping
        if(!s2.isEmpty())
            return s2.pop();
        // is both s1 and s2 are empty, we can not dequeue anything
        else if (isEmpty())
            throw new NoSuchElementException("There is no elements to dequeue."); 
        // add all s1 elements to s2 
        else
            while(!s1.isEmpty())
                s2.push(s1.pop());      
            return s2.pop();
    }
    
    // this method is used to check whether this "TwoStackQueue" is empty(whether can dequeue or not)
    public boolean isEmpty() {
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        else 
            return false;
        
    }
    
}
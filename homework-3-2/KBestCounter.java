import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    List<T> result;
    int k;

    public KBestCounter(int k) {
        heap = new PriorityQueue<T>(k);
        this.k = k;
    }

    public void count(T x) {
        if (heap.size() < k) {
            heap.add(x);
        }
        else if (heap.peek().compareTo(x) < 0){
            heap.remove();
            heap.add(x);
        }
    }

    public List<T> kbest() {
  
        PriorityQueue<T> heap_2 = new PriorityQueue<T>(k); 
        Iterator<T> ite = heap.iterator();
        
        while(ite.hasNext()){
            heap_2.add(ite.next());
        }
        
        List<T> result = new ArrayList<>();
 
        while(heap_2.size()>0){
            result.add(heap_2.remove());
        }
        return result;
    }
    
}
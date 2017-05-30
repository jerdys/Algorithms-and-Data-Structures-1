package LinkedList;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 31.05.17
 */
public class Entry<T> {
    private Entry<T> nextEntry;
    private T data;


    public Entry(Entry<T> nextEntry, T data){
        this.nextEntry = nextEntry;
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Entry<T> getNext() {
        return nextEntry;
    }

    public void setNext(Entry<T> entry){
        this.nextEntry = entry;
    }
}

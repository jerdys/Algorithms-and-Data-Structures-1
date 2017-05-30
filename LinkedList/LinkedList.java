package LinkedList;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 30.05.17
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> {
    private int size;
    private Entry<T> head;

    public LinkedList (){
        head = new Entry<T>(null, null);
        this.size = 0;
    }

    public void add(T ob) {
        if(ob != null) {
            Entry<T> entry = head;
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }
            if (entry.getData() == null)
            {
                entry.setData(ob);
            } else {
                entry.setNext(new Entry<T>(null, ob));
            }
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    public void addAfter(T ob, T targetOb){
        if (ob != null && targetOb != null) {
            Entry<T> entry = head;
            while (entry.getNext() != null) {
                if (entry.getData().equals(targetOb)) {
                    entry.setNext(new Entry<T>(entry.getNext(),ob));
                    break;
                }
                entry = entry.getNext();
                size++;
            }
        }
    }

    public void remove(T ob){
        if(ob != null) {
            Entry<T> entry = head;
            while (entry.getNext().getData() != ob) {
                entry = entry.getNext();
            }
            Entry<T> entry1 = entry;
            entry = entry.getNext();
            entry1.setNext(entry.getNext());
            size--;
        }
    }

    public void merge(LinkedList<T> linkedList){
        if(head != null) {
            Entry<T> entry = head;
            while (entry.getNext() != null) {
                entry = entry.getNext();
            }
            entry.setNext(linkedList.head);
            size += linkedList.size;
        } else {
            head = linkedList.head;
        }
    }

    public int get(T ob){
        int i = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(ob)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean has(T ob){
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(ob)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Iterator<T> iterator(){
        return new Itr<T>();
    }

    private class Itr<T> implements Iterator<T>{

        private Entry<T> entry;

        private Itr() {
            entry = new Entry<T>((Entry<T>)head, null);
        }

        @Override
        public boolean hasNext() {
            return entry.getNext() != null && entry.getNext().getData() != null;
        }

        @Override
        public T next() {
            if(hasNext()) {
                entry = entry.getNext();
                return entry.getData();
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}
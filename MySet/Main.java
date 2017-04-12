package MySet;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by jerdys on 12.04.17.
 */

public class Main {
    public static void main(String[] args) {
        MySet<String> mySet = new MySet<String>();

        mySet.add("This");
        mySet.add("Is");
        mySet.add("Matt");
        mySet.add("Matt");
        mySet.add("World");

        System.out.println("Size: " + mySet.size());
        System.out.println("IsEmpty: " + mySet.isEmpty());
        System.out.println("Contains: " + mySet.contains("Test"));
        System.out.println("ToArray: " + Arrays.toString(mySet.toArray()));
        System.out.println("ToArray: " + Arrays.toString(mySet.toArray(new String[] {"Test", "Hello"})));

        LinkedList<String> linkedList1 = new LinkedList<>();
        LinkedList<String> linkedList2 = new LinkedList<>();

        linkedList1.add("Test");
        linkedList1.add("World");
        linkedList2.add("Kirill");
        linkedList2.add("World");
        
        System.out.println("ContainsAll 1: " + mySet.containsAll(linkedList1));
        System.out.println("ContainsAll 2: " + mySet.containsAll(linkedList2));

        for (String title : mySet) {
            System.out.println("Iterator: " + title);
        }

        System.out.println(mySet.toString());
    }
}

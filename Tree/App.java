package Tree;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 24.05.17
 */

public class App {
    public static void main(String[] args) {
        Tree<String> stringTree = new Tree();
        stringTree.add(null, "A");
        stringTree.add("A", "B");
        stringTree.add("A", "C");
        stringTree.add("A", "G");
        stringTree.add("A", "H");
        stringTree.add("C", "D");
        stringTree.add("C", "E");
        stringTree.add("C", "F");
        stringTree.add("H", "I");
        stringTree.add("H", "L");
        stringTree.add("I", "J");
        stringTree.add("I", "K");
        stringTree.circumvention(stringTree.getRoot());
        //stringTree.bypassWidth();
    }
}

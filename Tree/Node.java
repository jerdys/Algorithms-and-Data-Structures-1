package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 24.05.17
 */

public class Node<T> {
    private T data;
    private List<Node<T>> childrens;

    public Node(T data) {
        this.data = data;
        childrens = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getChildrens() {
        return childrens;
    }

    public void addChildren(Node<T> children) {
        childrens.add(children);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public boolean hasChildren() {
        return childrens.size() != 0;
    }
}

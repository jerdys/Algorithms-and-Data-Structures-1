package StackAndQueue;

public class Stack implements Sequence {
    private int length;
    private Object[] array;

    public Stack() {
        length = 0;
        array = new Object[length];
    }

    @Override
    public void push(Object obj) {
        Object[] newArr = new Object[length + 1];
        System.arraycopy(array, 0, newArr, 0, length);
        array = newArr;
        array[length] = obj;

        length++;
    }

    @Override
    public Object pop() {
        length--;
        Object obj = array[length];

        Object[] newArr = new Object[length];
        System.arraycopy(array, 0, newArr, 0, length);
        return obj;
    }

    @Override
    public int size() {
        return length;
    }
}
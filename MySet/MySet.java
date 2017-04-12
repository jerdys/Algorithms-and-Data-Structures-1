package MySet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jerdys on 12.04.17.
 */

public class MySet<T> implements Set<T> {
    T[] objects;

    public MySet() {
        objects = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public boolean isEmpty() {
        if (objects.length == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException();

        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    @Override
    public Object[] toArray() {
        return objects;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException();
        }

        T1[] detectedObjects = (T1[]) new Object[0];

        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (objects[i].equals(a[j])) {
                    T1[] newObjects = (T1[]) new Object[detectedObjects.length + 1];
                    System.arraycopy(detectedObjects, 0, newObjects, 0, detectedObjects.length);
                    newObjects[newObjects.length - 1] = (T1) objects[i];
                    detectedObjects = newObjects;
                }
            }
        }

        return detectedObjects;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) return false;
        T[] newObjects = (T[]) new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = t;
        objects = newObjects;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) throw new NullPointerException();
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() == 0) {
            throw new NullPointerException();
        }

        int count = 0, size = c.size();
        Iterator<?> collectionIterator = c.iterator();

        while (collectionIterator.hasNext()) {
            T object = (T) collectionIterator.next();

            for (int i = 0; i < objects.length; i++) {
                if (objects[i].equals(object)) {
                    count++;
                }
            }
        }

        return count == size;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0) {
            throw new NullPointerException();
        }

        T[] newObjects = (T[]) new Object[objects.length + c.size()];
        T[] objectsCollection = (T[]) c.toArray();

        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        System.arraycopy(objectsCollection, 0, newObjects, objects.length, objectsCollection.length);
        objects = newObjects;
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) {
            throw new NullPointerException();
        }

        boolean modified = false;

        for (T object : this) {
            if (!c.contains(object)) {
                remove(object);
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            throw new NullPointerException();
        }

        boolean modified = false;

        for (T object : this) {
            if (c.contains(object)) {
                modified = true;
                remove(object);
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        T[] newObjects = (T[]) new Object[0];
        objects = newObjects;
    }

    private class MySetIterator implements Iterator<T> {
        int position;

        public MySetIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < objects.length;
        }

        @Override
        public T next() {
            T object = objects[position];
            position++;
            return object;
        }

        @Override
        public void remove() {
            @SuppressWarnings("unchecked")
            T[] newOBjects = (T[]) new Object[objects.length - 1];
            System.arraycopy(objects, 0, newOBjects, 0, position);
            System.arraycopy(objects, position + 1, newOBjects, position, newOBjects.length - 1);
            objects = newOBjects;
        }
    }
}

package Map;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Data-Structures-and-Algorithms-1
 * Created by @author jerdys on 13.05.17
 */

public class Map {
    private static final int N = 10;
    private String[] keyArray;
    private Object[] ObjectArray;

    public Map() {
        keyArray = new String[N];
        ObjectArray = new Object[N];
    }

    public void add(String key, Object value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i].equals(key)) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray.length - i < 5) {
                String[] keys = new String[keyArray.length];
                Object[] Objects = new Object[ObjectArray.length];

                for (int j = 0; j < keyArray.length; j++) {
                    keys[i] = keyArray[i];
                    Objects[i] = ObjectArray[i];
                }

                keyArray = keys;
                ObjectArray = Objects;
            }

            if (keyArray[i] == null) {
                keyArray[i] = key;
                ObjectArray[i] = value;
            }

        }
    }

    public Object remove(String key) {
        int q = -1;

        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i].equals(key)) {
                keyArray[i] = null;
                q = i;
            }
        }

        if (q != -1) {
            return ObjectArray[q];
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public Object get(String key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i].equals(key)) {
                return ObjectArray[i];
            }
        }

        throw new NoSuchElementException();
    }

    public void set(String key, Object object) {
        boolean clause = false;

        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i].equals(key)) {
                ObjectArray[i] = object;
                clause = true;

                break;
            }
        }
        if (!clause) {
            throw new NoSuchElementException();
        }
    }

    public void removeAll() {
        for (int i = 0; i < keyArray.length; i++) {
            keyArray[i] = null;
        }
    }


    public String[] getKeys() {
        String[] newKeyArray = new String[keyArray.length];
        newKeyArray = Arrays.copyOf(keyArray, keyArray.length);

        return newKeyArray;
    }

    public Object[] getValues() {
        Object[] newValueArray = new Object[keyArray.length];
        newValueArray = Arrays.copyOf(ObjectArray, keyArray.length);

        return newValueArray;
    }

    public int size() {
        int k = 0;

        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null) {
                k++;
            }
        }

        return k;
    }
}

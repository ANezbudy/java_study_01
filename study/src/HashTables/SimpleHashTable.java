package HashTables;

import java.util.ArrayList;

public class SimpleHashTable<T> {
    //    private ArrayList<MapEntry<T>> values;
    private final static int RANGE = 1000;
    private ArrayList<MapEntry<T>>[] values = new ArrayList[RANGE];

    private int getHash(int key) {
        return key % RANGE;
    }

    public void put(int key, T value) throws RuntimeException {
        MapEntry<T> entry = new MapEntry<T>();
        int hash = getHash(key);
        entry.setKey(hash);
        entry.setValue(value);

        if (values[hash] == null) {
            values[hash] = new ArrayList<MapEntry<T>>();
        }

        for (int j = 0; j < values[hash].size(); j++) {
            if (values[hash].get(j).getKey() == key) {
                throw new RuntimeException("This key already exists");
            }
        }

        values[hash].add(entry);
    }

    public T get(int key) {
        int hash = getHash(key);

        if (values[hash] == null) {
            return null;
        }

        for (int i = 0; i < values[hash].size(); i++) {
            if (values[hash].get(i).getKey() == key) {
                return values[hash].get(i).getValue();
            }
        }
        return null;
    }

    public boolean contains(int key) {
//        for (int i = 0; i < values.size(); i++) {
//            if (values.get(i).getKey() == key) {
//                return true;
//            }
//        }
        return false;
    }

    public boolean remove(int key) {
//        for (int i = 0; i < values.size(); i++) {
//            if (values.get(i).getKey() == key) {
//                values.remove(i);
//                return true;
//            }
//        }
        return false;
    }

    //TODO to make a test for this class

}

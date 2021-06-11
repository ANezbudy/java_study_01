package Hash;

import java.util.ArrayList;

public class NewOurHasTable<T> {

    private class Entity {
        OurString key;
        T value;

        public Entity(OurString key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int ARRAY_SIZE = 1000;

    ArrayList<Entity>[] arrayLists = new ArrayList[ARRAY_SIZE];

    public void put(String key, T value) {
        if (key == null) {
            throw new NullPointerException("key should not be null");
        }
        OurString ourString = new OurString(key);

        int index = Math.abs(ourString.getOurHashCode()) % ARRAY_SIZE;

        if (arrayLists[index] == null) {
            arrayLists [index] = new ArrayList<>();
        }

        for (int i = 0; i < arrayLists[index].size(); i++) {
           if(arrayLists[index].get(i).key.equals(ourString)) {
               arrayLists[index].remove(i);
               break;
           }
        }
        arrayLists[index].add(new Entity(ourString, value));
    }

    public T get(String key) {
        if (key == null) {
            throw new NullPointerException("key should not be null");
        }
        OurString ourString = new OurString(key);
        int index = Math.abs(ourString.getOurHashCode()) % ARRAY_SIZE;

        if (arrayLists[index] != null) {
            for (int i = 0; i < arrayLists[index].size(); i++) {
                if(arrayLists[index].get(i).key.equals(ourString)) {
                    return arrayLists[index].get(i).value;
                }
            }
        }

        return null;
    }

    public boolean remove(String key) {
        if (key == null) {
            throw new NullPointerException("key should not be null");
        }
        OurString ourString = new OurString(key);

        int index = Math.abs(ourString.getOurHashCode()) % ARRAY_SIZE;

        if (arrayLists[index] != null) {
            for (int i = 0; i < arrayLists[index].size(); i++) {
                if(arrayLists[index].get(i).key.equals(ourString)) {
                    arrayLists[index].remove(i);
                    return true;
                }
            }
        }
        return false;
    }

}

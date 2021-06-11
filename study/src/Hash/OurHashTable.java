package Hash;

import java.util.ArrayList;

public class OurHashTable {
    private static final int ARRAY_SIZE = 1000;

    ArrayList<OurString>[] arrayLists = new ArrayList[ARRAY_SIZE];

    public void put(OurString value) {
        for (int i = 0; i < arrayLists.length; i++) {
            if (arrayLists[i] == null) {
                ArrayList<OurString> arr = new ArrayList<>();
                arrayLists[i] = arr;
                arr.add(value);
                break;
            } else {
                if (arrayLists[i].get(0).getOurHashCode() == value.getOurHashCode()) {
                    arrayLists[i].add(value);
                    break;
                }
            }
        }
    }

    public OurString get(int hashKey) {
        for (int i = 0; i < arrayLists.length; i++) {
            if(arrayLists[i].size() != 0 && arrayLists[i] != null) {
                if(arrayLists[i].get(0).getOurHashCode() == hashKey) {
                    return arrayLists[i].get(0);
                }
            } else {
                return null;
            }
        }
        return null;
    }

    public int remove(int hashKey) {
        for (int i = 0; i < arrayLists.length; i++) {
            if(arrayLists[i].get(0).getOurHashCode() == hashKey) {
                arrayLists[i].remove(0);
                return 1;
            }
        }
        return -1;
    }

}

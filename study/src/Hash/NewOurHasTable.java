package Hash;

import java.util.ArrayList;

public class NewOurHasTable {
    private static final int ARRAY_SIZE = 1000;

    ArrayList<OurString>[] arrayLists = new ArrayList[ARRAY_SIZE];

    public void put(String string) {
        OurString ourString = new OurString(string);

        int index = ourString.getOurHashCode() % ARRAY_SIZE;

        if (arrayLists[index] == null) {
            arrayLists [index] = new ArrayList<>();
        }

        for (int i = 0; i < arrayLists[index].size(); i++) {
           if(arrayLists[index].get(i).getOurHashCode() == ourString.getOurHashCode() &&
                   arrayLists[index].get(i).equals(ourString)
           ) {
               arrayLists[index].remove(i);
               break;
           }
        }
        arrayLists[index].add(ourString);
    }





}

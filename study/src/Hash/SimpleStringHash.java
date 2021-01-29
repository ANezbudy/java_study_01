package Hash;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class SimpleStringHash {
    //only small english letters
    //count only 5 first symbols

    public static void main(String[] args) {
        OurString str1 = new OurString("where is a map billy");
        OurString str2 = new OurString("so where is a map billy");
        OurString str3 = new OurString("my name is");
        OurString str4 = new OurString("my name is");

        OurHashTable hashTable = new OurHashTable();

        hashTable.put(str1);
        hashTable.put(str2);
        hashTable.put(str3);
        hashTable.put(str4);

        System.out.println(str1.getOurHashCode());
        System.out.println(str2.getOurHashCode());
        System.out.println(str3.getOurHashCode());
        System.out.println(str4.getOurHashCode());

        System.out.println(hashTable.get(str1.getOurHashCode()).getValue());

        System.out.println(hashTable.remove(str3.getOurHashCode()));

        try{
            System.out.println(hashTable.get(str3.getOurHashCode()).getValue());
        } catch (NullPointerException e) {
            System.out.println("null");
        }


    }
}

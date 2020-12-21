package HashTables;

public class SimpleHashTableLauncher {
    public static void main(String[] args) {
        SimpleHashTable<String> hashTable = new SimpleHashTable();

        hashTable.put(20, "string");
        hashTable.put(1, "first");
        hashTable.put(2, "2");
        hashTable.put(20, "18");

        System.out.println(hashTable.get(20));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(18));
    }
}

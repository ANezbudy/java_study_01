package Hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewOurHasTableTest {

    @Test
    void put() {
        NewOurHasTable<String> newOurHasTable = new NewOurHasTable();

        String key = "dokole";
        String value = "kogda rak na gore svistnet";

        for (int i = 0; i < 1000; i++) {
            newOurHasTable.put(key + i, value + i);
            assertTrue(newOurHasTable.get(key + i).equals(value + i));
        }

        for (int i = 0; i < 1000; i++) {
            assertTrue(newOurHasTable.get(key + i).equals(value + i));
        }

        assertTrue(newOurHasTable.get(key) == null);
    }

    @Test
    void get() {

    }

    @Test
    void remove() {
        //TODO
    }
}
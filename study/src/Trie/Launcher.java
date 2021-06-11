package Trie;

public class Launcher {
    public static void main(String [] args) {
        TrieElement trieEl = new TrieElement();

        trieEl.addWord("String");
        trieEl.addWord("Sting");
        trieEl.addWord("alien");
        trieEl.addWord("artur");
        trieEl.addWord("Sling");
        trieEl.addWord("alienate");
//        Screen.drawTree(trieEl);
        System.out.println("End");
        System.out.println(trieEl.searchWord("alien"));
    }
}

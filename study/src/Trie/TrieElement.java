package Trie;

import java.util.HashMap;

public class TrieElement {
//    private char value;
    boolean endOfWord;


    private class BoolConteiner {
        public boolean isIndented() {
            return indented;
        }

        private boolean indented;

        public void setIndented(boolean b) {
            indented = b;
        }
    }



    HashMap<Character, TrieElement> children = new HashMap<>();


    public void addWord(String word) {
        if (word == null) {
            endOfWord = true;
            return;
        }

        char firstChar = word.charAt(0);

        TrieElement child = children.get(firstChar);

        if (child == null) {
            child = new TrieElement();
            children.put(firstChar, child);
        }

        if (word.length() == 1) {
            child.addWord(null);
        } else {
            child.addWord(word.substring(1));
        }

    }

    public boolean searchWord(String word) {
        if (word == null) {
//            container.setIndented(true);
            return endOfWord;
        }

        char firstChar = word.charAt(0);

        TrieElement child = children.get(firstChar);

        if (child == null) {
//            container.setIndented(false);
            return false;
        }

        if (word.length() == 1) {
            return child.searchWord(null);
        } else {
            return child.searchWord(word.substring(1));
        }

    }


}

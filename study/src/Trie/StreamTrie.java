package Trie;

public class StreamTrie {

    private TrieElement currentNode;
    private StringBuffer currentWord;
    private TrieElement root;

    enum State {
        WAITING_FOR_SYMBOL,
        EATING_DOWN_REST_OF_WORD,
        CLEAR_SPECIAL_SYMBOLS
    }

    State currentState = State.WAITING_FOR_SYMBOL;


    /* possible scenarios:
        1. The end of word ina the text and the word finished in dictionary (endOfWord flag) - the word is found and
            we print it in console
        2. На вход пришла буква, которой нет в соответствующей ноде в трие - выводим, что такого слова в словаре нет.
            При этом, продолжаем принимать на вход буквы, никак на них не реагирую, пока не придет пробел, точка или
            запятая
        3. Получили на вход конец слова (пробел, точка, запятая), но флаг endOfWord не найден - значит, слово не найдено

       Final State Machine - есть такое понятие в программировании

     */
    public StreamTrie(TrieElement root) {
        this.root = root;
        reset();

    }

    // function retears the node to root and resets the current word
    private void reset() {
        currentNode = root;
        currentWord = new StringBuffer();
        currentState = State.CLEAR_SPECIAL_SYMBOLS;
    }

    private Boolean isEndOfWord(Character inputSymbol) {
        return inputSymbol.equals(' ') ||
                inputSymbol.equals(',') ||
                inputSymbol.equals('.');
    }

    public void handleSymbol(Character inputSymbol) {
        switch (currentState) {
            case CLEAR_SPECIAL_SYMBOLS:
                if(isEndOfWord(inputSymbol)) {
                    break;
                } else {
                    currentState = State.WAITING_FOR_SYMBOL;
                }
            case WAITING_FOR_SYMBOL:
                if (isEndOfWord(inputSymbol)) {
//                    if (currentNode == root) {
//                        break;
//                    } else
                    if (currentNode.endOfWord) {
                        System.out.println("The word " + currentWord.toString() + " is found");
                    } else {
                        System.out.println("The word " + currentWord.toString() + " is not found");
                    }
                    reset();
                } else {
                    currentWord.append(inputSymbol);
                    if (currentNode.children.containsKey(inputSymbol)) {
                        currentNode = currentNode.children.get(inputSymbol);
                    } else {
                        currentState = State.EATING_DOWN_REST_OF_WORD;
                    }
                }
                break;

            case EATING_DOWN_REST_OF_WORD:
                if (isEndOfWord(inputSymbol)) {
                    System.out.println("The word " + currentWord.toString() + " is not found");
                    reset();
                } else {
                    currentWord.append(inputSymbol);
                    // do nothing. Just skip because eating the word
                }
                break;

            default:
                throw new RuntimeException("Unexpected state: " + currentState);
        }
    }
}

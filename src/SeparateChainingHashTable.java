public class SeparateChainingHashTable {

    int dictionaryWords = 50000;
    Node[] hashTable;
    private int alphabetCharacters = 27;

    SeparateChainingHashTable() {
        hashTable = new Node[dictionaryWords];
    }

    int hash(String word) {
        return convertToNumbers(word) % dictionaryWords;
    }

    void insert(String word, String meaning) {
        Node wordN = new Node(word, meaning);

        int hashedKey = hash(word);
        if(hashTable[hashedKey] == null)
            hashTable[hashedKey] = wordN;
        else {
            Node current = hashTable[hashedKey];
            Node prev = current;
            while(current != null){
                prev = current;
                if(current.word.equals(word)) {
                    current.meaning = meaning;
                    break;
                }
                current = current.next;
            }
            if(current == null)
                prev.next = wordN;
        }
    }

    String find(String word) {
        int hashedKey = hash(word);
        Node current = hashTable[hashedKey];
        while (current != null && !current.word.equals(word)) {
            current = current.next;
        }

        if(current != null)
            return current.meaning;
        return null;
    }

    void remove(String word) {
        int hashedKey = hash(word);
        Node current = hashTable[hashedKey];
        Node prev = current;
        while (current != null && !current.word.equals(word)) {
            prev = current;
            current = current.next;
        }

        if(current != null) {
            prev.next = current.next;
        }
    }

    int convertToNumbers(String word) {
        String[] splittedWord = word.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: splittedWord) {
            switch (s) {
                case "a":
                    stringBuilder.append("1");
                    stringBuilder.append(" ");
                    break;
                case "b":
                    stringBuilder.append("2");
                    stringBuilder.append(" ");
                    break;
                case "c":
                    stringBuilder.append("3");
                    stringBuilder.append(" ");
                    break;
                case "d":
                    stringBuilder.append("4");
                    stringBuilder.append(" ");
                    break;
                case "e":
                    stringBuilder.append("5");
                    stringBuilder.append(" ");
                    break;
                case "f":
                    stringBuilder.append("6");
                    stringBuilder.append(" ");
                    break;
                case "g":
                    stringBuilder.append("7");
                    stringBuilder.append(" ");
                    break;
                case "h":
                    stringBuilder.append("8");
                    stringBuilder.append(" ");
                    break;
                case "i":
                    stringBuilder.append("9");
                    stringBuilder.append(" ");
                    break;
                case "j":
                    stringBuilder.append("10");
                    stringBuilder.append(" ");
                    break;
                case "k":
                    stringBuilder.append("11");
                    stringBuilder.append(" ");
                    break;
                case "l":
                    stringBuilder.append("12");
                    stringBuilder.append(" ");
                    break;
                case "m":
                    stringBuilder.append("13");
                    stringBuilder.append(" ");
                    break;
                case "n":
                    stringBuilder.append("14");
                    stringBuilder.append(" ");
                    break;
                case "o":
                    stringBuilder.append("15");
                    stringBuilder.append(" ");
                    break;
                case "p":
                    stringBuilder.append("16");
                    stringBuilder.append(" ");
                    break;
                case "q":
                    stringBuilder.append("17");
                    stringBuilder.append(" ");
                    break;
                case "r":
                    stringBuilder.append("18");
                    stringBuilder.append(" ");
                    break;
                case "s":
                    stringBuilder.append("19");
                    stringBuilder.append(" ");
                    break;
                case "t":
                    stringBuilder.append("20");
                    stringBuilder.append(" ");
                    break;
                case "u":
                    stringBuilder.append("21");
                    stringBuilder.append(" ");
                    break;
                case "v":
                    stringBuilder.append("22");
                    stringBuilder.append(" ");
                    break;
                case "w":
                    stringBuilder.append("23");
                    stringBuilder.append(" ");
                    break;
                case "x":
                    stringBuilder.append("24");
                    stringBuilder.append(" ");
                    break;
                case "y":
                    stringBuilder.append("25");
                    stringBuilder.append(" ");
                    break;
                case "z":
                    stringBuilder.append("26");
                    stringBuilder.append(" ");
                    break;
            }
        }

        return calculateSum(stringBuilder.toString());
    }

    int calculateSum(String wordConvertedToNumbers) {
        String[] splitted = wordConvertedToNumbers.split(" ");
        int wordSize = splitted.length;
        return calculate(splitted, wordSize-1, 0);
    }

    int calculate(String[] splitted, int wordSize, int wordPosition) {
        if(wordSize < 0) {
            return 0;
        }
        return Integer.valueOf(splitted[wordPosition]) * (int)Math.pow(alphabetCharacters, wordSize) +
                calculate(splitted,--wordSize,++wordPosition);
    }

    class Node {
        String word;
        String meaning;
        Node next;

        Node(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
        }
    }

    public static void main(String[] args) {
        SeparateChainingHashTable hashTable = new SeparateChainingHashTable();
        hashTable.insert("cat", "Pet that want to cuddle and eat a lot");
        hashTable.insert("dog", "Pet that is loyal to people");
        hashTable.insert("kittens", "Pet that is fluffy and small");
        hashTable.remove("dog");

        String meaning = hashTable.find("kittens");
        if(meaning != null)
            System.out.println(meaning);
    }
}

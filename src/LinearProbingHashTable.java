import java.util.Optional;

public class LinearProbingHashTable {

    private Word[] dictionary;
    private final int dictionaryWords = 50000;
    private int alphabetCharacters = 27;

    LinearProbingHashTable() {
        dictionary = new Word[dictionaryWords];
    }

    Optional<Word> find(String word) {
        int hashedKey = hash(word);
        while(dictionary[hashedKey] != null && !dictionary[hashedKey].key.equals(word)) {
            hashedKey++;
        }

        return Optional.ofNullable(dictionary[hashedKey]);
    }

    void insert(String wordI, String meaning) {
        Word word = new Word(wordI, meaning);
        int hashedKey = hash(wordI);
        while(dictionary[hashedKey] != null && !dictionary[hashedKey].key.equals("-1")){
            hashedKey++;
        }
        dictionary[hashedKey] = word;
    }

    void delete(String word) {
        Word replacement = new Word("-1", "DELETED VALUE");
        int hashedKey = hash(word);
        while(dictionary[hashedKey] != null && !dictionary[hashedKey].key.equals(word)) {
            hashedKey++;
        }

        if(dictionary[hashedKey] != null)
            dictionary[hashedKey] = replacement;
    }

    int hash(String word) {
        return convertToNumbers(word) % 50000;
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

    class Word {
        String key;
        String meaning;

        Word(String key, String meaning) {
            this.key = key;
            this.meaning = meaning;
        }
    }

    public static void main(String[] args) {
        LinearProbingHashTable hashTable = new LinearProbingHashTable();
        hashTable.insert("cat", "Pet that want to cuddle and eat a lot");
        hashTable.insert("dog", "Pet that is loyal to people");
        hashTable.insert("kittens", "Pet that is fluffy and small");
        hashTable.delete("dog");

        hashTable.find("kittens").ifPresent((Word word) -> {System.out.println(word.meaning);});
    }
}

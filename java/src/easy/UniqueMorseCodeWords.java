package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public final String[] table =   {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word: words) {
            set.add(word2morse(word));
        }
        return set.size();
    }

    private String word2morse(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c: word.toCharArray()) {
            sb.append(table[c-'a']);
        }
        return sb.toString();
    }
}


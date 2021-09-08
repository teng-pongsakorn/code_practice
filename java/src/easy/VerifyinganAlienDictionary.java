package easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted_v2(String[] words, String order) {
        int[] char2index = new int[26];
        for (int i=0; i<order.length(); i++) {
            char2index[order.charAt(i) - 'a'] = i;
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.equals(word2)) return 0;
                int i=0, j=0;
                while (i < word1.length() && j < word2.length()) {
                    if (char2index[word1.charAt(i)-'a'] < char2index[word2.charAt(i)-'a']) {
                        return -1;
                    } else if (char2index[word1.charAt(i)-'a'] > char2index[word2.charAt(i)-'a']){
                        return 1;
                    } else {
                        i++;
                        j++;
                    }
                }
                return  word1.length() > word2.length() ? 1 : -1;
            }
        };

        for (int i = 1; i < words.length; i++) {
            if (comparator.compare(words[i-1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> char2index = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            char2index.put(order.charAt(i), i);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.equals(word2)) return 0;
                int i=0, j=0;
                while (i < word1.length() && j < word2.length()) {
                    if (char2index.get(word1.charAt(i)) < char2index.get(word2.charAt(j))) {
                        return -1;
                    } else if (char2index.get(word1.charAt(i)) > char2index.get(word2.charAt(j))){
                        return 1;
                    } else {
                        i++;
                        j++;
                    }
                }
                return  word1.length() > word2.length() ? 1 : -1;
            }
        };

        for (int i = 1; i < words.length; i++) {
            if (comparator.compare(words[i-1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}

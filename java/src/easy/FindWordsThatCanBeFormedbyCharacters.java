package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters_v2(String[] words, String chars) {
        int countLength = 0;
        int[] sources = new int[26];
        for (char c: chars.toCharArray()) {
            sources[c - 'a']++;
        }
        for (String word: words) {
            int[] sourceCopy = Arrays.copyOf(sources, sources.length);
            boolean isPossible = true;
            for (char c: word.toCharArray()) {
                if (sourceCopy[c - 'a'] <= 0) {
                    isPossible = false;
                    break;
                }
                sourceCopy[c - 'a']--;
            }
            countLength += isPossible ? word.length() : 0;
        }
        return countLength;
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charsCount = getCharCount(chars);
        int countPossible = 0;
        for (String word: words) {
            Map<Character, Integer> wordCount = getCharCount(word);
            boolean isPossible = true;
            for (Map.Entry<Character, Integer> entry: wordCount.entrySet()) {
                if (charsCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    isPossible = false;
                    break;
                }
            }
            countPossible += isPossible ? word.length() : 0;
        }
        return countPossible;
    }

    private Map<Character, Integer> getCharCount(String chars) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c: chars.toCharArray()) {
            result.put(c, 1 + result.getOrDefault(c, 0));
        }
        return result;
    }
}

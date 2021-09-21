package hard;

import java.util.*;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int wordSize = words[0].length();
        int totalSize = wordSize * words.length;
        for (int i=0; i<wordSize; i++) {
            int remainWords = words.length;
            int left, right;
            for (left=i, right=i+wordSize; right <= s.length(); right+=wordSize) {
                String rightWord = s.substring(right - wordSize, right);
                wordMap.put(rightWord, wordMap.getOrDefault(rightWord, 0) - 1);
                if (wordMap.get(rightWord) >= 0) remainWords--;

                if (right - left > totalSize) {
                    String leftWord = s.substring(left, left + wordSize);
                    wordMap.put(leftWord, wordMap.get(leftWord)+1);
                    if (wordMap.get(leftWord) > 0) remainWords++;
                    left += wordSize;
                }
                if (remainWords == 0) {
                    result.add(left);
                }
            }
            while (left + wordSize <= s.length()) {
                String leftWord = s.substring(left, left + wordSize);
                wordMap.put(leftWord, wordMap.get(leftWord)+1);
                left += wordSize;
            }
        }
        return result;
    }
    public List<Integer> findSubstring_v1(String s, String[] words) {
        int totalLength = words.length * words[0].length();
        List<Integer> result = new LinkedList<>();
        if (totalLength > s.length()) return result;

        // count all chars in all words:
        int[] chars = new int[26];
        for (String word: words) {
            for (char c: word.toCharArray()) {
                chars[c - 'a']++;
            }
        }

        // use sliding window: check valid chars, then check valid words
        int remainSize = totalLength;
        for (int left=0, right=0; right < s.length(); right++) {
            chars[s.charAt(right) - 'a']--;
            if (chars[s.charAt(right)-'a'] >= 0) remainSize--;

            if (right - left + 1 > totalLength) {
                chars[s.charAt(left)-'a']++;
                if (chars[s.charAt(left)-'a'] >= 1) remainSize++;
                left++;
            }

            if (remainSize == 0) {
                if (isValid(s, left, right, words)) {
                    result.add(left);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s, int left, int right, String[] words) {
        int size = words[0].length();
        Set<Integer> indices = new HashSet<>();
        for (int i=left; i<=right; i += size) {
            String x = s.substring(i, i+size);
            boolean isFound = false;
            for (int j=0; j<words.length; j++) {
                if (!indices.contains(j) && words[j].equals(x)) {
                    isFound = true;
                    indices.add(j);
                    break;
                }
            }
            if (!isFound) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords sol = new SubstringwithConcatenationofAllWords();
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
//"barfoothefoobarman"
//["foo","bar"]
//"wordgoodgoodgoodbestword"
//["word","good","best","word"]
//"barfoofoobarthefoobarman"
//["bar","foo","the"]
//"wordgoodgoodgoodbestword"
//["word","good","best","good"]
//"lingmindraboofooowingdingbarrwingmonkeypoundcake"
//["fooo","barr","wing","ding","wing"]
//"ababababab"
//["ababa","babab"]
//"ababaab"
//["ab","ba","ba"]
    }
}

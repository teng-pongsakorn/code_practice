package easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Integer[] patternList = new Integer[26];
        Map<String, Integer> sDict = new HashMap<>();
        int count = 0;
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (patternList[c-'a']==null && sDict.get(words[i])==null) {
                patternList[c-'a'] = count;
                sDict.put(words[i], count);
                count++;
            } else if (patternList[c-'a'] != sDict.get(words[i])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(WordPattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(WordPattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(WordPattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(WordPattern.wordPattern("abba", "dog dog dog dog"));
        String pat = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(WordPattern.wordPattern(pat, s));
        System.out.println(pat.length());
        System.out.println(s.split(" ").length);
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(map.get('x'));
    }
}

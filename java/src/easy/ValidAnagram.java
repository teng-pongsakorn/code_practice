package easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i=0; i<s.length(); i++) {
            count[sChars[i]-'a']--;
            count[tChars[i]-'a']++;
        }
        s.charAt(0);
        for (int val: count) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram_v1(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> countDict = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            countDict.put(s.charAt(i), countDict.getOrDefault(s.charAt(i), 0) + 1);
            countDict.put(t.charAt(i), countDict.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int val: countDict.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidAnagram.isAnagram("anagram", "nagaram") == true);
        System.out.println(ValidAnagram.isAnagram("hat", "fat") == false);
    }
}

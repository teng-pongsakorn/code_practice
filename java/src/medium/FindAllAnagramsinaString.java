package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() == 0 || s.length() < p.length()) return result;

        // count all letters from p
        int[] chars = new int[26];
        for (char c: p.toCharArray()) {
            chars[c - 'a']++;
        }

        // use sliding window to check anagram
        int left = 0, right, remainChars = p.length(), targetSize = p.length();
        for (right = 0; right < s.length(); right++) {
            if (right - left + 1 < targetSize) {
                chars[s.charAt(right) - 'a']--;
                if (chars[s.charAt(right) - 'a'] >= 0) remainChars--;
            } else {
                chars[s.charAt(left) - 'a']++;
                if (chars[s.charAt(left)-'a'] >= 1) remainChars++;
                chars[s.charAt(right) - 'a']--;
                if (chars[s.charAt(right) - 'a'] >= 0) remainChars--;
                left++;
            }

            // check if found valid anagram
            if (remainChars == 0) result.add(left);
        }
        return result;
    }
    public List<Integer> findAnagrams_v1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pSize = p.length();
        int[] pChars = new int[26];
        int[] sSubChars = new int[26];
        for (char c: p.toCharArray()) {
            pChars[c - 'a']++;
        }

        for (int i=0; i<s.length(); i++) {
            if (i < p.length()) {
                sSubChars[s.charAt(i) - 'a']++;
            } else {
                sSubChars[s.charAt(i) - 'a']++;
                sSubChars[s.charAt(i-pSize) -'a']--;
            }
            if (i + 1 >= pSize && isEqual(pChars, sSubChars)) {
                result.add(i - pSize + 1);
            }
        }
        return result;
    }

    private boolean isEqual(int[] pChars, int[] sSubChars) {
        for (int i=0; i<pChars.length; i++) {
            if (pChars[i] != sSubChars[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString sol = new FindAllAnagramsinaString();
        System.out.println(sol.findAnagrams("cbaebabacd","abc"));
        System.out.println(sol.findAnagrams("abab",  "ab"));
//        System.out.println(sol.findAnagrams("cbaebabacd","abc"));
    }
}

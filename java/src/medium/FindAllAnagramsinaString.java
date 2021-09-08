package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
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

package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        int oddCount = 0;
        for (int n: count) {
            oddCount += n&1;
        }
        return s.length() - oddCount + (oddCount > 0 ? 1 : 0);
    }
    public int longestPalindrome_v2(String s) {
        int[] count = new int[58];
        for (char c: s.toCharArray()) {
            count[c-'A']++;
        }
        int len = 0;
        int hasOdd = 0;
        for (int n: count) {
            len += (n / 2) * 2;
            hasOdd = hasOdd == 1 ? hasOdd : n%2;
        }
        return len + hasOdd;
    }
    public int longestPalindrome_v1(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c: s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }
        int len = 0;
        int hasOdd = 0;
        for (Integer val: charCount.values()) {
            len += (val / 2)*2;
            hasOdd = hasOdd==1 ? 1 : val%2;
        }
        return len + hasOdd;
    }

    public static void main(String[] args) {
        LongestPalindrome solve = new LongestPalindrome();
        System.out.println(solve.longestPalindrome("abccccdd"));
        System.out.println(solve.longestPalindrome("a"));
        System.out.println(solve.longestPalindrome("bb"));

        System.out.println("=".repeat(20));
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println('A'-'z');
    }
}

package hard;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] chars = new int[256];

        for (char c: t.toCharArray()) {
            chars[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int left = 0, right, remainT = t.length();
        for (right = 0; right < s.length(); right++) {
            chars[s.charAt(right)]--;
            if (chars[s.charAt(right)] >= 0) remainT--;
            if (remainT == 0) {
                while (remainT == 0) {
                    int len = right - left + 1;
                    if (len < minLen) {
                        minLen = len;
                        minStart = left;
                    }
                    chars[s.charAt(left)]++;
                    if (chars[s.charAt(left)] >= 1) remainT++;
                    left++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "a"));
        System.out.println(sol.minWindow("a", "aa"));
    }
}

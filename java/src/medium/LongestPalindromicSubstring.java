package medium;

import java.util.ArrayDeque;

public class LongestPalindromicSubstring {

    public String longestPalindrome_v1(String s) {
        String longest0 = s.substring(0, 1);
        String longest1 = getLongestPalindrome(s, 1);
        String longest2 = getLongestPalindrome(s, 2);
        if (longest2.length() > longest1.length() && longest2.length() > longest0.length()) {
            return longest2;
        } else if (longest1.length() > longest2.length() && longest1.length() > longest0.length()) {
            return longest1;
        }
        return longest0;
    }

    private String getLongestPalindrome(String s, int initSize) {
        int n = s.length();
        int[] path = new int[n];

        // start with palindromes of initSize
        for (int i=0; i<s.length(); i++) {
            if (i < n - initSize && s.charAt(i) == s.charAt(i+initSize)) {
                path[i] = i+initSize;
            }
        }
        // try expanding existing palindromes
        int maxLength = initSize;
        boolean isDone = false;
        String longest = "";
        while (!isDone) {
            isDone = true;
            for (int i=0; i<s.length(); i++) {
                if (path[i] > 0) {
                    int start = i;
                    int end = path[i];
                    if (end - start + 1 > maxLength) {
                        maxLength = end - start + 1;
                        longest = s.substring(start, end+1);
                    }
                    if (start > 0 && end < n-1 && s.charAt(start-1)==s.charAt(end+1)) {
                        isDone = false;
                        path[start-1] = end+1;
                    }
                    path[i] = 0;
                }
            }
        }
        return longest;
    }

    public String longestPalindrome_v2(String s) {
        String longest = s.substring(0, 1);
        int n = s.length();
        int maxLen = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            if (i < n-1 && s.charAt(i)==s.charAt(i+1)) {
                queue.addLast(new int[] {i, i+1});
            }
            if (i < n-2 && s.charAt(i)==s.charAt(i+2)) {
                queue.addLast(new int[] {i, i+2});
            }
        }
        while (!queue.isEmpty()) {
            int[] pair = queue.removeFirst();
            int start = pair[0];
            int end = pair[1];
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                longest = s.substring(start, end + 1);
            }
            if (start > 0 && end < n-1 && s.charAt(start-1)==s.charAt(end+1)) {
                queue.addLast(new int[] {start-1, end+1});
            }
        }
        return longest;
    }

    // Manacher's Algorithm
    public String longestPalindrome(String s) {
        s = modify(s);
//        System.out.println("s = " + s);
        int[] palindromes = new int[s.length()];
        int maxIndex = 0;
        int maxLen = 0;
        int center = 0;
        int reach = 0;
        for (int i=1; i<s.length()-1; i++) {
//            System.out.println("p[] = " + Arrays.toString(palindromes));
            int mirrorIndex = center - (i - center);
            if (i < reach) {
                palindromes[i] = Math.min(palindromes[mirrorIndex], reach - i);
            }
            while (s.charAt(i - (1 + palindromes[i])) == s.charAt(i + (1 + palindromes[i]))) {
                palindromes[i]++;
            }
            if (i + palindromes[i] > reach) {
                center = i;
                reach = i + palindromes[i];
            }
            if (palindromes[i] > maxLen) {
                maxLen = palindromes[i];
                maxIndex = i;
            }
        }
//        System.out.println("maxIndex:" + maxIndex + " maxLen:" + maxLen);
//        System.out.println("s = " + s);
        String result = s.substring(maxIndex - maxLen, maxIndex + maxLen).replaceAll("#", "");
        return result;
    }

    private String modify(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("#");
        for (char c: s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        sb.append(")");
        return sb.toString();
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome("babad").equals("bab"));
        System.out.println(sol.longestPalindrome("cbbd").equals("bb"));
        System.out.println(sol.longestPalindrome("a").equals("a"));
        System.out.println(sol.longestPalindrome("ac").equals("a"));
        System.out.println(sol.longestPalindrome("abcdefgfedcbahikki").equals("abcdefgfedcba"));
        System.out.println(sol.longestPalindrome("aaaa").equals("aaaa"));
    }

}

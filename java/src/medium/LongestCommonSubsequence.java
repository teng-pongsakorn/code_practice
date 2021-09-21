package medium;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, 0, text2, 0, memo);
    }
    private int longestCommonSubsequence(String text1, int idx1, String text2, int idx2, Integer[][] memo) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }
        if (memo[idx1][idx2] != null) return memo[idx1][idx2];
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return memo[idx1][idx2] = 1 + longestCommonSubsequence(text1, idx1+1, text2, idx2+1, memo);
        }
        return memo[idx1][idx2] = Math.max(longestCommonSubsequence(text1, idx1+1, text2, idx2, memo),
                longestCommonSubsequence(text1, idx1, text2, idx2+1, memo));
    }
    public int longestCommonSubsequence_dp(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
    public int longestCommonSubsequence_brute(String text1, String text2) {
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        int[] intersect = new int[26];
        for (char c: text1.toCharArray()) chars1[c-'a']++;
        for (char c: text2.toCharArray()) chars2[c-'a']++;
        for (int i=0; i<26; i++) intersect[i] = Math.min(chars1[i], chars2[i]);
        int[] result = {0};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<text2.length(); i++) {
            if (intersect[text2.charAt(i)-'a'] > 0) {
                sb.append(text2.charAt(i));
                intersect[text2.charAt(i)-'a']--;
                helper(text1, text2, i+1, intersect, sb, result);
                sb.setLength(sb.length()-1);
                intersect[text2.charAt(i)-'a']++;
            }
        }
        return result[0];
    }

    private void helper(String text1, String text2, int start, int[] intersect, StringBuilder builder, int[] result) {
        String x = builder.toString();
        if (isSubsequence(text1, x) && x.length() > result[0]) {
            result[0] = x.length();
        }
        for (int i=start; i<text2.length(); i++) {
            if (intersect[text2.charAt(i)-'a'] > 0) {
                builder.append(text2.charAt(i));
                intersect[text2.charAt(i)-'a']--;
                helper(text1, text2, i+1, intersect, builder, result);
                builder.setLength(builder.length()-1);
                intersect[text2.charAt(i)-'a']++;
            }
        }
    }

    private boolean isSubsequence(String text, String sub) {
        int i = 0;
        for (char c: text.toCharArray()) {
            if (c == sub.charAt(i)) i++;
            if (i == sub.length()) break;
        }
        return i == sub.length();
    }


    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
        System.out.println(sol.longestCommonSubsequence("abcde", "ace" ));
        System.out.println(sol.longestCommonSubsequence("abc",  "abc"));
        System.out.println(sol.longestCommonSubsequence("abc", "def" ));
        System.out.println(sol.longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ));
        System.out.println(sol.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr" )==5);

    }
}

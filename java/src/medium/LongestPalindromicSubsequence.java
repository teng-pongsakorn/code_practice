package medium;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i=s.length()-1; i>=0; i--) {
            dp[i][i] = 1;
            for (int j=1+i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
    public int longestPalindromeSubseq_memo(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length()-1, memo);
    }

    private int longestPalindromeSubseq(String s, int left, int right, Integer[][] memo) {
        if (left > right) return 0;
        if (left == right) return 1;
        if (memo[left][right] != null) return memo[left][right];
        if (s.charAt(left) == s.charAt(right)) {
            return memo[left][right] = 2 + longestPalindromeSubseq(s, left+1, right-1, memo);
        } else {
            return memo[left][right] = Math.max(longestPalindromeSubseq(s, left+1, right, memo),
                                                longestPalindromeSubseq(s, left, right-1, memo));
        }
    }



    public static void main(String[] args) {
        LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
        System.out.println(sol.longestPalindromeSubseq("cbbd"));
        System.out.println(sol.longestPalindromeSubseq("aaaaaaaaaaaaaaxaaaaaaaaadaaaaaaaaaaadaaaaaaaaaaah"));
    }
}

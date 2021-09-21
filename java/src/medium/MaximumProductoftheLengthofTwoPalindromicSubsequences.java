package medium;

import java.util.LinkedList;

public class MaximumProductoftheLengthofTwoPalindromicSubsequences {
    public int maxProduct(String s) {
        // dp solution
        int maxLen = 0;
        int[] dp = new int[1<<12];
        for (int i=1; i<(1<<s.length()); i++) {
            dp[i] = palendromeSize(s, i);
        }
        int allPossible = (1 << s.length()) - 1;
        for (int i=1; i<(1<<s.length()); i++) {
            if (dp[i] * (s.length() - dp[i]) > maxLen) {
                for (int j=allPossible^i; j>0; j = (j-1) & (allPossible ^ i)) {
                    maxLen = Math.max(maxLen, dp[i]*dp[j]);
                }
            }
        }

        return maxLen;
    }

    private int palendromeSize(String s, int mask) {
        int lo = 0, hi = s.length()-1;
        int result = 0;
        while (lo <= hi) {
            if ((mask & (1 << lo)) == 0) {
                lo++;
            } else if ((mask & (1 << hi)) == 0) {
                hi--;
            } else if (s.charAt(lo) != s.charAt(hi)) {
                return 0;
            } else {
                result += 1 + (lo++ == hi-- ? 0 : 1);
            }
        }
        return result;
    }

    int maxProd = 0;
    public int maxProduct_v3(String s) {
        LinkedList<Character> left = new LinkedList<>();
        LinkedList<Character> right = new LinkedList<>();
        helper(s, 0, left, right);
        return maxProd;
    }

    private void helper(String s, int idx, LinkedList<Character> left, LinkedList<Character> right) {
        boolean leftIsPalindrome = isPalindrome(left);
        boolean rightIsPalindrome = isPalindrome(right);
        if (leftIsPalindrome && rightIsPalindrome) {
            int prod = left.size() * right.size();
            maxProd = prod > maxProd ? prod : maxProd;
        }
        if (idx == s.length()) return;
        // left take s[i]
        left.add(s.charAt(idx));
        helper(s, idx+1, left, right);
        left.removeLast();
        // right take s[i]
        right.add(s.charAt(idx));
        helper(s, idx+1, left, right);
        right.removeLast();
        // none take s[i]
        helper(s, idx+1, left, right);
    }

    private boolean isPalindrome(LinkedList<Character> chars) {
        int lo = 0, hi = chars.size()-1;
        while (lo < hi) {
            if (chars.get(lo++) != chars.get(hi--)) return false;
        }
        return true;
    }

    int max = 0;
    public int maxProduct_v1(String s) {
        char[] chars = s.toCharArray();
        dfs(chars, 0, "", "");
        return max;
    }

    private void dfs(char[] chars, int i, String s1, String s2) {
        if (i == chars.length) {
            if (isPalindrome(s1) && isPalindrome(s2)) {
                int product = s1.length() * s2.length();
                max = product > max ? product : max;
            }
        }
        dfs(chars, i+1, s1 + chars[i], s2);
        dfs(chars, i+1, s1, s2 + chars[i]);
        dfs(chars, i+1, s1, s2);
    }

    private boolean isPalindrome(String x) {
        int start = 0, end = x.length()-1;
        while (start < end) {
            if (x.charAt(start++) != x.charAt(end--)) return false;
        }
        return true;
    }

    public int maxProduct_v2(String s) {
        int[] palindromes = new int[4096];
        int maxlen = 0;
        for (int mask=1; mask < 1<<s.length() - 1; mask++) {
            palindromes[mask] = palinLength(s, mask);
        }
        for (int mask1=1; mask1<1<<s.length(); mask1++) {
            for (int mask2=mask1+1; mask2<1<<s.length(); mask2++) {
                if ((mask1 & mask2) == 0 && palindromes[mask1]*palindromes[mask2] > maxlen) {
                    maxlen = palindromes[mask1] * palindromes[mask2];
                }
            }
        }
        return maxlen;
    }

    private int palinLength(String s, int mask) {
        int left = 0, right = s.length()-1;
        int len = 0;
        while (left < right) {
            if ((mask & (1 << left)) == 0) {
                left++;
            } else if ((mask & (1 << right)) == 0) {
                right--;
            } else if (s.charAt(left) != s.charAt(right)) {
                return 0;
            } else {
                len += 1 + (left++ == right-- ? 0 : 1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MaximumProductoftheLengthofTwoPalindromicSubsequences sol = new MaximumProductoftheLengthofTwoPalindromicSubsequences();
        System.out.println(1 << 12);
        System.out.println(sol.maxProduct("leetcodecom"));
        System.out.println(sol.maxProduct("bb"));
        System.out.println(sol.maxProduct("accbcaxxcxx"));
        System.out.println(sol.maxProduct("zyz"));
    }
}

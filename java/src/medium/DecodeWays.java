package medium;

public class DecodeWays {
    public int numDecodings(String s) {
//        int[] digits = Arrays.stream(s.split("")).mapToInt(x -> Integer.valueOf(x)).toArray();
        int[] digits = new int[s.length()];
        int[] digitsTwo = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            digits[i] = s.charAt(i)-'0';
            if (i > 0) {
                digitsTwo[i] = 10 * (s.charAt(i-1)-'0') + (s.charAt(i)-'0');
            }
        }
        int[] dp = new int[s.length()+1];
        dp[1] = digits[0] == 0 ? 0 : 1;
        if (s.length() <= 1 || dp[1]==0) return dp[1];
        dp[2] = (digits[1] == 0 ? 0 : 1);
        if (dp[1] != 0 && digitsTwo[1] <= 26) {
            dp[2]++;
        }
        for (int i=2; i<s.length(); i++) {
            if (digits[i] != 0) {
                dp[i+1] += dp[i];
            }
            if (digits[i-1] != 0 && digitsTwo[i] <= 26) {
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
    public int numDecodings_memo(String s) {
        Integer[] memo = new Integer[s.length()+1];
        return countDP(s, s.length(), memo);
    }

    private int countDP(String s, int len, Integer[] memo) {
        if (len <= 0) return 0;
//        System.out.println("f(" + len + ")");
        if (memo[len] != null) return memo[len];
        if (len == 1) {
            memo[1] = s.charAt(len-1) == '0' ? 0 : 1;
            return memo[1];
        }
        int numSize1 = s.charAt(len-1) - '0';
        int numSize2 = s.charAt(len-2) == '0' ? 0 : Integer.valueOf(s.substring(len-2, len));
        int result = 0;
        if (len == 2) {
            if (numSize2 > 0 && numSize2 <= 26) {
                result += 1;
            }
            if (numSize1 > 0 && s.charAt(len-2)-'0' > 0) {
                result += 1;
            }
            memo[len] = result;
            return result;
        }
        if (numSize2 > 0 && numSize2 <= 26) {
            result += countDP(s, len-2, memo);
        }
        if (numSize1 > 0) {
            result += countDP(s, len-1, memo);
        }
        memo[len] = result;
        return result;
//        System.out.println("numSize1=" + numSize1 + " numSize2=" + numSize2);
//        if (len == 2) {
//            if (numSize2 > 0 && numSize2 <= 26) {
//                if (numSize1 > 0) {
//                    memo[len] = 2;
//                    return 2;
//                }
//                memo[len] = 1;
//                return 1;
//            }
//        } else if (len > 2) {
//            if (numSize2 > 0 && numSize2 <= 26) {
//                if (numSize1 > 0) {
//                    memo[len] = countDP(s, len-1, memo) + countDP(s, len-2, memo);
//                    return memo[len];
//                }
//                memo[len] = countDP(s, len-2, memo);
//                return memo[len];
//            } else if (numSize1 > 0) {
//                memo[len] = countDP(s, len-1, memo);
//                return memo[len];
//            }
//        }
//        memo[len] = 0;
//        return 0;
    }


    int result;
    public int numDecodings_naive(String s) {
        result = 0;
        count(0, s);
        return result;
    }

    private void count(int i, String s) {
        if (i == s.length()) {
            result += 1;
            return;
        }
        if (s.charAt(i) == '0') return ;
        // take 1 step
        count(i+1, s);
        // take 2 step
        if (i <= s.length() - 2) {
            int numSize2 = Integer.valueOf(s.substring(i, i+2));
            if (numSize2 >= 1 && numSize2 <= 26) {
                count(i+2, s);
            }
        }
    }

    public static void main(String[] args) {
        DecodeWays sol = new DecodeWays();
        System.out.println(sol.numDecodings("12")==2);
        System.out.println(sol.numDecodings("226")==3);
        System.out.println(sol.numDecodings("0")==0);
        System.out.println(sol.numDecodings("06")==0);
        System.out.println(sol.numDecodings("302")==0);
        System.out.println(sol.numDecodings("11106")==2);
        System.out.println(sol.numDecodings("11111111111111111111")==10946);
        System.out.println(sol.numDecodings("1111111111111111111111111111111111111111"));
        System.out.println(sol.numDecodings("27")==1);
    }
}

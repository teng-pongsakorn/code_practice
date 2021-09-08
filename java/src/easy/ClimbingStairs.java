package easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public static Map<Integer, Integer> memo = new HashMap<>();
    static {
        memo.put(0, 1);
        memo.put(1, 1);
    }
    public static int climStairs_v3(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int oneStep = climStairs_v3(n - 1);
        int twoStep = climStairs_v3(n - 2);
        memo.put(n, oneStep + twoStep);
        return oneStep + twoStep;
    }
    public static int climbStairs_v2(int n) {
        int prev1 = 0;
        int prev2 = 1;
        int result = -1;
        for (int i = 1; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
    public static int climbStairs(int n) {
        return climbStairs(n, 1) + climbStairs(n, 2);
    }

    public static int climbStairs(int n, int step) {
        if (n == step) {
            return 1;
        }
        if (n < step) {
            return 0;
        }
        return climbStairs(n-step, 1) + climbStairs(n-step, 2);
    }

    public static void main(String[] args) {
        System.out.println(ClimbingStairs.climbStairs(2));
        System.out.println(ClimbingStairs.climbStairs(1));
        System.out.println(ClimbingStairs.climbStairs(3));
        System.out.println(ClimbingStairs.climbStairs(44));
        System.out.println(ClimbingStairs.climbStairs_v2(2));
        System.out.println(ClimbingStairs.climbStairs_v2(1));
        System.out.println(ClimbingStairs.climbStairs_v2(3));
        System.out.println(ClimbingStairs.climbStairs_v2(44));
    }
}

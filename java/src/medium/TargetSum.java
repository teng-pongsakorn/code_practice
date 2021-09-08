package medium;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num: nums) total += num;
        if (Math.abs(target) > total) return 0;

        int[] dp = new int[2*total + 1];
        dp[nums[0] + total] = 1;
        dp[-nums[0] + total] += 1;
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            int[] dpNext = new int[2*total + 1];
            for (int sum=-total; sum<=total; sum++) {
                // get previous valid sum up to i-th numbers
                if (dp[sum + total] > 0) {
                    dpNext[sum + num + total] += dp[sum + total];
                    dpNext[sum - num + total] += dp[sum + total];
                }
            }
            dp = dpNext;
        }
        return dp[target + total];
    }

    public int findTargetSumWays_dp2D(int[] nums, int target) {
        int total = 0;
        for (int num: nums) total += num;
        if (Math.abs(target) > total) return 0;

        int[][] dp = new int[nums.length][2*total + 1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            for (int sum=-total; sum<=total; sum++) {
                // get previous valid sum up to i-th numbers
                if (dp[i-1][sum + total] > 0) {
                    dp[i][sum + num + total] += dp[i-1][sum + total];
                    dp[i][sum - num + total] += dp[i-1][sum + total];
                }
            }
        }
        return dp[dp.length - 1][target + total];
    }
    public int findTargetSumWays_memo(int[] nums, int target) {
//        Map<String, Integer> memo = new HashMap<>();
        int total = 0;
        for (int num: nums) total += num;
        if (Math.abs(target) > total) return 0;
        Integer[][] memo = new Integer[nums.length][2*total + 1];
//        System.out.println("memo shape:[" + memo.length + ", " + memo[0].length + "]");
        return count_memo(nums, 0, 0, target, memo);
    }

    private int count_memo(int[] nums, int i, int sum, int target,Integer[][] memo) {
//        String key = i + "," + target;
//        if (memo.containsKey(key)) return memo.get(key);
//        if (i == nums.length) return target == 0 ? 1 : 0;
//        int result = count_memo(nums, i+1, target + nums[i], memo) + count_memo(nums, i+1, target - nums[i], memo);
//        memo.put(key, result);
//        return result;
        if (i >= nums.length) return target == sum ? 1 : 0;
        int total = memo[0].length / 2;
//        System.out.println("check memo at [" + i + ", " + (sum+total) + "]" + " : target: " + target);
        if (memo[i][sum + total] != null) return memo[i][sum + total];
        int result = count_memo(nums, i+1, sum + nums[i], target, memo) + count_memo(nums, i+1, sum - nums[i], target, memo);
        memo[i][sum + total] = result;
        return memo[i][sum + total];
    }

    public int findTargetSumWays_naive(int[] nums, int target) {
        return count_naive(nums, 0, target);
    }

    private int count_naive(int[] nums, int i, int target) {
        if (i == nums.length) return target == 0 ? 1 : 0;
        return count_naive(nums, i+1, target + nums[i]) + count_naive(nums, i+1, target - nums[i]);
    }

    public static void main(String[] args) {
        TargetSum sol = new TargetSum();
        int[] nums;
        int target;

        nums = new int[] {1,1,1,1,1};
        target = 3;
        System.out.println(sol.findTargetSumWays(nums, target) == 5);

        nums = new int[] {1};
        target = 1;
        System.out.println(sol.findTargetSumWays(nums, target) == 1);

        nums = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        target = 4;
        System.out.println(sol.findTargetSumWays(nums, target) == 125970);
    }
}

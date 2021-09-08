package medium;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev2 = 0;
        int prev1 = nums[0];
        for (int i=1; i<nums.length; i++) {
            int tmp = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = tmp;
        }
        return prev1;
    }
    public int rob_iterative_memo(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int n=2; n<=nums.length; n++) {
            memo[n] = Math.max(nums[n-1] + memo[n-2], memo[n-1]);
        }
        return memo[nums.length];
    }
    public int rob_recursive_memo(int[] nums) {
        Integer[] robRecords = new Integer[nums.length];
        return maximizeRob(nums, nums.length-1, robRecords);
    }

    private int maximizeRob(int[] nums, int n, Integer[] robRecords) {
        if (robRecords[n] != null) return robRecords[n];
        if (n == 0) {
            robRecords[n] = nums[n];
            return robRecords[n];
        }
        if (n == 1) {
            robRecords[n] = Math.max(nums[0], nums[1]);
            return robRecords[n];
        }
        int choice1 = nums[n] + maximizeRob(nums, n-2, robRecords);
        int choice2 = maximizeRob(nums, n-1, robRecords);
        robRecords[n] = Math.max(choice1, choice2);
        return robRecords[n];
    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        int[] nums;

        nums = new int[] {1,2,3,1};
        System.out.println(sol.rob(nums) == 4);

        nums = new int[] {2,7,9,3,1};
        System.out.println(sol.rob(nums) == 12);
    }
}

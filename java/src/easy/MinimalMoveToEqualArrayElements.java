package easy;

public class MinimalMoveToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num: nums) {
            min = num < min ? num : min;
            sum += num;
        }
        return sum - nums.length*min;
    }
    public int minMoves_naive(int[] nums) {
        return helper(nums);
    }

    private int helper(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        if (max == min) return 0;
        int diff = max-min;
        for (int i=0; i<nums.length; i++) {
            if (i!=maxIdx) {
                nums[i] += diff;
            }
        }
        return diff + helper(nums);
    }

    public static void main(String[] args) {
        MinimalMoveToEqualArrayElements solve = new MinimalMoveToEqualArrayElements();
        int[] nums;

        nums = new int[] {1,2};
        System.out.println(solve.minMoves(nums)==1);

        nums = new int[] {1,2, 3};
        System.out.println(solve.minMoves(nums)==3);

        nums = new int[] {1,1,1};
        System.out.println(solve.minMoves(nums)==0);
    }
}

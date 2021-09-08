package easy;

public class MaximumAscendingSubarraySum {

    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = sum > maxSum ? sum : maxSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumAscendingSubarraySum sol = new MaximumAscendingSubarraySum();
        int[] nums;

        nums = new int[] {10,20,30,5,10,50};
        System.out.println(sol.maxAscendingSum(nums));

        nums = new int[] {10,20,30,40,50};
        System.out.println(sol.maxAscendingSum(nums));

        nums = new int[] {12,17,15,13,10,11,12};
        System.out.println(sol.maxAscendingSum(nums));

        nums = new int[] {100,10,1};
        System.out.println(sol.maxAscendingSum(nums));
    }
}

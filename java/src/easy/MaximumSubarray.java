package easy;

public class MaximumSubarray {

    public int maxSubArray_v1(int[] nums) {
        int[] cumsum = new int[nums.length];
        cumsum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            cumsum[i] = nums[i] + cumsum[i-1];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < cumsum.length; i++) {
            maxSum = Math.max(maxSum, cumsum[i]);
            for (int j=i+1; j<cumsum.length; j++) {
                maxSum = Math.max(maxSum, cumsum[j] - cumsum[i]);
            }
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cumSum = nums[0];
        int maxSum = cumSum;
        for (int i = 1; i < nums.length; i++) {
            cumSum = nums[i] + (cumSum > 0 ? cumSum : 0);
            maxSum = Math.max(cumSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // [-2,1,-3,4,-1,2,1,-5,4] => 6
        // [5,4,-1,7,8] => 23
        // [1] => 1
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(ms.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(ms.maxSubArray(new int[]{1}));
    }
}

package medium;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int maxEndHere = 0, maxSoFar = Integer.MIN_VALUE;
        int minEndHere = 0, minSoFar = Integer.MAX_VALUE;
        int total = 0;
        // forward kadane
        for (int num: nums) {
            maxEndHere += num;
            if (maxEndHere > maxSoFar) maxSoFar = maxEndHere;
            if (maxEndHere < 0) maxEndHere = 0;
            minEndHere += num;
            if (minEndHere < minSoFar) minSoFar = minEndHere;
            if (minEndHere > 0) minEndHere = 0;
            total += num;
        }
        return maxSoFar < 0 ? maxSoFar : Math.max(maxSoFar, total - minSoFar);

    }
    public int maxSubarraySumCircular_naive(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0, right = nums.length-1;
        while (left < nums.length) {
            int maxSoFar = Integer.MIN_VALUE;
            int maxEndHere = 0;
            for (int i=left; i<=right; i++) {
                maxEndHere += nums[i%nums.length];
                if (maxSoFar < maxEndHere) {
                    maxSoFar = maxEndHere;
                }
                if (maxEndHere < 0) {
                    maxEndHere = 0;
                }
            }
            maxSum = maxSoFar > maxSum ? maxSoFar : maxSum;
            left++;
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray sol = new MaximumSumCircularSubarray();

        int[] nums;

        // out = 3
        nums = new int[]{1,-2,3,-2};
        System.out.println(sol.maxSubarraySumCircular(nums));

        // 100
        nums = new int[]{100, -2, -1, -4};
        System.out.println(sol.maxSubarraySumCircular(nums));

        nums = new int[]{-1,-2,-3,-4,-3,-2,-1};
        System.out.println(sol.maxSubarraySumCircular(nums));

        nums = new int[]{-1,-2,-3,-4,3,-2,-1};
        System.out.println(sol.maxSubarraySumCircular(nums));

        nums = new int[]{3,-2, 5};
        System.out.println(sol.maxSubarraySumCircular(nums));

    }
}

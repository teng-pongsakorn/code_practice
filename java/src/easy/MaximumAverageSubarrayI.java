package easy;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int subarraySum = 0;
        for (int i=0; i<k; i++) {
            subarraySum += nums[i];
        }
        int maxSum = subarraySum;
        for (int i=k; i<nums.length; i++) {
            subarraySum += nums[i];
            subarraySum -= nums[i-k];
            maxSum = subarraySum > maxSum ? subarraySum : maxSum;
        }
        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();
        int[] nums;
        int k;

        // 12.75
        nums = new int[] {1,12,-5,-6,50,3};
        k = 4;
        System.out.println(sol.findMaxAverage(nums, k));

        // 5.0
        nums = new int[] {5};
        k = 1;
        System.out.println(sol.findMaxAverage(nums, k));
    }
}

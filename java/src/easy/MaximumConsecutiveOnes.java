package easy;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentSum = 0;
        int maxSum = 0;
        for (int num: nums) {
            if (num == 1) {
                currentSum++;
                maxSum = currentSum > maxSum ? currentSum : maxSum;
            } else {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes solution = new MaximumConsecutiveOnes();
        int[] nums;

        nums = new int[] {1,1,0,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));

        nums = new int[] {1,1,0,1,1,1,0,0,1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));

        nums = new int[] {1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));

        nums = new int[] {0};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }
}

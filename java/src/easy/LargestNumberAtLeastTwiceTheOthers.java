package easy;

public class LargestNumberAtLeastTwiceTheOthers {
    public int dominantIndex(int[] nums) {
        int firstMax = -1;
        int maxIndex = -1;
        int secondMax = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return 2 * secondMax <= firstMax ? maxIndex : -1;
    }
}

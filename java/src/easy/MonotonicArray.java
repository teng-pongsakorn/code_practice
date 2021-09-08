package easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        return isMonotonicIncrease(nums) || isMonotonicDecrease(nums);
    }

    private boolean isMonotonicDecrease(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isMonotonicIncrease(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}

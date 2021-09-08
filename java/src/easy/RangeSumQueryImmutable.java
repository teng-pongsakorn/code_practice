package easy;

public class RangeSumQueryImmutable {
    class NumArray {
        private int[] cumSum;
        public NumArray(int[] nums) {
            cumSum = new int[nums.length];
            cumSum[0] = nums[0];
            for (int i=1; i<nums.length; i++) {
                cumSum[i] = cumSum[i-1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            try {
                return cumSum[right] - cumSum[left-1];
            }
            catch (IndexOutOfBoundsException e) {
                return cumSum[right];
            }
        }
    }
}

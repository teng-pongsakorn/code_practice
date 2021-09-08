package easy;

public class SortArrayByParityII {
    public int[] sortArrayByParityII_inplace(int[] nums) {
        int iOdd = 1, iEven = 0;
        while (iOdd < nums.length && iEven < nums.length - 1) {
            if (nums[iEven] % 2 == 0) {
                iEven += 2;
            } else if (nums[iOdd] % 2 == 1) {
                iOdd += 2;
            } else {
                int tmp = nums[iEven];
                nums[iEven] = nums[iOdd];
                nums[iOdd] = tmp;
                iEven += 2;
                iOdd += 2;
            }
        }
        return nums;
    }
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int iOdd = 1;
        int iEven = 0;
        for (int num: nums) {
            if (num % 2 == 0) {
                result[iEven] = num;
                iEven += 2;
            } else {
                result[iOdd] = num;
                iOdd += 2;
            }
        }
        return result;
    }
}

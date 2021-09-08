package easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int val: nums) {
            if (k == 0 || val > nums[k-1]) {
                nums[k++] = val;
            }
        }
        return k;
    }

    public int removeDuplicates_1st(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[k+1] = nums[i];
                k++;
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{1,1,1};
        System.out.println(obj.removeDuplicates(nums) + ": " + Arrays.toString(nums));
        nums = new int[]{1,1,2};
        System.out.println(obj.removeDuplicates(nums) + ": " + Arrays.toString(nums));
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates(nums) + ": " + Arrays.toString(nums));
    }
}

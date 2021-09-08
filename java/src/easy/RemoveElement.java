package easy;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int n: nums) {
            if (n != val) {
                nums[k++] = n;
            }
        }
        return k;
    }

    public static void main(String[] args) {

        RemoveElement obj = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(obj.removeElement(nums, val) + ": " + Arrays.toString(nums));

        nums = new int[] {0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println(obj.removeElement(nums, val) + ": " + Arrays.toString(nums));
    }
}

package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumberDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]);
            nums[val-1] = -1*Math.abs(nums[val-1]);
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
    public List<Integer> findDisappearedNumbers_v2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] found = new boolean[nums.length+1];
        for (int n: nums) {
            found[n] = true;
        }
        for (int i=1; i<found.length; i++) {
            if (!found[i]) {
                result.add(i);
            }
        }
        return result;
    }
    public List<Integer> findDisappearedNumbers_v1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int val = 1;
        while (i < nums.length) {
            if (val == nums[i]) {
                val++;
                i++;
            } else if (val > nums[i]) {
                i++;
            } else {
                result.add(val);
                val++;
            }
        }
        while (val <= nums.length) {
            result.add(val++);
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllNumberDisappearedInArray solve = new FindAllNumberDisappearedInArray();
        int[] nums;

        nums = new int[] {4,3,2,7,8,2,3,1};
        System.out.println(solve.findDisappearedNumbers(nums)); // [5, 6]

        nums = new int[] {1, 1};
        System.out.println(solve.findDisappearedNumbers(nums)); // [2]

        nums = new int[] {2,2,2,2,2,2,2};
        System.out.println(solve.findDisappearedNumbers(nums)); // [1,3,4,5,6,7]
    }
}

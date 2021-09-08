package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num: nums) {
            if (!visited.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate_v1(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(ContainDuplicate.containsDuplicate(nums));
        nums = new int[]{1,2,3,4};
        System.out.println(ContainDuplicate.containsDuplicate(nums));
        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(ContainDuplicate.containsDuplicate(nums));
    }
}

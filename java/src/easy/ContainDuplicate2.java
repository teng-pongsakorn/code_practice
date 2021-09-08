package easy;

import java.util.*;

public class ContainDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate_v2(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int i=0, j=0;
        while (j-i <= k && j<nums.length) {
            int val = nums[j];
            if (numCount.containsKey(val)) {
                return true;
            }
            numCount.put(val, numCount.getOrDefault(val, 0)+1);
            j++;
        }
//        System.out.println(numCount);
        while (j < nums.length) {
            // increment left end
            numCount.put(nums[i], numCount.get(nums[i])-1);
            i++;
            // add right end
            int val = numCount.getOrDefault(nums[j], 0)+1;
            if (val == 2) {
                return true;
            } else {
                numCount.put(nums[j], val);
            }
            j++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(ContainDuplicate2.containsNearbyDuplicate(nums, 3));
        nums = new int[]{1,0,1,1};
        System.out.println(ContainDuplicate2.containsNearbyDuplicate(nums, 1));
        nums = new int[]{1,2,3,1,2,3};
        System.out.println(ContainDuplicate2.containsNearbyDuplicate(nums, 2));
        nums = new int[] {99,99};
        System.out.println(ContainDuplicate2.containsNearbyDuplicate(nums, 2));
        nums = new int[] {1};
        System.out.println(ContainDuplicate2.containsNearbyDuplicate(nums, 1));
    }
}

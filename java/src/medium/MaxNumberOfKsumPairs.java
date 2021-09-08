package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKsumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int start=0, end=nums.length-1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == k) {
                count++;
                start++;
                end--;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
    public int maxOperations_v1(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int pair = k - num;
            int pairCount = map.getOrDefault(pair, 0);
            if (pairCount > 0) {
                map.put(pair, pairCount-1);
                count++;
            } else {
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxNumberOfKsumPairs sol = new MaxNumberOfKsumPairs();
        int[] nums;
        int k;

        // 2
        nums = new int[] {1,2,3,4};
        k = 5;
        System.out.println(sol.maxOperations(nums, k));

        // 1
        nums = new int[] {3,1,3,4,3};
        k = 6;
        System.out.println(sol.maxOperations(nums, k));

        // 4
        nums = new int[] {5,5,5,5,5,5,5,5,5};
        k = 10;
        System.out.println(sol.maxOperations(nums, k));
    }
}

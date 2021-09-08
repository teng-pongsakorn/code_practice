package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int prod = 1;
        int i=0, j=0;
        while (j < nums.length) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i++];
            }
            count += j-i+1;
            j++;
        }

        return count;
    }
    public int numSubarrayProductLessThanK_v2(int[] nums, int k) {
        if (k<=1) return 0;
        int count = 0;
        double logK = Math.log((double) k);

        return count;
    }
    public int numSubarrayProductLessThanK_v1(int[] nums, int k) {
        if (k<=1) return 0;
        int count = 0;
        int cumprod = 1;
        Map<Integer, Integer> cumprodCount = new HashMap<>();
        cumprodCount.put(cumprod, 1);
        for (int num: nums) {
            cumprod *= num;
            int lowerbound = cumprod / k;
            System.out.println("lowerbound=" + lowerbound + " - cumprodCount: " + cumprodCount);
            for (Map.Entry<Integer, Integer> item: cumprodCount.entrySet()) {
                if (lowerbound < item.getKey()) {
                    System.out.println("=".repeat(5) + " lowerbound:" + lowerbound + " key:" + item.getKey());
                    count += item.getValue();
                }
            }
            cumprodCount.put(cumprod, cumprodCount.getOrDefault(cumprod, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubarrayProductLessThanK sol = new SubarrayProductLessThanK();
        int[] nums;
        int k;

        // 8
        nums = new int[]{10,5,2,6};
        k = 100;
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));

        // 0
        nums = new int[]{1,2,3};
        k = 0;
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));

        // 0
        nums = new int[]{10,5,2,6,44,223,23,98,23,123,98,77,123};
        k = 1;
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));

        // 42
        nums = new int[] {10,5,2,6,4,3,1,1,1,1,2,9,1,1,1,8,3,23,9,7,5};
        k = 10;
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));

        // 33
        nums = new int[] {9,4,3,2,6,2,5,4,2,6,7};
        k = 144;
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));


    }
}

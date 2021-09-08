package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumsum = 0;
        Map<Integer, Integer> subarraySumCount = new HashMap<>();
        subarraySumCount.put(cumsum, 1);
        for (int i=0; i<nums.length; i++) {
            cumsum += nums[i];
            if (subarraySumCount.containsKey(cumsum - k)) {
                count += subarraySumCount.get(cumsum-k);
            }
            subarraySumCount.put(cumsum, subarraySumCount.getOrDefault(cumsum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK sol = new SubArraySumEqualsK();
        int[] nums;
        int k;
        System.out.println(Arrays.asList(2,2,6,0,1));
        // 2
        nums = new int[]{1,1,1};
        k = 2;
        System.out.print(sol.subarraySum(nums, k) + ", ");

        // 2
        nums = new int[]{1,2,3};
        k = 3;
        System.out.print(sol.subarraySum(nums, k) + ", ");

        // 6
        nums = new int[]{1,2,3,1,1,1,2,1,3,1};
        k = 3;
        System.out.print(sol.subarraySum(nums, k) + ", ");

        // 0
        nums = new int[]{1};
        k = 0;
        System.out.print(sol.subarraySum(nums, k) + ", ");

        // [-1,-1,1] , k=0, expect 1
        nums = new int[]{-1,-1,1};
        k = 0;
        System.out.print(sol.subarraySum(nums, k) + ", ");
    }
}

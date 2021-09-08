package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int cumsum = 0;
        Map<Integer, Integer> cumsumCount = new HashMap<>();
        cumsumCount.put(cumsum, 1);
        for (int num: nums) {
            cumsum = (cumsum + (num % k) + k) % k;   // add k to deal with negative modulo
            Integer found = cumsumCount.get(cumsum);
            if (found != null) {
                count += found;
                cumsumCount.put(cumsum, found+1);
            } else {
                cumsumCount.put(cumsum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumDivisibleByK sol = new SubarraySumDivisibleByK();
        int[] nums;
        int k;

        // expect 7
        nums = new int[]{4,5,0,-2,-3,1};
        k = 5;
        System.out.println(sol.subarraysDivByK(nums, k));

        // expect 0
        nums = new int[]{5};
        k = 9;
        System.out.println(sol.subarraysDivByK(nums, k));

        // expect 1
        nums = new int[] {7, 4, -10};
        k = 5;
        System.out.println(sol.subarraysDivByK(nums, k));
    }
}

package medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int cumsum = 0;
        Map<Integer, Integer> cumsum2LeftMostIndex = new HashMap<>();
        cumsum2LeftMostIndex.put(cumsum, -1);  // starting point zero cumsum without any elements (at index -1, first element at index 0)
        for (int j=0; j<nums.length; j++) {
            cumsum = (cumsum + nums[j]) % k;
            if (cumsum2LeftMostIndex.containsKey(cumsum)) {
                int i = cumsum2LeftMostIndex.get(cumsum);
                if (j - i >= 2) {
                    return true;
                }
            } else {
                cumsum2LeftMostIndex.put(cumsum, j);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum sol = new ContinuousSubarraySum();
        int[] nums;
        int k;

//        Input: nums = [23,2,4,6,7], k = 6
//        Output: true
        nums = new int[]{23,2,4,6,7};
        k = 6;
        System.out.println(sol.checkSubarraySum(nums, k) == true);

//        Input: nums = [23,2,6,4,7], k = 6
//        Output: true
        nums = new int[]{23,2,6,4,7};
        k = 6;
        System.out.println(sol.checkSubarraySum(nums, k) == true);

//        Input: nums = [23,2,6,4,7], k = 13
//        Output: false
        nums = new int[]{23,2,6,4,7};
        k = 13;
        System.out.println(sol.checkSubarraySum(nums, k) == false);
    }
}

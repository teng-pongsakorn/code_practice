package medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXtoZero {

    // two pointer
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num: nums) target += num;

        if (target < 0) return -1;
        if (target == 0) return nums.length;
        int result = -1;
        int i=0, j=0, cumsum=0;
        while (j < nums.length) {
            cumsum += nums[j];
            while (cumsum > target) {
                cumsum -= nums[i++];
            }
            if (cumsum == target) {
                result = Math.max(result, j-i+1);
            }
            j++;
        }
        return result == -1 ? -1 : nums.length - result;
    }
    public int minOperations_v2(int[] nums, int x) {
        int target = -x;
        for (int num: nums) target += num;

        if (target == 0) return nums.length;
        int cumsum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(cumsum, -1);
        int result = Integer.MIN_VALUE;
        for (int j=0; j<nums.length; j++) {
            cumsum += nums[j];
            if (map.containsKey(cumsum - target)) {
                result = Math.max(result, j - map.get(cumsum-target));
            }
            map.put(cumsum, Math.min(j, map.getOrDefault(cumsum, nums.length)));
        }
        return result == Integer.MIN_VALUE ? -1 : nums.length - result;
    }
    public int minOperations_v1(int[] nums, int x) {
        int cumsum = 0;
        Map<Integer, Integer> cumsumL2index = new HashMap<>();
        cumsumL2index.put(cumsum, 0);
        for (int i=0; i<nums.length; i++) {
            cumsum += nums[i];
            cumsumL2index.put(cumsum, i+1);
        }
        int minCount = cumsumL2index.containsKey(x) ? cumsumL2index.get(x) : Integer.MAX_VALUE;
        cumsum = 0;
        for (int i=nums.length-1; i>=0; i--) {
            cumsum += nums[i];
            if (cumsum > x) break;
            int rightCount = nums.length - i;
            Integer leftCount = cumsumL2index.get(x - cumsum);
            if (leftCount != null && (leftCount + rightCount <= nums.length)) {
                minCount = Math.min(minCount, rightCount + leftCount);
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    public int minOperations_brute(int[] nums, int x) {
        return reduce(nums, 0, nums.length-1, x);
    }

    private int reduce(int[] nums, int left, int right, int x) {
        if (x == 0) return 0;
        if (right<left || (nums[left] > x && nums[right] > x) || x < 0) {
            return -1;
        }
        if (nums[left] > x) {
            return 1 + reduce(nums, left, right-1, x-nums[right]);
        }
        if (nums[right] > x) {
            return 1 + reduce(nums, left+1, right, x - nums[left]);
        }
        int leftResult = 1 + reduce(nums, left+1, right, x - nums[left]);
        int rightResult = 1 + reduce(nums, left, right-1, x-nums[right]);
        return Math.min(leftResult, rightResult);
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXtoZero sol = new MinimumOperationsToReduceXtoZero();
        // 2
        int[] nums = {1,1,4,2,3};
        int x = 5;
        System.out.println(sol.minOperations(nums, x));

        // -1
        nums = new int[] {5,6,7,8,9};
        x = 4;
        System.out.println(sol.minOperations(nums, x));

        // 5
        nums = new int[] {3,2,20,1,1,3};
        x = 10;
        System.out.println(sol.minOperations(nums, x));

        nums = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        x = 100;
        System.out.println(sol.minOperations(nums, x));

        // 1
        nums = new int[] {5,2,3,1,1};
        x = 5;
        System.out.println(sol.minOperations(nums, x));

    }
}

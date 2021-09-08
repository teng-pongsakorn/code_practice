package medium;

public class MinimumSizeSubarraySum {

//    public int minSubArrayLen(int target, int[] nums) {
//        Map<Integer, Integer> aiMap = new HashMap<>();
//        aiMap.put(0, -1);
//        int aj = 0;
//        int minLen = Integer.MAX_VALUE;
//        for (int i=0; i<nums.length; i++) {
//            aj += nums[i];
//            aiMap.put(aj, i);
//            if (aiMap.containsKey(aj - target)) {
//                int len = i - aiMap.get(aj - target);
//                minLen = Math.min(len, minLen);
//            }
//        }
//        return minLen == Integer.MAX_VALUE ? 0 : minLen;
//    }
    public int minSubArrayLen(int target, int[] nums) {
//        int minLen = Integer.MAX_VALUE;
//        for (int i=1; i<nums.length; i++) {
//            nums[i] += nums[i-1];
//        }
//        int i = 0;
//        int j = -1;
//        while (i < nums.length && nums[i] < target) {
//            i++;
//        }
//        if (nums[i] >= target) {
//            minLen = i - j;
//            j++;
//        }
//        while (i < nums.length) {
//            while (i < nums.length && nums[i] - nums[j] < target) {
//                i++;
//            }
//            if (nums[i] - nums[j] >= target) {
//                minLen = Math.min(minLen, i - j);
//            }
//            j++;
//        }
        int minLen = Integer.MAX_VALUE;
        int[] cumsum = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            cumsum[i+1] = cumsum[i] + nums[i];
        }
        int i = 0;
        int j = 0;
        while (j < cumsum.length) {
            while (j < cumsum.length && cumsum[j] - cumsum[i] < target) {
                j++;
            }
            if (j < cumsum.length) {
                minLen = Math.min(minLen, j-i);
                i++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public int minSubArrayLen_nlogn(int target, int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int lo = 1, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(nums, mid, target)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return isPossible(nums, lo, target) ? lo : 0;
    }

    private boolean isPossible(int[] nums, int size, int target) {
        int sum = nums[size-1];
        if (sum >= target) return true;
        int i=size;
        while (i < nums.length) {
            sum = nums[i] - nums[i - size];
            if (sum >= target) return true;
            i++;
        }
        return false;
    }
public static void main(String[] args) {

}
}

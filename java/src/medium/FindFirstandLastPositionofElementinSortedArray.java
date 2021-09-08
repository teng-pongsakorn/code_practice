package medium;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange_v2(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) return result;
        // find left bound
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (target == nums[lo]) {
            result[0] = lo;
        } else {
            return result;
        }
        // find right bound
        lo = 0;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        result[1] = hi;
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1,-1};
        // find lower bound
        int lo=0, hi=nums.length-1;
        while (lo+1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                hi = mid;
            }
        }
        int leftAnswer;
        if (nums[lo]==target) {
            leftAnswer = lo;
        } else if (nums[hi] == target) {
            leftAnswer = hi;
        } else {
            leftAnswer = -1;
        }

        if (leftAnswer != -1) {
            lo=0; hi=nums.length-1;
            while (lo+1 < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > target) {
                    hi = mid;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    lo = mid;
                }
            }
            if (nums[hi] == target) {
                return new int[] {leftAnswer, hi};
            }
            return new int[] {leftAnswer, lo};
        }

        return new int[] {-1, -1};
    }
}

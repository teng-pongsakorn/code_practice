package medium;

import java.util.Arrays;

public class FindtheDuplicateNumber {

//    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//    There is only one repeated number in nums, return this repeated number.
//    You must solve the problem without modifying the array nums and uses only constant extra space.
    public int findDuplicateNspace(int[] nums) {
        boolean[] isFound = new boolean[nums.length];
        for (int num: nums) {
            if (isFound[num]) {
                return num;
            } else {
                isFound[num] = true;
            }
        }
        return -1;
    }
    public int findDuplicate_v2(int[] nums) {
        int result = -1;
        for (int num: nums) {
            if (nums[Math.abs(num)-1] < 0) {
                result = Math.abs(num);
                break;
            } else {
                nums[Math.abs(num)-1] *= -1;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        return result;
    }

    public int findDuplicate_v3(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int n = nums[0];
            int tmp = nums[n];
            nums[n] = n;
            nums[0] = tmp;
        }
        return nums[0];
    }

    public int findDuplicate_v4(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        slow = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public int findDuplicate_v5(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid + 1 > nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    public int findDuplicate(int[] nums) {
        // find max nums
        int maxNum = 0;
        for (int num: nums) {
            maxNum = num > maxNum ? num : maxNum;
        }

        // find max bits
        int maxBits = 0;
        while (maxNum > 0) {
            maxNum /= 2;
            maxBits++;
        }

        // check for each bit position if bit count > base count
        // if that's the case -> accumulate that bit position to the result
        int n = nums.length - 1;
        int result = 0;
        for (int bit=0; bit<=maxBits; bit++) {
            int mask = (1 << bit);
            int baseCount = 0;
            int bitCount = (mask & nums[0]) > 0 ? 1 : 0;
            // base count & bit count
            for (int i=1; i<=n; i++) {
                if ((i & mask) > 0) baseCount++;
                if ((nums[i] & mask) > 0) bitCount++;
            }
            if (bitCount > baseCount) {
                result |= mask;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber sol = new FindtheDuplicateNumber();
        int[] nums;

        nums = new int[] {1,3,4,2,2};
        System.out.println(sol.findDuplicate(nums) == 2);

        nums = new int[] {3,1,3,4,2};
        System.out.println(sol.findDuplicate(nums) == 3);

        nums = new int[] {1,1};
        System.out.println(sol.findDuplicate(nums) == 1);

        nums = new int[] {1,1,2};
        System.out.println(sol.findDuplicate(nums) == 1);

        nums = new int[] {1,1,1,1,1};
        System.out.println(sol.findDuplicate(nums) == 1);

        nums = new int[] {2,2,2,2,2};
        System.out.println(sol.findDuplicate(nums) == 2);

        nums = new int[] {3,3,3,3,3};
        System.out.println(sol.findDuplicate(nums) == 3);

        nums = new int[] {4,4,4,4,4};
        System.out.println(sol.findDuplicate(nums) == 4);

    }
}

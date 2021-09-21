package medium;

import java.util.Arrays;
import java.util.LinkedList;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] max = {0};
        LinkedList<Integer> current = new LinkedList<>();
        int[] memo = new int[nums.length];
        dfs(nums, nums.length-1, memo, max);
//        dfs_brute(nums, 0, current, max);
        System.out.println(Arrays.toString(memo));
        return max[0];
    }

    private int dfs(int[] nums, int i, int[] memo, int[] max) {
        if (i < 0) return 0;
        if (memo[i] > 0) return memo[i];
        int result = 1;
        for (int j=i+1; j<nums.length; j++) {
            if (nums[i] < nums[j]) {
                result = Math.max(result, 1+dfs(nums, j, memo, max));
            }
        }
        max[0] = result > max[0] ? result : max[0];
        memo[i] = result;
        dfs(nums, i-1, memo, max);
        return result;
    }

    private void dfs_brute(int[] nums, int idx, LinkedList<Integer> current, int[] max) {
        if (current.size() > 1 && current.getLast() <= current.get(current.size()-2)) return;
        if (idx == nums.length) {
            max[0] = Math.max(max[0], current.size());
            return;
        }
        for (int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            dfs_brute(nums, i+1, current, max);
            current.removeLast();
        }
    }

    public int lengthOfLIS_dp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = dp[i] > maxLen ? dp[i] : maxLen;
        }
        return maxLen;
    }

    class MaxBit {
        int[] bit;
        int base;

        public MaxBit(int size, int base) {
            this.bit = new int[size + 1];
            this.base = base;
        }

        public int getMaxLength(int num) {
//            System.out.println("getMaxLen: num=" + num);
            int ans = 0;
            int idx = num + base;
            while (idx > 0) {
//                System.out.println("getMaxLen: idx=" + idx);
                ans = Math.max(ans, bit[idx]);
                idx -= (idx & (-idx));
            }
            return ans;
        }

        public void updateMaxLen(int num, int length) {
            int idx = num + base;
            while (idx < bit.length) {
//                System.out.println("updateMaxLen: idx=" + idx);
                bit[idx] = Math.max(length, bit[idx]);
                idx += (idx & (-idx));
            }
        }
    }
    public int lengthOfLIS_maxbit(int[] nums) {
        MaxBit mb = new MaxBit(20001, 10001);
        for (int num: nums) {
            int len = mb.getMaxLength(num - 1);
            mb.updateMaxLen(num, len+1);
        }
        return mb.getMaxLength(10000);
    }


    public int lengthOfLIS_nlogn(int[] nums) {
//        System.out.println("nums: " + Arrays.toString(nums));
        int[] sub = new int[nums.length];
        int i = 0;   // last index of increasing sequence representing the longest size
        for (int num: nums) {
//            System.out.println(Arrays.toString(sub));
            if (i == 0 || sub[i-1] < num) {
                sub[i++] = num;
            } else {
                // binary search for the first sub[i] >= num
                int lo = 0, hi = i-1;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (sub[mid] < num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                sub[lo] = num;
            }
        }
//        System.out.println();
        return i;
    }
    public int lengthOfLIS_nSqrt(int[] nums) {
        int maxLen = 1;
        int[] lengths = new int[nums.length];
        int n = nums.length;
        lengths[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] < nums[j]) {
                    lengths[i] = Math.max(lengths[j], lengths[i]);
                }
            }
            lengths[i]++;
            if (lengths[i] > maxLen) {
                maxLen = lengths[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();

        System.out.println(sol.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(sol.lengthOfLIS(new int[] {0,1,0,3,2,3}));
        System.out.println(sol.lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
    }
}

package medium;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        for (int i=0; i<n-1; i++) {
            dp1[i+2] = Math.max(dp1[i+1], dp1[i] + nums[i]);
            dp2[i+2] = Math.max(dp2[i+1], dp2[i] + nums[i+1]);
        }
        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
    public int rob_v1(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<String, Integer> memo = new HashMap<>();
        return Math.max(goRob(nums, 0, nums.length-2, memo), goRob(nums, 1, nums.length-1, memo));
    }

    private int goRob(int[] nums, int start, int end, Map<String, Integer> memo) {
        String key = start + "," + end;
        if (memo.containsKey(key)) return memo.get(key);
        if (start == end) return nums[start];
        if (start > end) return 0;
        int result = Math.max(goRob(nums, start, end-1, memo), goRob(nums, start, end-2, memo) + nums[end]);
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        HouseRobberII sol = new HouseRobberII();
        System.out.println(sol.rob(new int[] {2,3,2})==3);
        System.out.println(sol.rob(new int[] {1,2,3,1})==4);
        System.out.println(sol.rob(new int[] {1,2,3})==3);
        System.out.println(sol.rob(new int[] {1})==1);
        System.out.println(sol.rob(new int[] {1,0})==1);
        System.out.println(sol.rob(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99})==2500);
    }
}

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return ksum(nums, target, 0, 4);
    }

    private List<List<Integer>> ksum(int[] nums, int target, int start, int k) {
//        System.out.println("target:" + target + " start:" + start + " k:" + k);
        List<List<Integer>> result = new ArrayList<>();
        if (start == nums.length || nums[start]*k > target || nums[nums.length-1] * k < target) {
            return result;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i=start; i<nums.length; i++) {

            if (i==start || nums[i] != nums[i-1]) {
                for (List<Integer> subset: ksum(nums, target-nums[i], i+1, k-1)) {
                    List<Integer> newSubset = new ArrayList<>(Arrays.asList(nums[i]));
                    newSubset.addAll(subset);
                    result.add(newSubset);
                    System.out.println("result:" + result);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int lo = start, hi = nums.length-1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo-1])) {
                lo++;
            } else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi+1])) {
                hi--;
            } else {
                result.add(Arrays.asList(nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum_v1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            for (int j=i+1; j<nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                if (nums[i] + nums[j] > target) {
                    break;
                }
                // 2 sum
                int lo = j+1, hi = nums.length-1;
                int target2sum = target - nums[i] - nums[j];
                System.out.println("a:" + nums[i] + " b:" + nums[j] + " twoSum: " + Arrays.toString(nums));
                while (lo < hi) {
                    System.out.println("lo:" + nums[lo] + " hi:" + nums[hi]);
                    int sum = nums[lo] + nums[hi];
                    if (sum < target2sum) {
                        lo++;
                        while (lo < hi && nums[lo] == nums[lo-1]) {
                            lo++;
                        }
                    } else if (sum > target2sum) {
                        hi--;
                        while (lo < hi && nums[hi] == nums[hi+1]) {
                            hi--;
                        }
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo] == nums[lo-1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi+1]) {
                            hi--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        int[] nums;
        int target;

        nums = new int[] {1,0,-1,0,-2,2};
        target = 0;
        System.out.println(sol.fourSum(nums, target));
        System.out.println("-".repeat(30));

        nums = new int[] {2,2,2,2,2};
        target = 8;
        System.out.println(sol.fourSum(nums, target));
        System.out.println("-".repeat(30));

        nums = new int[] {1,0,-1,0,-2,2,0,-1,0,-2,2,0,-1,0,-2,2,0,-1,0,-2,2};
        target = 0;
        System.out.println(sol.fourSum(nums, target));
        System.out.println("-".repeat(30));
    }
}

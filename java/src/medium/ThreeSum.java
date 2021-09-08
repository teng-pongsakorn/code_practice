package medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Integer prev = null;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) break;
            int num = nums[i];
            if (prev == null || num != prev) {
                // two sum: target = -num;
                int start = i+1, end = nums.length-1;
                int target = -num;
                while (start < end) {
                    if (nums[start] + nums[end] < target) {
                        start++;
                    } else if (nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        result.add(Arrays.asList(num, nums[start], nums[end]));
                        while (start < nums.length-1 && nums[start] == nums[start+1]) {
                            start++;
                        }
                        while (end > i+1 && nums[end] == nums[end-1]) {
                            end--;
                        }
                        start++;
                        end--;
                    }
                }
            }
            prev = num;
        }
        return result;
    }

    public List<List<Integer>> threeSum_v1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> visited = new HashSet<>();
        int target = 0;
        Set<List<Integer>> result = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (!visited.contains(nums[i])) {
                findAllTwoSum(i, target - nums[i], nums, result);
            }
            visited.add(nums[i]);
        }
        return toList(result);
    }

    private List<List<Integer>> toList(Set<List<Integer>> result) {
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> x: result) {
            list.add(x);
        }
        return list;
    }

    private void findAllTwoSum(int currentIndex, int target, int[] nums, Set<List<Integer>> result) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=currentIndex+1; i<nums.length; i++) {
//            if (i == currentIndex) continue;
            if (map.containsKey(target - nums[i])) {
                List<Integer> list = Arrays.asList(nums[currentIndex], target-nums[i], nums[i]);
                result.add(list);
            }
            map.put(nums[i], i);
        }
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        int[] nums;

//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
        nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(sol.threeSum(nums));

        nums = new int[] {0};
        System.out.println(sol.threeSum(nums));

        nums = new int[] {1,2,3};
        System.out.println(sol.threeSum(nums));

        nums = new int[] {1,2,-3};
        System.out.println(sol.threeSum(nums));
    }
}

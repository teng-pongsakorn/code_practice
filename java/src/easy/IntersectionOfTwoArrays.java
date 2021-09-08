package easy;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            if (!set.contains(num) && find(nums2, num)) {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i=0;
        for (int num: set) {
            result[i++] = num;
        }
        return result;
    }

    private boolean find(int[] nums, int target) {
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target;
    }

    public int[] intersection_v2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (!set.add(num)) {
                list.add(num);
            }
            set.remove(num);
        }
        return list.stream().mapToInt(Number::intValue).toArray();
    }
    public int[] intersection_v1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> set2 = arrayToSet(nums2);
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        return set1.stream().mapToInt(Number::intValue).toArray();
    }

    private Set<Integer> arrayToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();
        int[] num1 = new int[]{1,2,3,4,5};
        int[] num2 = new int[]{4,5,6,7,8};
        System.out.println(Arrays.toString(solution.intersection(num1, num2)));
    }
}

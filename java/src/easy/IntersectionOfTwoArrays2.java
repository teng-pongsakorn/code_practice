package easy;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int idx1=0, idx2=0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                list.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums2[idx2] < nums1[idx1]) {
                idx2++;
            }
        }
        return list.stream().mapToInt(Number::intValue).toArray();
    }

    public int[] intersect_v1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCount = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums1) {
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
        }
        for (int num: nums2) {
            Integer putReturn = numCount.put(num, numCount.getOrDefault(num, 0)-1);
            if (putReturn != null && putReturn > 0) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays2 solve = new IntersectionOfTwoArrays2();

        int[] nums1 = {1,2,4,5,9,5};
        int[] nums2 = {5, 3, 9, 7, 5};
        System.out.println(Arrays.toString(nums1) + " intersect " + Arrays.toString(nums2));
        System.out.println(Arrays.toString(solve.intersect(nums1, nums2)));
    }
}

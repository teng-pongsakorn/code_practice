package medium;

import java.util.Arrays;

public class SortanArray {
    public int[] sortArray(int[] nums) {
        return merge_sort(nums, 0, nums.length-1);
    }

    private int[] merge_sort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] {nums[start]};
        }
        int pivot = start + (end - start) / 2;
        int[] left = merge_sort(nums, start, pivot);
        int[] right = merge_sort(nums, pivot+1, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
            }
        }
        while (l < left.length) {
            arr[i++] = left[l++];
        }
        while (r < right.length) {
            arr[i++] = right[r++];
        }
        return arr;
    }

    public static void main(String[] args) {
        SortanArray sol = new SortanArray();

        System.out.println(Arrays.toString(sol.sortArray(new int[] {1,2,3,4,5,6})));
        System.out.println(Arrays.toString(sol.sortArray(new int[] {1,6,5,4,5,6})));
        System.out.println(Arrays.toString(sol.sortArray(new int[] {6,5,4,3,2,1})));
        System.out.println(Arrays.toString(sol.sortArray(new int[] {1,1,1,1,1,2})));
    }
}

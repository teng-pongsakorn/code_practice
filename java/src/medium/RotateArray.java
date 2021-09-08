package medium;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate_v1(int[] nums, int k) {
        k %= nums.length;
        if (k==0 || nums.length==1) return;
        swap(nums, nums.length-1, k);
    }

    private void swap(int[] nums, int lastIndex, int k) {
        System.out.println("lastIndex:" + lastIndex + " k:" + k);
        if (lastIndex +1 == k) return;
        int process;
        for (process=0; process<k && lastIndex >= k; process++) {
            int tmp = nums[lastIndex];
            nums[lastIndex] = nums[lastIndex-k];
            nums[lastIndex-k] = tmp;
            lastIndex--;
        }
        int remain = k - process;
        if (remain > 0) {
            k = remain;
        }
        swap(nums, lastIndex, k);
    }

    public void rotate_naive(int[] nums, int k) {
        if (k == 0 || nums.length==1) return;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int iSource = nums.length - (k % nums.length);
        for (int i=0; i<nums.length; i++) {
            nums[i] = copy[iSource];
            iSource = (iSource + 1) % nums.length;
        }

    }
}

package easy;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge_v2(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m-1;
        int tail2 = n-1;
        int pos = m + n - 1;
        while (tail2 >= 0 && tail1 >= 0) {
            nums1[pos--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }
        while (tail2 >= 0) {
            nums1[pos--] = nums2[tail2--];
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int len = m + n - 1;
        int i = m-1;
        while (len >= n) {
            nums1[len] = nums1[i];
            len--;
            i--;
        }
        int pos = 0;
        int idx1 = n;
        int idx2 = 0;
//        System.out.println(Arrays.toString(nums1) + "------------------");
        while (pos < nums1.length) {
            if (idx1 < nums1.length && idx2 < n) {
                if (nums1[idx1] < nums2[idx2]) {
                    nums1[pos] = nums1[idx1++];
                } else {
                    nums1[pos] = nums2[idx2++];
                }
                pos++;
            } else if (idx1 < nums1.length) {
                while (idx1 < nums1.length) {
                    nums1[pos++] = nums1[idx1++];
                }
            } else {
                while (idx2 < n) {
                    nums1[pos++] = nums2[idx2++];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        MergeSortedArrays.merge_v2(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{1, 2, 3, 5, 6, 0};
        num2 = new int[]{3};
        m = 5;
        n = 1;
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
        MergeSortedArrays.merge_v2(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }
}

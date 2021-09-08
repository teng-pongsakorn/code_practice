package easy;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i=result.length-1; i>=0; i--) {
            if (nums[left]*nums[left] > nums[right]*nums[right]) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public int[] sortedSquares_v3(int[] nums) {
        int iNeg = -1, iPos = nums.length;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0) {
                iNeg = i;
            } else {
                iPos = i;
                break;
            }
        }
        int[] result = new int[nums.length];
        int idx = 0;
        while (iNeg >= 0 && iPos < nums.length) {
            if (-nums[iNeg] < nums[iPos]) {
                result[idx++] = nums[iNeg] * nums[iNeg];
                iNeg--;
            } else {
                result[idx++] = nums[iPos] * nums[iPos];
                iPos++;
            }
        }
        while (iNeg >= 0) {
            result[idx++] = nums[iNeg] * nums[iNeg];
            iNeg--;
        }
        while (iPos < nums.length) {
            result[idx++] = nums[iPos] * nums[iPos];
            iPos++;
        }
        return result;
    }

    public int[] sortedSquares_v2(int[] nums) {
        if (nums[0] >= 0) {
            for (int i=0; i<nums.length; i++) {
                nums[i] *= nums[i];
            }
            return nums;
        } else if (nums[nums.length - 1] <= 0) {
            int left=0, right=nums.length-1;
            while (left <= right) {
                int tmp = nums[left] * nums[left];
                nums[left] = nums[right] * nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
            return nums;
        }
        int[] result = new int[nums.length];
        int idx=0, iNeg=0, iPos=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 0) {
                iPos = i;
                iNeg = i-1;
                break;
            }
        }
        while (iNeg >= 0 && iPos < nums.length) {
            if (-nums[iNeg] < nums[iPos]) {
                result[idx++] = nums[iNeg]*nums[iNeg];
                iNeg--;
            } else {
                result[idx++] = nums[iPos] * nums[iPos];
                iPos++;
            }
        }
        while (iNeg >= 0) {
            result[idx++] = nums[iNeg] * nums[iNeg];
            iNeg--;
        }
        while (iPos < nums.length) {
            result[idx++] = nums[iPos] * nums[iPos];
            iPos++;
        }
        return result;
    }

    public int[] sortedSquares_naive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

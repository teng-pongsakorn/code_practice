package easy;

import java.util.*;

public class TwoSum {

    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        int[] result = {};
        for (int i=0; i<numbers.length-1; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            int lo=i+1, hi=numbers.length-1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (numbers[mid] < num2) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (numbers[lo] == num2) {
                result = new int[] {i+1, lo+1};
                break;
            }
        }
        return result;
    }
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> num2index = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (num2index.containsKey(target - numbers[i])) {
                return new int[]{num2index.get(target-numbers[i]), i};
            }
            num2index.put(numbers[i], i);
        }
        return null;
    }
    public static int[] twoSum_v2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            } else if (numbers[j] + numbers[i] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        return new int[]{};
    }

    private static int findIndex(int[] numbers, int idx, int target) {
        for (int i=idx+1; i<numbers.length; i++) {
            if (numbers[i]+numbers[idx] == target) return i;
        }
        return -1;
    }

    public static int[] twoSum_v1(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i=0; i<numbers.length ;i++) {
//            int j = findIndex(numbers, i, target);
            int j = Arrays.binarySearch(numbers, i+1, numbers.length, target-numbers[i]);
            if (j >= 0) {
                return new int[]{i+1, j+1};
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(TwoSum.twoSum(numbers, 9)));
        numbers = new int[] {2,3,4};
        System.out.println(Arrays.toString(TwoSum.twoSum(numbers, 6)));
    }
}

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
        return nums;
    }

    public static void printArrays(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Element " + i + " contents " + nums[i]);
        }
    }

    public static int[] sortIntegers(int[] nums) {

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        boolean flag = true;
        int tmp;
        while (flag) {
            flag = false;
            for (int i = 0; i < sortedNums.length-1; i++) {
                if (sortedNums[i] < sortedNums[i+1]) {
                    tmp = sortedNums[i];
                    sortedNums[i] = sortedNums[i+1];
                    sortedNums[i+1] = tmp;
                    flag = true;
                }
            }
        }

        return sortedNums;
    }
}

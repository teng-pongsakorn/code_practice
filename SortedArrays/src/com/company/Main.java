package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = SortedArray.getIntegers(5);
        SortedArray.printArrays(arr);
        arr = SortedArray.sortIntegers(arr);
        SortedArray.printArrays(arr);
    }
}

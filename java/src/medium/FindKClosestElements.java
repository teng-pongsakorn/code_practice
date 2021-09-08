package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x - arr[mid] <= arr[mid+k] - x) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i= lo; i<lo+k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements_v1(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int leftK = Math.max(lo - k, 0);
        int rightK = Math.min(arr.length-1, lo + k);
        System.out.println(Arrays.toString(arr) + " k=" + k + " x=" + x);
        System.out.println("left:" + leftK + " right:" + rightK);
        while (rightK - leftK + 1 > k) {
            if (Math.abs(arr[rightK] - x) < Math.abs(arr[leftK] - x)) {
                leftK++;
            } else {
                rightK--;
            }
        }
        List<Integer> result = new LinkedList<>();
        for (int i=leftK; i<=rightK; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements sol = new FindKClosestElements();
        int[] arr;
        int k, x;

//        Input: arr = [1,2,3,4,5], k = 4, x = 3
//        Output: [1,2,3,4]
        arr = new int[] {1,2,3,4,5};
        k = 4;
        x = 3;
        System.out.println(sol.findClosestElements(arr, k, x));

        k = 4;
        x = -1;
        System.out.println(sol.findClosestElements(arr, k, x));

        k = 4;
        x = 7;
        System.out.println(sol.findClosestElements(arr, k, x));

        arr = new int[] {0,0,1,2,3,3,4,7,7,8};
        k = 3;
        x = 5;
        System.out.println(sol.findClosestElements(arr, k, x));
    }
}

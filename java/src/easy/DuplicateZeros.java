package easy;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int numDuplicate = 0;
        int lastIndex = arr.length - 1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                if (i == lastIndex - numDuplicate) {
                    arr[i] = 0;
                    lastIndex--;
                    break;
                }
                numDuplicate++;
            }
        }
        while (lastIndex >= 0) {
            if (arr[lastIndex] == 0) {
                arr[lastIndex + numDuplicate] = 0;
                numDuplicate--;
                arr[lastIndex + numDuplicate] = 0;
            } else {
                arr[lastIndex + numDuplicate] = arr[lastIndex];
            }
            lastIndex--;
        }
    }
    public void duplicateZeros_v2(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            list.add(arr[i]);
            if (arr[i] == 0) {
                list.add(arr[i]);
            }
            if (list.size() >= arr.length) break;
        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    public void duplicateZeros_v1(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] == 0) {
                // shift i+1 by 1
                for (int j=arr.length-1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                arr[++i] = 0;
            }
        }
    }
}

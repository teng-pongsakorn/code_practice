package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for (int i=2; i<arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i]-arr[i-1]);
        }
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - arr[i-1] == minDiff) {
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return result;
    }
}

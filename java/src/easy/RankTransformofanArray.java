package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RankTransformofanArray {

    public int[] arrayRankTransform_v3(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int num: sortedArr) {
            rank.putIfAbsent(num, rank.size()+1);
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
    public int[] arrayRankTransform_v2(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: arr) {
            if (!queue.contains(num)) {
                queue.add(num);
            }
        }
        Map<Integer, Integer> rank = new HashMap<>();
        while (!queue.isEmpty()) {
            rank.put(queue.poll(), rank.size() + 1);
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        return arr;
    }
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> num2rank = new HashMap<>();
        for (int num: arr) {
            num2rank.put(num, 1);
        }
        int rank = 1;
        for (int num: num2rank.keySet().stream().sorted().mapToInt(Number::intValue).toArray()) {
            num2rank.put(num, rank++);
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = num2rank.get(arr[i]);
        }
        return arr;
    }
}

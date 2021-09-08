package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval: intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge_v1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> result = new ArrayList<>();
        int idx = 1;
        int lo = intervals[0][0];
        int hi = intervals[0][1];
        while (idx < intervals.length) {
            int[] current = intervals[idx++];
            if (hi < current[0]) {
                result.add(new int[]{lo, hi});
                lo = current[0];
                hi = current[1];
            } else {
                hi = Math.max(hi, current[1]);
                lo = Math.min(lo, current[0]);
            }
        }
        result.add(new int[]{lo, hi});

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(MergeIntervals.merge(intervals)));

        // [[1,4],[0,1]]
        intervals = new int[][] {{1,4}, {0,1}};
        System.out.println(Arrays.deepToString(MergeIntervals.merge(intervals)));

        // [[1,4],[2,3]]
        intervals = new int[][] {{1, 4}, {2,3}};
        System.out.println(Arrays.deepToString(MergeIntervals.merge(intervals)));

        // [[2,3],[4,5],[6,7],[8,9],[1,10]]
        intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(MergeIntervals.merge(intervals)));

    }
}

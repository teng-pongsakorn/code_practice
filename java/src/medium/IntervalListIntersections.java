package medium;

import java.util.ArrayList;

public class IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int idx1 = 0;
        int idx2 = 0;
        ArrayList<int[]> results = new ArrayList<>();
        while (idx1 < firstList.length && idx2 < secondList.length) {
            int[] first = firstList[idx1];
            int[] second = secondList[idx2];

            // check if has valid intersect
            int lo = Math.max(first[0], second[0]);
            int hi = Math.min(first[1], second[1]);
            if (lo <= hi) {
                results.add(new int[]{lo, hi});
            }

            // should go to next interval ?
            if (first[1] <= second[1]) {
                idx1++;
            }
            if (second[1] <= first[1]) {
                idx2++;
            }
        }
        return results.toArray(new int[results.size()][]);
    }
    public static int[][] intervalIntersection_v1(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        ArrayList<int[]> results = new ArrayList<>();

        int len1 = firstList.length;
        int len2 = secondList.length;
        int idx1 = 0;
        int idx2 = 0;
        int[] first = null;
        int[] second = null;
        while (idx1 < len1 && idx2 < len2) {
            first = firstList[idx1];
            second = secondList[idx2];
            int[] intersectResult = intersect(first, second);
            if (intersectResult != null) {
                results.add(intersectResult);
            }

            if (first[1] <= second[1]) {
                idx1++;
            }
            if (second[1] <= first[1]) {
                idx2++;
            }
        }
//        System.out.println("After While loop: " + Arrays.toString(first) + " vs. " + Arrays.toString(second));
        int[][] x = new int[results.size()][2];
        return results.toArray(x);
    }

    private static int[] intersect(int[] first, int[] second) {
        int firstStart = first[0];
        int firstEnd = first[1];
        int secondStart = second[0];
        int secondEnd = second[1];
        if (firstEnd < secondStart || secondEnd < firstStart) {
            return null;
        }
        if (firstEnd >= secondStart && firstEnd <= secondEnd) {
            int head = Math.max(firstStart, secondStart);
            int tail = Math.min(firstEnd, secondEnd);
            return new int[] {head, tail};
        } else {
            return intersect(second, first);
        }
    }

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] result = IntervalListIntersections.intervalIntersection(firstList, secondList);
        print2DArray(result);

//        [[5,10]]
//        [[3,10]]
//        [3, 10]

    }

    private static void print2DArray(int[][] result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < result.length; i++) {
            sb.append("[ ");
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("] ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}

package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumPointsYouCanObtainsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        if (cardPoints.length == k) return sum;
        int max = sum;
        int i = k-1, j = cardPoints.length-1;
        while (i >= 0) {
            sum -= cardPoints[i--];
            sum += cardPoints[j--];
            max = sum > max ? sum : max;
        }
        return max;
    }
    public int maxScore_v3(int[] cardPoints, int k) {
        int size = cardPoints.length - k;
        int total = 0;
        int min;
        int sum = 0;
        for (int i=0; i<size; i++) {
            sum += cardPoints[i];
            total += cardPoints[i];
        }
        min = sum;
        for (int i=size; i<cardPoints.length; i++) {
            sum += cardPoints[i];
            total += cardPoints[i];
            sum -= cardPoints[i-cardPoints.length+k];
            min = sum < min ? sum : min;
        }
        return min == total ? min : total - min;
    }
    public int maxScore_v2(int[] cardPoints, int k) {
        System.out.println("cardPoints: " + Arrays.toString(cardPoints) + " k=" + k);
        int n = cardPoints.length;
        int minSum = cardPoints[0];
        for (int i=1; i<n; i++) {
            cardPoints[i] += cardPoints[i-1];
            if (i < n-k) {
                minSum = cardPoints[i];
            } else {
                System.out.println("minSum: " + minSum);
                minSum = Math.min(minSum, cardPoints[i]-cardPoints[i-n+k]);
            }
        }
        System.out.println("minSum: " + minSum);
        System.out.println("cumSum: " + Arrays.toString(cardPoints));
        return k==n ? cardPoints[n-1] : cardPoints[n-1] - minSum;
    }
    public int maxScore_v1(int[] cardPoints, int k) {
        // find minSum size n-k
        Map<Integer, Integer> map = new HashMap<>();
        int cumsum = 0;
        map.put(-1, 0);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<cardPoints.length; i++) {
            cumsum += cardPoints[i];
            if (map.containsKey(i-k)) {
                int sum = cumsum - map.get(i-k);
                min = sum < min ? sum : min;
            }
            map.put(i, cumsum);
        }
        return cumsum - min;
    }

    public static void main(String[] args) {
        MaximumPointsYouCanObtainsFromCards sol = new MaximumPointsYouCanObtainsFromCards();
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println(sol.maxScore(nums, k));

        nums = new int[]{2,2,2};
        k = 2;
        System.out.println(sol.maxScore(nums, k));
    }
}

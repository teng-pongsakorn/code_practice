package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TheNumberofWeakCharactersintheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        int[] maxHeights = new int[100002];
        for (int[] property: properties) {
            maxHeights[property[0]] = Math.max(maxHeights[property[0]], property[1]);
        }
        for (int i=100000; i>=0; i--) {
            maxHeights[i] = Math.max(maxHeights[i], maxHeights[i+1]);
        }
        int count = 0;
        for (int[] property: properties) {
            if (property[1] < maxHeights[property[0] + 1]) {
                count++;
            }
        }
        return count;
    }
    public int numberOfWeakCharacters_nlogn(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]);
            }
        });
//        System.out.println(Arrays.deepToString(properties));
        int count = 0;
        int maxY = 0;
        for (int i=0; i<properties.length; i++) {
            if (properties[i][1] < maxY) {
                count++;
            }
            maxY = Math.max(maxY, properties[i][1]);
        }
        return count;
    }
    public int numberOfWeakCharacters_naive(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0;
        for (int i=0; i<properties.length; i++) {
            boolean hasStronger = false;
            for (int j=i+1; j<properties.length; j++) {
                if (isWeak(properties[i], properties[j])) {
                    hasStronger = true;
                    break;
                }
            }
            count += hasStronger ? 1 : 0;
        }
        return count;
    }

    private boolean isWeak(int[] p1, int[] p2) {
        return (p1[0] < p2[0] && p1[1] < p2[1]);
    }

    public static void main(String[] args) {
        TheNumberofWeakCharactersintheGame sol = new TheNumberofWeakCharactersintheGame();
        int[][] properties;

        properties = new int[][] {{5,5},{6,3},{3,6}};
        System.out.println(sol.numberOfWeakCharacters(properties));

        properties = new int[][] {{2,2},{3,3}};
        System.out.println(sol.numberOfWeakCharacters(properties));

        properties = new int[][] {{1,5},{10,4},{4,3}, {10, 5}};
        System.out.println(sol.numberOfWeakCharacters(properties));

        properties = new int[][] {{1,2},{2,3},{4,5},{5,2},{6,1},{7,3},{4,2}};
        System.out.println(sol.numberOfWeakCharacters(properties));
    }
}

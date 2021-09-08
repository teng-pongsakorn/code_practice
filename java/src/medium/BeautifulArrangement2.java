package medium;

import java.util.*;

public class BeautifulArrangement2 {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int idx = 0;
        int left = 1, right = n;
        while (left <= right) {
            if (k % 2 == 0) {
                result[idx++] = left++;
            } else {
                result[idx++] = right--;
            }

            if (k > 1) k--;
        }
        return result;
    }

    public int[] constructArray_v2(int n, int k) {
        int[] result = new int[n];
        boolean[] notAvailable = new boolean[n+1];
        int idx = 0;
        for (int i=1; i<=n; i++) {
            if (notAvailable[i]) continue;
            if (k > 0) {
                result[idx++] = i;
                result[idx++] = i+k;
                notAvailable[i+k] = true;
                k -= 2;
            } else {
                result[idx++] = i;
            }
        }
        return result;
    }
    public int[] constructArray_v1(int n, int k) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=n; i++) {
            if (set.contains(i)) continue;
            if (k > 1) {
                result.add(i);
                result.add(i+k);
                set.add(i);
                set.add(i+k);
                k -= 2;
            } else {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        BeautifulArrangement2 sol = new BeautifulArrangement2();
        int n, k;

        n = 3;
        k = 1;
        System.out.println(Arrays.toString(sol.constructArray(n, k)));

        n = 3;
        k = 2;
        System.out.println(Arrays.toString(sol.constructArray(n, k)));
    }
}

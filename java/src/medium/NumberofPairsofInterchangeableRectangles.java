package medium;

import java.util.HashMap;
import java.util.Map;

public class NumberofPairsofInterchangeableRectangles {
    public long interchangeableRectangles_naive(int[][] rectangles) {
        int count = 0;
        for (int i=0; i<rectangles.length; i++) {
            int[] rec1 = rectangles[i];
            for (int j=i+1; j<rectangles.length; j++) {
                int[] rec2 = rectangles[j];
                if (rec1[0]*rec2[1] == rec1[1]*rec2[0]) count++;
            }
        }
        return count;
    }
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> map = new HashMap<>();
        for (int[] pair: rectangles) {
            int w = pair[0];
            int h = pair[1];
            int x = gcd(w, h);
            String key = (w/x) + "," + (h/x);
            map.put(key, map.getOrDefault(key, 0L)+1);
        }
        long count = 0;
        for (long n: map.values()) {
            count += (n-1)*n/2;
        }
        return count;
    }

    public int gcd(int a, int b) {
        if (b > a) return gcd(b, a);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        NumberofPairsofInterchangeableRectangles sol = new NumberofPairsofInterchangeableRectangles();
        System.out.println(sol.gcd(48, 18));
        System.out.println(sol.gcd(8, 12));
        System.out.println(sol.gcd(54, 24));
        System.out.println(sol.gcd(13, 17));
    }
}

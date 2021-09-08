package medium;

import java.util.*;

public class PerfectSquares {
    public static List<Integer> result;
    static {
        result = new ArrayList<>();
        result.add(0);
    }
    public int numSquares_dp3(int n) {
        if (n < result.size()) return result.get(n);
        for (int i=result.size(); i<=n; i++) {
            int count = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++) {
                count = Math.min(count, result.get(i - j*j) + 1);
            }
            result.add(count);
        }
        return result.get(n);
    }
    public int numSquares_dp2(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i=4; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++) {
                if (result[i - j*j] + 1 < min) {
                    min = result[i - j*j] + 1;
                }
            }
            result[i] = min;
        }
//        System.out.println("Result: " + Arrays.toString(result));
//        System.out.println("=".repeat(50));
        return result[n];
    }
    public int numSquares_dp1(int n) {
        int[] result = new int[n+1];
        Arrays.fill(result, n);
        for (int i=1; i<=100; i++) {
            if (i*i > n) break;
            result[i*i] = 1;
        }
        for (int i=1; i<result.length; i++) {
            if (result[i] == 1) continue;
            for (int j = i-1; j>=i/2; j--) {
                result[i] = Math.min(result[j] + result[i-j], result[i]);
            }
        }
        return result[n];
    }
    public int numSquares(int n) {
        Set<Integer> squares = new HashSet<>();
        for (int i=1; i*i<=n; i++) {
            squares.add(i*i);
        }
        if (squares.contains(n)) return 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size > 0) {
                int remain = queue.poll();
                if (squares.contains(remain)) {
                    return depth;
                }
                for (int square: squares) {
                    if (square < remain) {
                        queue.add(remain - square);
                    }
                }
                size--;
            }
        }
         return depth;
    }
    public int numSquares_naive(int n) {
//        System.out.println("n=" + n);
        Set<Integer> squares = new HashSet<>();
        for (int i=2; i<=100; i++) {
            if (i*i <= n) {
                squares.add(i*i);
            }
        }
        Queue<Integer[]> queue = new LinkedList<>();
        for (int square: squares) {
            if (square <= n) {
                queue.add(new Integer[] {n / square, n % square});
            }
        }
//        System.out.println(squares);
        int min = n;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int count = queue.peek()[0];
                int remain = queue.peek()[1];
//                System.out.println("queue: [" + count + ", " + remain + "]");
                if (remain == 0) {
                    min = count < min ? count : min;
                } else {
                    for (int square: squares) {
                        if (square <= remain) {
                            queue.add(new Integer[] {count + remain/square, remain % square});
                        }
                    }
                }
                queue.poll();
                size--;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        PerfectSquares sol = new PerfectSquares();
        System.out.println(sol.numSquares(12) == 3);
        System.out.println(sol.numSquares(13) == 2);
        System.out.println(sol.numSquares(10000)==1);
        System.out.println(sol.numSquares(9999)==4);
        System.out.println(sol.numSquares(41)==2);
        System.out.println(sol.numSquares(21)==3);
    }
}

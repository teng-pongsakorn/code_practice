package easy;

import java.util.Arrays;

public class CountingBits {
    public static int[] solve(int n) {
        int[] result = new int[n+1];

        for (int i=1, t=0; i<=n; i++, t++) {
            if ((i&(i-1)) == 0) {
                t = 0;
            }
            result[i] = result[t]+1;
        }
        return result;
    }

    public static int[] solve_v1(int n) {
        int[] result = new int[n+1];
        while (n > 0) {
            result[n] = getNumBits(n);
            n--;
        }
        return result;
    }

    private static int getNumBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CountingBits.solve(2)));
        System.out.println(Arrays.toString(CountingBits.solve(3)));
        System.out.println(Arrays.toString(CountingBits.solve(4)));
        System.out.println(Arrays.toString(CountingBits.solve(5)));
        System.out.println(Arrays.toString(CountingBits.solve(6)));
        System.out.println(Arrays.toString(CountingBits.solve(7)));
        System.out.println(Arrays.toString(CountingBits.solve(8)));
        System.out.println(Arrays.toString(CountingBits.solve(9)));
        System.out.println(Arrays.toString(CountingBits.solve(10)));
        System.out.println(Arrays.toString(CountingBits.solve(11)));
        System.out.println(Arrays.toString(CountingBits.solve(12)));
        System.out.println(Arrays.toString(CountingBits.solve(13)));
        System.out.println(Arrays.toString(CountingBits.solve(14)));
        System.out.println(Arrays.toString(CountingBits.solve(15)));
        System.out.println(Arrays.toString(CountingBits.solve(16)));
    }
}

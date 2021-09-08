package medium;

import java.util.Arrays;

public class UglyNumber2 {

    public static int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int t2=0, t3=0, t5=0;
        for (int i=1; i<n; i++) {
            uglyNums[i] = Math.min(uglyNums[t2]*2, Math.min(uglyNums[t3]*3, uglyNums[t5]*5));
            if (uglyNums[i] == uglyNums[t2]*2) t2++;
            if (uglyNums[i] == uglyNums[t3]*3) t3++;
            if (uglyNums[i] == uglyNums[t5]*5) t5++;
        }
        System.out.println(Arrays.toString(uglyNums));
        return uglyNums[n-1];
    }


    // 1 <= n <= 1690
    public static int nthUglyNumber_naive(int n) {
        int count = 0;
        int num = 1;
        while (true) {
            if (isUgly(num)) count++;
            if (count == n) return num;
            num++;
        }
    }

    private static boolean isUgly(int num) {
        for (int x: new int[]{2,3,5}) {
            while (num % x == 0) {
                num /= x;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(UglyNumber2.nthUglyNumber(10));
        System.out.println(UglyNumber2.nthUglyNumber(20));
//        System.out.println(UglyNumber2.nthUglyNumber(1) == 1);
//        System.out.println(UglyNumber2.nthUglyNumber(2) == 2);
//        System.out.println(UglyNumber2.nthUglyNumber(3) == 3);
//        System.out.println(UglyNumber2.nthUglyNumber(4) == 4);
//        System.out.println(UglyNumber2.nthUglyNumber(5) == 5);
//        System.out.println(UglyNumber2.nthUglyNumber(6) == 6);
    }
}

package com.company.mylibrary;

public class Series {

    public static int nSum(int n) {
        int result = 0;
        for (int i=0; i<=n; i++) {
            result += i;
        }
        return result;
    }

    public static int factorial(int n) {
        if (n==0) return 1;
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }

    public static int fibonacci(int n) {
        int first = 0;
        int second = 1;
        if (n==0) return first;
        if (n==1) return second;
        for (int i=2; i<=n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }


}

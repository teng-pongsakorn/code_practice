package easy;

//An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//Given an integer n, return true if n is an ugly number.
public class UglyNumber {
    public static boolean isUgly(int n) {
        if (n == 0) return true;
        for (int num: new int[]{2,3,5}) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(UglyNumber.isUgly(1) == true);
        System.out.println(UglyNumber.isUgly(6) == true);
        System.out.println(UglyNumber.isUgly(8) == true);
        System.out.println(UglyNumber.isUgly(14) == false);
        System.out.println(-2/2);
    }
}

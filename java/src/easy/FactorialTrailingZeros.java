package easy;

public class FactorialTrailingZeros {
    public static int trailingZeroes(int n) {
        int count = 0;
        int base5 = 5;
        while (n > 0) {
            count += n/base5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(FactorialTrailingZeros.trailingZeroes(1)==0);
        System.out.println(FactorialTrailingZeros.trailingZeroes(3)==0);
        System.out.println(FactorialTrailingZeros.trailingZeroes(5)==1);
        System.out.println(FactorialTrailingZeros.trailingZeroes(10)==2);
        System.out.println(FactorialTrailingZeros.trailingZeroes(15)==3);
//        System.out.println(FactorialTrailingZeros.trailingZeroes(25)==?);
    }
}

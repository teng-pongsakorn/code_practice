package easy;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n-1)) == 0;
    }
    public static boolean isPowerOfTwo_v1(int n) {
        if (n < 0) return false;
        int oneCount = 0;
        for (int i=0; i<31; i++) {
            oneCount += (n & 1);
            n >>= 1;
        }
        return oneCount==1;
    }

    public static void main(String[] args) {
        System.out.println(PowerOfTwo.isPowerOfTwo(1));
        System.out.println(PowerOfTwo.isPowerOfTwo(2));
        System.out.println(PowerOfTwo.isPowerOfTwo(3));
        System.out.println(PowerOfTwo.isPowerOfTwo(4));
        System.out.println(PowerOfTwo.isPowerOfTwo(5));
        System.out.println(PowerOfTwo.isPowerOfTwo(16));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Integer.toBinaryString(-2147483648 >> 30));
        int n = 0;
        System.out.println(n & (n-1));
    }
}

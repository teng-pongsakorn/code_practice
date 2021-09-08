package easy;

public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        System.out.print(Integer.toBinaryString(n) + " : ");
        n = n ^ (n >> 1);
        return (n & (n+1)) == 0;
    }

    public static boolean hasAlternatingBits_v1(int n) {
        System.out.print(Integer.toBinaryString(n) + " : ");
        int last = n & 1;
        n >>= 1;
        while (n > 0) {
            if ((n & 1) == last) {
                return false;
            }
            last = n&1;
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(3));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(4));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(5));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(6));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(7));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(8));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(11));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(10));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(14));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(20));
        System.out.println(BinaryNumberWithAlternatingBits.hasAlternatingBits(21));

    }
}

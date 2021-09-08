package easy;

public class NumberOfOneBits {
    public static int hammingWeight(int n) {
        int result = 0;
        for (int i=0; i<32; i++) {
            result += (n & 1);
            n >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(NumberOfOneBits.hammingWeight(11));   // 3
//        4294967293L
        System.out.println(NumberOfOneBits.hammingWeight(-3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(-3>>1);
        System.out.println(Integer.toBinaryString(-3 >> 1));
        System.out.println(-3&1);
    }
}

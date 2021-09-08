package easy;

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        int x = 1;
        for (int i=0; i<15; i++) {
            if (x == n) {
                return true;
            }
            x = x << 2;
        }
        return false;
    }

    public static boolean isPowerOfFour_v1(int n) {
        int x = (int) Math.round(Math.log(n) / Math.log(4));
        return Math.pow(4, x) == n;
    }

    public static void main(String[] args) {
        System.out.println(PowerOfFour.isPowerOfFour(0) == false);
        System.out.println(PowerOfFour.isPowerOfFour(1) == true);
        System.out.println(PowerOfFour.isPowerOfFour(2) == false);
        System.out.println(PowerOfFour.isPowerOfFour(4) == true);
        System.out.println(PowerOfFour.isPowerOfFour(8) == false);
        System.out.println(PowerOfFour.isPowerOfFour(16) == true);
        System.out.println(PowerOfFour.isPowerOfFour(1162261466));
        System.out.println(Math.log(1162261466)/Math.log(4));

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(64));
        System.out.println(Integer.toBinaryString(256));
        System.out.println(1 << 2);
    }
}

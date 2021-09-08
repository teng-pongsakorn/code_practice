package easy;

public class BinaryGap {
    public int binaryGap(int n) {
        System.out.print(Integer.toBinaryString(n) + " binary gap = ");
        int maxGap = 0;
        Integer prevOne = null;
//        int i = 0;
        for (int i=0; n > 0; i++, n>>=1) {
            if ((n & 1) == 1) {
                if (prevOne != null) {
                    maxGap = Math.max(maxGap, i - prevOne);
                }
                prevOne = i;
            }
        }
//        while (n > 0) {
//            if ((n & 1) == 1) {
//                if (prevOne != null) {
//                    maxGap = Math.max(maxGap, i - prevOne);
//                }
//                prevOne = i;
//            }
//            n >>= 1;
//            i++;
//        }
        return maxGap;
    }

    public static void main(String[] args) {
        BinaryGap sol = new BinaryGap();
        System.out.println(sol.binaryGap(5));
        System.out.println(sol.binaryGap(6));
        System.out.println(sol.binaryGap(100));
        System.out.println(sol.binaryGap(1000));
    }
}

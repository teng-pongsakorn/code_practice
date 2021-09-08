package easy;

public class SqrtX {

    public static int mySqrt(int x) {
        int lo = 1;
        int hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
//        for (int i = 1; i < 46340; i++) {
//            if (i*i > x) {
//                return i-1;
//            }
//        }
//        return 46340;
    }

    public static void main(String[] args) {
        System.out.println(SqrtX.mySqrt(4));
        System.out.println(SqrtX.mySqrt(5));
        System.out.println(SqrtX.mySqrt(7));
        System.out.println(SqrtX.mySqrt(25));

        int x = 2147395600;
    }
}

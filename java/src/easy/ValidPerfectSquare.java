package easy;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int r = num;
        double numOverR = 1.0*num/r;
        while (r > numOverR) {
            r = (r + (int)numOverR) / 2;
            numOverR = 1.0*num/r;
        }
        return r*r==num;
    }
    public boolean isPerfectSquarev_v1(int num) {
        if (num == 1) return true;
        int lo = 1, hi = num;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            double val = 1.0*num/mid;
            if (mid == val) {
                return true;
            } else if (mid < val) {
                lo = mid+1;
            } else if (mid > val) {
                hi = mid-1;
            }
        }
        return lo*lo == num;
    }

    public static void main(String[] args) {
        ValidPerfectSquare solve = new ValidPerfectSquare();

        System.out.println(solve.isPerfectSquare(1));
        System.out.println(solve.isPerfectSquare(2));
        System.out.println(solve.isPerfectSquare(3));
        System.out.println(solve.isPerfectSquare(4));
        System.out.println(solve.isPerfectSquare(9));
        System.out.println(solve.isPerfectSquare(100));
        System.out.println(solve.isPerfectSquare(101));
        System.out.println(solve.isPerfectSquare(1000000));
        System.out.println(solve.isPerfectSquare(104976));
    }
}

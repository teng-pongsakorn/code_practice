package easy;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long lo = 1;
        long hi = n;
        while (lo < hi) {
            long level = lo + (hi - lo)/2;
            long count = level * (level + 1) / 2;
            if (count < n) {
                lo = level + 1;
            }  else if (count > n) {
                hi = level - 1;
            } else {
                return (int) level;
            }
        }
        return (int) lo;
    }
    public int arrangeCoins_v2(int n) {
        double x = n;
        return (int) Math.floor(0.5*(-1 + Math.sqrt(1+8*x)));
    }
    public int arrangeCoins_v1(int n) {
        int level = 1;
        while (true) {
            if (n == level) {
                return level;
            } else if (n < level) {
                return level-1;
            }
            n -= level;
            level++;
        }
    }

    public static void main(String[] args) {
        int n, expect;
        ArrangingCoins solve = new ArrangingCoins();

        n = 1;
        expect = 1;
        System.out.println("n="+n+ " : " + solve.arrangeCoins(n) + " levels [expect " + expect+"]");

        n = 5;
        expect = 2;
        System.out.println("n="+n+ " : " + solve.arrangeCoins(n) + " levels [expect " + expect+"]");

        n = 8;
        expect = 3;
        System.out.println("n="+n+ " : " + solve.arrangeCoins(n) + " levels [expect " + expect+"]");
    }
}

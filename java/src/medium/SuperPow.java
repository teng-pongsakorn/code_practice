package medium;

public class SuperPow {
    public int superPow_v2(int a, int[] b) {
        int mod = 1337;
        int result = 1;
        for (int bi: b) {
            result = pow(result , 10, mod) * pow(a, bi, mod) % mod;
        }
        return result;
    }

    private int pow(int base, int pow, int mod) {
        base %= mod;
        int result = 1;
        for (int i=0; i<pow; i++) {
            result = (base * result) % mod;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        if (a==1) return 1;
        if (isOne(b)) return a % 1337;
        if (isOdd(b)) {
            b[b.length-1]--;
            return ((a % 1337) * superPow(a, b)) % 1337;
        }
        divideByTwo(b);
        return superPow(((a%1337)*(a%1337))%1337, b);
    }

    private void divideByTwo(int[] b) {
        int carry = 0;
        for (int i=0; i<b.length; i++) {
            int tmp = (b[i] + carry) / 2;
            carry = b[i] % 2 == 1 ? 10 : 0;
            b[i] = tmp;
        }
    }

    private boolean isOdd(int[] b) {
        return b[b.length-1] % 2 == 1;
    }

    private boolean isOne(int[] b) {
        for (int i=0; i<b.length-1; i++) {
            if (b[i] != 0) return false;
        }
        return b[b.length-1] == 1;
    }

    public static void main(String[] args) {
        SuperPow sol = new SuperPow();
        int a;
        int[] b;

        a = 2;
        b = new int[] {3};
        System.out.println(sol.superPow(a, b));

        a = 2;
        b = new int[] {1,0};
        System.out.println(sol.superPow(a, b));

        a = 1;
        b = new int[] {4,3,3,8,5,2};
        System.out.println(sol.superPow(a, b));

        a = 2147483647;
        b = new int[] {2,0,0};
        System.out.println(sol.superPow(a, b));
    }
}

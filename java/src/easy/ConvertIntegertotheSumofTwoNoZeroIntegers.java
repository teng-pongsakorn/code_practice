package easy;

public class ConvertIntegertotheSumofTwoNoZeroIntegers {
    public int[] getNoZeroIntegers_v2(int n) {
        int a = 0, b = 0, factor = 1;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            if (d == 0) {
                a += 1 * factor;
                b += 9 * factor;
                n--;
            } else if (d == 1 && n > 1) {
                a += 2 * factor;
                b += 9 * factor;
                n--;
            } else {
                a += 1 * factor;
                b += (d - 1) * factor;
            }
            factor *= 10;
        }

        return new int[] {a, b};
    }
    public int[] getNoZeroIntegers(int n) {
        for (int a=1; a<=n/2; a++) {
            int b = n - a;
            if (isNoZero(b) && isNoZero(a)) {
                return new int[] {a, b};
            }
        }
        return new int[] {};
    }

    private boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}

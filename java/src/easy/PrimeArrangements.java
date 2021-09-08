package easy;

import java.math.BigInteger;

public class PrimeArrangements {
    public int numPrimeArrangements(int n) {
        boolean[] notPrimes = new boolean[n+1];
        notPrimes[1] = true;
        for (int i=2; i*i<=n;i++) {
            if (!notPrimes[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    notPrimes[j] = true;
                }
            }
        }
        // [ p! * (n-p)! ] % (10^9 + 7)
        int primeCount = 0;
        for (int i=1; i<notPrimes.length; i++) {
            if (!notPrimes[i]) primeCount++;
        }
        int MOD = 1000000007;
        int result = 1;
        for (int i=2; i<=primeCount; i++) {
            result *= (i%MOD);
            result %= MOD;
        }
        for (int i=2; i<=n-primeCount; i++) {
            result *= (i%MOD);
            result %= MOD;
        }
        return result;
    }
    public int numPrimeArrangements_v1(int n) {
        boolean[] notPrimes = new boolean[n+1];
        notPrimes[1] = true;
        for (int i=2; i*i<=n;i++) {
            if (!notPrimes[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    notPrimes[j] = true;
                }
            }
        }
        // [ p! * (n-p)! ] % (10^9 + 7)
        int primeCount = 0;
        for (int i=1; i<notPrimes.length; i++) {
            if (!notPrimes[i]) primeCount++;
        }
        BigInteger result = factorial(primeCount).multiply(factorial(n - primeCount));
        result = result.mod(BigInteger.valueOf(1000000007));
        return result.intValue();
    }
    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        while (n > 1) {
            result = result.multiply(BigInteger.valueOf(n--));
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeArrangements sol = new PrimeArrangements();
        System.out.println(sol.numPrimeArrangements(5));
        System.out.println(sol.numPrimeArrangements(6));
    }
}

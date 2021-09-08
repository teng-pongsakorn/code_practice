package easy;

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] notPrimes = new boolean[n];
        int count = n/2;
        for (int i=3; i*i<n; i+=2) {
            if (notPrimes[i]) {
                continue;
            }
            for (int j=i*i; j<n; j+=(2*i)) {
                if (!notPrimes[j]) {
                    count--;
                    notPrimes[j] = true;
                }
            }
        }
        return count;
    }

    public static int countPrimes_v1(int n) {
        if (n <= 1) return 0;
        boolean[] primes = new boolean[n];
//        Arrays.fill(primes, true);
        int count =0;
//        primes[0] = false;
//        primes[1] = false;
        for (int i=2; i<n; i++) {
            if (primes[i] == false) {
                count++;
                for (int j=i*2; j<n; j+=i) {
                    primes[j] = true;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(CountPrimes.countPrimes(10));  // 4
        System.out.println(CountPrimes.countPrimes(2));  // 1
    }
}

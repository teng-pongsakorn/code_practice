package easy;

public class PrimeNumbersOfSetBitsInBinaryRepresentation {
    public static int countPrimeSetBits(int left, int right) {
        boolean[] notPrimes = getNotPrime(right);
//        System.out.println(Arrays.toString(notPrimes));
        int count = 0;
        for (int num=left; num<=right; num++) {
            int numBits = countBit(num);
            if (!notPrimes[numBits]) {
//                System.out.print(num + " ");
                count++;
            }
        }
//        System.out.println(" : " + count);
        return count;
    }

    private static int countBit(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num &= num-1;
        }
        return count;
    }

    private static boolean[] getNotPrime(int n) {
        int size = (int) Math.ceil(Math.log(n) / Math.log(2));
        boolean[] notPrimes = new boolean[size+1];
        notPrimes[0] = true;
        notPrimes[1] = true;
        for (int i=2; i<=size; i++) {
            if (notPrimes[i]) {
                continue;
            }
            for (int j=2*i; j<=size; j += i) {
                notPrimes[j] = true;
            }
        }
        return notPrimes;
    }

    public static void main(String[] args) {
//        int n = 12;
//        System.out.println(Integer.toBinaryString(n));
//        System.out.println(Math.log(n)/ Math.log(2));
        System.out.println(PrimeNumbersOfSetBitsInBinaryRepresentation.countPrimeSetBits(6, 10));;
        System.out.println(PrimeNumbersOfSetBitsInBinaryRepresentation.countPrimeSetBits(10, 15));;
    }
}

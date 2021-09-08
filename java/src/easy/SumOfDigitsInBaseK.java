package easy;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int result = 0;
        while (n > 0) {
            result += n % k;
            n /= k;
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfDigitsInBaseK solve = new SumOfDigitsInBaseK();
        int k=10;
        for (int i=1; i<=50; i++) {
            System.out.println(i + " base " + k + " = " + solve.sumBase(i, k));
        }
    }
}

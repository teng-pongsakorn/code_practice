package easy;

public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int idx = 0;
        if (n % 2 != 0) {
            result[idx++] = 0;
            n--;
        }
        for (int i=1; i <= n/2; i++) {
            result[idx++] = i;
            result[idx++] = -i;
        }
        return result;
    }
}

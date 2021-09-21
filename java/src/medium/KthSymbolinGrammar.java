package medium;

public class KthSymbolinGrammar {
    public int kthGrammar(int n, int k) {
        if (n==1) return 0;
        int half = (int) Math.pow(2, n-2);
//        System.out.println("n=" + n + " numElements=" + numElements);
        if (k > half) {
            return kthGrammar(n-1, k-half) == 0 ? 1 : 0;
        }
        return kthGrammar(n-1, k);
    }
}

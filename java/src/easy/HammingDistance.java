package easy;

public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z > 0) {
            z &= (z-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(HammingDistance.hammingDistance(1, 4));
        System.out.println(HammingDistance.hammingDistance(3, 1));
    }
}

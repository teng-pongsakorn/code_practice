package easy;

public class NumberComplement {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }
    public int findComplement_v1(int num) {
        int result = 0;
        int i = 0;
        while (num > 0) {
            result += ((num & 1) ^ 1) << i++;
            num >>= 1;
//            System.out.println(result + "  ----");
        }
        return result;
    }

    public static void main(String[] args) {
        NumberComplement solution = new NumberComplement();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
        System.out.println(0 << 1);
    }
}

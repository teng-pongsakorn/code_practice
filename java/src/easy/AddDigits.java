package easy;

public class AddDigits {

    public int addDigits(int num) {
        if (num==0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }

    public int addDigits_v1(int num) {
        while (num / 10 != 0) {
            num = add(num);
        }
        return num;
    }

    private int add(int num) {
        int result = 0;
        while (num > 0) {
            result += num%10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        System.out.println(solution.addDigits(0));
        System.out.println(solution.addDigits(83));

        for (int i=0; i<100; i++) {
            System.out.println("n=" + i + " result=" + solution.addDigits(i));
        }
    }
}

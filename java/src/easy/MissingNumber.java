package easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = (nums.length + 1) * nums.length / 2;
        for (int num: nums) {
            result -= num;
        }
        return result;
    }
    public int missingNumber_v1(int[] nums) {
        int total = 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            total += num;
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        if (min != 0) return 0;
        int expectTotal = max * (max + 1) / 2;
        return expectTotal==total ? max+1 : expectTotal-total;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        System.out.println(solution.missingNumber(new int[]{0,1,3}));
        System.out.println(solution.missingNumber(new int[]{0,1}));
        System.out.println(solution.missingNumber(new int[]{1}));
    }
}

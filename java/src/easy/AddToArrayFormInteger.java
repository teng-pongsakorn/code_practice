package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        System.out.print(Arrays.toString(num) + " + " + k + " = ");
        List<Integer> result = new LinkedList<>();
        for (int i=num.length-1; i>=0; i--) {
            k += num[i];
            result.add(0, k%10);
            k /= 10;
        }
        while (k > 0) {
            result.add(0, k%10);
            k /= 10;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        AddToArrayFormInteger solve = new AddToArrayFormInteger();
        int[] nums = {1,2,3,4,5};
        System.out.println(solve.addToArrayForm(nums, 5));

        nums = new int[]{1};
        System.out.println(solve.addToArrayForm(nums, 999));
    }
}

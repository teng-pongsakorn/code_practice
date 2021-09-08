package easy;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        if (digits[0] == 0) {
            digits = new int[n+1];
            digits[0] = 1;
        }
        return digits;
    }

    public int[] plusOne_v1(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int topOver = 1;
        int next;
        for (int i = digits.length-1; i >= 0; i--) {
            next = digits[i] + topOver;
            topOver = next / 10;
            stack.push(next % 10);
        }
        if (topOver != 0) {
            stack.push(topOver);
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
//        System.out.println(Arrays.toString(po.plusOne(new int[]{1,2,3,4})));
//        System.out.println(Arrays.toString(po.plusOne(new int[]{0})));
//        System.out.println(Arrays.toString(po.plusOne(new int[]{9})));
//        System.out.println(Arrays.toString(po.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(po.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
        // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
        System.out.println(Arrays.toString(po.plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));
    }
}

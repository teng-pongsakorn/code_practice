package medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        int[] temperatures;

        temperatures = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));

        temperatures = new int[] {5,4,3,2,1};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));

        temperatures = new int[] {3,4,1,2,5,6,7,3,3,5};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));

        temperatures = new int[] {3,3,3,3,3,3};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));

        temperatures = new int[] {3,3,3,3,3,5};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures)));
    }
}

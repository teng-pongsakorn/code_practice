package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        result.add(new ArrayList<>(stack));
        choose(nums, 0, stack, result);
        return result;
    }

    private void choose(int[] nums, int from, Stack<Integer> stack, List<List<Integer>> result) {
        if (from == nums.length) {
            return;
        }
        for (int i=from; i<nums.length; i++) {
            stack.push(nums[i]);
//            System.out.println("list: " + stack);
            result.add(new ArrayList<>(stack));
            choose(nums, i+1, stack, result);
            stack.pop();
        }
    }
}

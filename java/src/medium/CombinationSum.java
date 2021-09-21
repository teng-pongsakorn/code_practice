package medium;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        search(candidates, 0, new ArrayList<Integer>(), target, result);
        return result;
    }

    private void search(int[] candidates, int start, ArrayList<Integer> list, int remain, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            search(candidates, i, list, remain - candidates[i], result);
            list.remove(list.size()-1);
        }
    }

    private int sum(ArrayList<Integer> list) {
        int total = 0;
        for (int num: list) total += num;
        return total;
    }

    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(sol.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(sol.combinationSum(new int[]{2}, 1));
        System.out.println(sol.combinationSum(new int[]{1}, 1));
        System.out.println(sol.combinationSum(new int[]{1}, 2));
    }
}

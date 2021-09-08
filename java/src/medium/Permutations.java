package medium;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        helper(result, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums) {
        int size = result.get(0).size();
        if (size == nums.length) return;
        int num = nums[size];
        int len = result.size();
        for (int i=0; i<len; i++) {
            List<Integer> list = result.remove(0);
            // create new list by add num in all possible locations.
            for (int j=0; j<list.size()+1; j++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(j, num);
                result.add(newList);
            }
        }
        helper(result, nums);
    }

    // my attempt
    public List<List<Integer>> permute_v1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> numList = new LinkedList<Integer>();
        for (int num: nums) {
            numList.add(num);
        }
        perm(result, new ArrayList<>(), numList);
        return result;
    }

    private void perm(List<List<Integer>> result, List<Integer> permList, LinkedList<Integer> items) {
        if (items.size() == 0) {
            result.add(new ArrayList<>(permList));
        }
        for (int i=0; i<items.size(); i++) {
            int num = items.removeFirst();
            permList.add(num);
            perm(result, permList, items);
            items.add(num);
            permList.remove(permList.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        System.out.println(sol.permute(new int[] {1,2,3}));
    }
}

package medium;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
        System.out.println("numsums: " + Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> current = new Stack<>();
        Deque<Integer> remains = new LinkedList<>();
        for (int num: nums) {
            remains.add(num);
        }
        perm(result, current, remains);
        return result;
    }

    private void perm(List<List<Integer>> result, Stack<Integer> current, Deque<Integer> remains) {
        System.out.println("  ".repeat(current.size()) + "current: " + current + " remains: " + remains);
        if (0 == remains.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<remains.size(); i++) {
            int num = remains.removeFirst();
            if (visited.contains(num)) {
                remains.add(num);
                continue;
            }
            current.add(num);
            perm(result, current, remains);
            remains.addLast(num);
            current.pop();
            visited.add(num);
        }
    }


    public static void main(String[] args) {
        PermutationsII sol = new PermutationsII();
        int[] nums;


//        nums = new int[] {1};
//        System.out.println(sol.permuteUnique(nums));
//
//        nums = new int[] {1,1};
//        System.out.println(sol.permuteUnique(nums));
//
//        nums = new int[] {1,2};
//        System.out.println(sol.permuteUnique(nums));

//        nums = new int[] {1,2,3};
//        System.out.println(sol.permuteUnique(nums));

        nums = new int[] {1,1,2};
        System.out.println(sol.permuteUnique(nums));
//
//        nums = new int[] {1,2,2};
//        System.out.println(sol.permuteUnique(nums));
//
//        nums = new int[] {1,1,2,2};
//        System.out.println(sol.permuteUnique(nums));
    }
}

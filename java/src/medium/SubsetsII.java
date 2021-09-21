package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        generate(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generate(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if (i >= nums.length) return;
        for (int j=i; j<nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) continue;
            list.add(nums[j]);
            result.add(new ArrayList<>(list));
            generate(nums, j+1, list, result);
            list.remove(list.size()-1);
        }
    }
}

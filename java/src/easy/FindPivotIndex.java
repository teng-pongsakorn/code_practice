package easy;

import java.util.HashMap;
import java.util.Map;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int cumsum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            cumsum += nums[i];
            map.put(2*cumsum - nums[i], map.getOrDefault(2*cumsum-nums[i], i));
        }

        return map.containsKey(cumsum) ? map.get(cumsum) : -1;
    }
    public int pivotIndex_v1(int[] nums) {
        int[] cumsum = new int[nums.length];
        cumsum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            cumsum[i] = cumsum[i-1] + nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            if (2*cumsum[i]-nums[i] == cumsum[cumsum.length-1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex sol = new FindPivotIndex();
        int[] nums;

        nums = new int[] {1,7,3,6,5,6};
        System.out.println(sol.pivotIndex(nums));

        nums = new int[] {1,2,3};
        System.out.println(sol.pivotIndex(nums));


        nums = new int[] {2, 1, -1};
        System.out.println(sol.pivotIndex(nums));

        nums = new int[] {-1,-1,-1,-1,-1,-1};
        System.out.println(sol.pivotIndex(nums));
    }
}

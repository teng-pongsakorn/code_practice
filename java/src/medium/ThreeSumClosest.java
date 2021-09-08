package medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int closestDiff = Math.abs(target - closestSum);
        for (int i=0; i<nums.length; i++) {
            int newTarget = target - nums[i];
            int lo=i+1, hi=nums.length-1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int diff = Math.abs(newTarget - sum);
                if (diff <= closestDiff) {
                    System.out.println("update closest: " + nums[i] + ", " + nums[lo] + ", " + nums[hi]);
                    closestSum = sum + nums[i];
                    closestDiff = diff;
                }
                if (sum < newTarget) {
                    lo++;
                } else if (sum > newTarget) {
                    hi--;
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }
    public int threeSumClosest_brute(int[] nums, int target) {
        Integer closest = null;
        Integer diff = null;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (closest == null) {
                        closest = sum;
                        diff = Math.abs(sum - target);
                    } else {
                        if (Math.abs(sum - target) < diff) {
                            closest = sum;
                            diff = Math.abs(sum - target);
                        }
                    }
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] nums;
        int target;

        nums = new int[] {-1,2,1,-4};
        target = 1;
        System.out.println(sol.threeSumClosest(nums, target));

        target = -1;
        System.out.println(sol.threeSumClosest(nums, target));
    }
}

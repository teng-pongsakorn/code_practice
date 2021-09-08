package hard;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    // binary search : O(nlogn)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length-1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = distanceLessThanOrEqual(nums, mid);
//            System.out.println("distance=" + mid + " count=" + count + "[lo="+lo + " , hi=" + hi + " k=" + k + "]");
            if (count < k) {
                // mid is too low
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int distanceLessThanOrEqual(int[] nums, int target) {
        int i=0, j=1, count=0;
        while (i < j && j < nums.length) {
            if (nums[j] - nums[i] <= target) {
                count += j-i;
                j++;
            } else {
                i++;
            }
            if (j == i) {
                j++;
            }
        }
//        System.out.println("nums: " + Arrays.toString(nums) + " target="+target);
//        System.out.println("count-naive:" + distanceLessThanNaive(nums, target) + " count-n:" + count);
        return count;
    }

    private int distanceLessThanNaive(int[] nums, int target) {
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] - nums[i] < target) count++;
            }
        }
        return count;
    }

    // naive approach : O(n^2)
    public int smallestDistancePair_v1(int[] nums, int k) {
        Arrays.sort(nums);
        int[] distanceCounts = new int[nums[nums.length-1] - nums[0] + 1];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                distanceCounts[nums[j]-nums[i]]++;
            }
        }
        int count = 0;
        for (int distance=0; distance<distanceCounts.length; distance++) {
            count += distanceCounts[distance];
            if (count >= k) {
                return distance;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance sol = new FindKthSmallestPairDistance();
        int[] nums;
        int k;

        nums = new int[] {1,3,1};
        k = 1;
        System.out.println(sol.smallestDistancePair(nums, k)==0);

        nums = new int[] {1,1,1};
        k = 2;
        System.out.println(sol.smallestDistancePair(nums, k)==0);

        nums = new int[] {1,6,1};
        k = 3;
        System.out.println(sol.smallestDistancePair(nums, k)==5);

        nums = new int[] {1,3,4,5,6,7,9};
        k = 3;
        System.out.println(sol.smallestDistancePair(nums, k)==1);
    }
}

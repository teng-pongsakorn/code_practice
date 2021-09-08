package easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();

        int[] nums;
        int target;

        // 4
        nums = new int[]{-1,0,3,5,9,12};
        target = 9;
        System.out.println(sol.search(nums, target));

        // -1
        target = 2;
        System.out.println(sol.search(nums, target));
    }
}

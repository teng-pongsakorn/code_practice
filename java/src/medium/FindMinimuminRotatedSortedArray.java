package medium;

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray sol = new FindMinimuminRotatedSortedArray();
        int[] nums;

        nums = new int[] {3,4,5,1,2};
        System.out.println(sol.findMin(nums));

        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(sol.findMin(nums));

        nums = new int[] {11,13,15,17};
        System.out.println(sol.findMin(nums));

        nums = new int[] {13,15,17,11};
        System.out.println(sol.findMin(nums));
    }
}

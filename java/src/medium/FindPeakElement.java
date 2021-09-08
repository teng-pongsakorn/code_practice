package medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid+1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public int findPeakElement_v2(int[] nums) {
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean leftIncrement = getDirection(nums, mid);
            boolean rightIncrement = getDirection(nums, mid+1);
            if (leftIncrement && !rightIncrement) {
                return mid;
            } else if (leftIncrement && rightIncrement) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean getDirection(int[] nums, int i) {
        if (i <= 0 || i == nums.length) return true;
        return nums[i-1] < nums[i];
    }

    public int findPeakElement_v1(int[] nums) {
        int lo=0, hi=nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long center = getHeight(nums, mid);
            long left = getHeight(nums, mid-1);
            long right = getHeight(nums, mid+1);
            System.out.println("left:"+left + " mid:" + mid + " right:" +right);
            if (left < center && center > right) {
                return mid;
            } else if (left < center && center < right) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private long getHeight(int[] nums, int i) {
        if (i < 0) return (long)(nums[0]) - 1;
        if (i == nums.length) return (long)(nums[nums.length-1]) - 1;
        return nums[i];
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();
        int[] nums;

        // output = 2
        nums = new int[] {1,2,3,1};
        System.out.println(sol.findPeakElement(nums));

        // output = 5
        nums = new int[] {1,2,1,3,5,6,4};
        System.out.println(sol.findPeakElement(nums));

        nums = new int[] {10,9,8,7,6,5,4,3,2,2};
        System.out.println(sol.findPeakElement(nums));

        nums = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sol.findPeakElement(nums));
    }
}

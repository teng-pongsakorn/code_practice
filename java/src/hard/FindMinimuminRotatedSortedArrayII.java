package hard;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
    }

    public int findMin_v2(int[] nums) {
        int lo = 0, hi = nums.length-1;
        return searchMin(nums, lo, hi);
    }

    private int searchMin(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[hi]) {
                return Math.min(searchMin(nums, lo, mid), searchMin(nums, mid+1, hi));
            } else {
                if (nums[mid] > nums[hi]) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
        }
        return nums[lo];
    }

    public int findMin_v1(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo != hi && nums[lo] == nums[hi]) {
            lo++;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayII sol = new FindMinimuminRotatedSortedArrayII();
        int[] nums;

        nums = new int[] {1,3,5};
        System.out.println(sol.findMin(nums));

        nums = new int[] {2,2,2,0,1};
        System.out.println(sol.findMin(nums));

        nums = new int[] {4,5,6,7,0,1,4};
        System.out.println(sol.findMin(nums));

        nums = new int[] {0,1,4,4,5,6,7};
        System.out.println(sol.findMin(nums));

        nums = new int[] {7,0,1,4,4,5,6};
        System.out.println(sol.findMin(nums));

        nums = new int[] {0,0,0,0,0,-1};
        System.out.println(sol.findMin(nums));

        nums = new int[] {3,3,1,3};
        System.out.println(sol.findMin(nums));

        nums = new int[] {10,1,10,10,10};
        System.out.println(sol.findMin(nums));

        nums = new int[] {3,3,3,3,3,3,3,3,1,3};
        System.out.println(sol.findMin(nums));

//        [10,1,10,10,10]
//        [3,3,1,3]
//        [3,3,3,3,3,3,3,3,1,3]
    }
}

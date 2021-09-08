package hard;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int medianSelected = (nums1.length + nums2.length + 1) / 2;
        int lo = 0, hi = nums1.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num2Selected = medianSelected - mid;
            int nums1MaxLeft = mid - 1 < 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int nums1MinRight = mid == nums1.length ? Integer.MAX_VALUE : nums1[mid];
            int nums2MaxLeft = num2Selected - 1 < 0 ? Integer.MIN_VALUE : nums2[num2Selected - 1];
            int nums2MinRight = num2Selected == nums2.length ? Integer.MAX_VALUE : nums2[num2Selected];
            if (nums1MaxLeft <= nums2MinRight && nums2MaxLeft <= nums1MinRight) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return 0.5 * (Math.max(nums1MaxLeft, nums2MaxLeft) + Math.min(nums1MinRight, nums2MinRight));
                }
                return 1.0 * Math.max(nums1MaxLeft, nums2MaxLeft);
            } else if (nums1MaxLeft > nums2MinRight) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        throw new IllegalArgumentException();
    }
    public double findMedianSortedArrays_v1(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return findMedianSortedArrays_v1(nums2, nums1);
        if (nums2.length == 0) {
            int mid = nums1.length / 2;
            return nums1.length % 2 == 0 ? 0.5*(nums1[mid]+nums1[mid-1]) : 1.0*nums1[mid];
        }
        if (nums1[0] > nums2[0]) return findMedianSortedArrays_v1(nums2, nums1);
        int idx1, idx2;
        int medianIdx = (nums1.length + nums2.length) / 2;
        int numElement = 1;
        if ((nums1.length + nums2.length) % 2 == 0) {
            medianIdx--;
            numElement++;
        }
        int lo = Math.max(0, medianIdx - nums2.length);
        int hi = Math.min(nums1.length - 1, medianIdx);
        while (lo < hi) {
            idx1 = lo + (hi - lo) / 2;
            idx2 = medianIdx - idx1 - 1;
            if (nums2[idx2] > nums1[idx1+1]) {
                lo = idx1 + 1;
            } else {
                hi = idx1;
            }
        }
        idx1 = lo;
        idx2 = medianIdx - idx1 - 1;
        int median = idx2 < 0 ? nums1[idx1] : Math.max(nums1[idx1], nums2[idx2]);
        if (numElement == 2) {
            return 0.5 * (median + nextNum(nums1, idx1, nums2, idx2));
        }
        return 1.0 * median;
    }

    private int nextNum(int[] nums1, int idx1, int[] nums2, int idx2) {
        // next closest value after nums[idx1] or nums[idx2]
        if (idx1 == nums1.length - 1) return nums2[idx2 + 1];
        if (idx2 == nums2.length - 1) return nums1[idx1 + 1];
        return Math.min(nums1[idx1+1], nums2[idx2+1]);
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays sol = new MedianofTwoSortedArrays();
        int[] nums1, nums2;

        // 2
        nums1 = new int[] {1,3};
        nums2 = new int[] {2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.5
        nums1 = new int[] {1,2};
        nums2 = new int[] {3,4};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 0.0
        nums1 = new int[] {0,0};
        nums2 = new int[] {0,0};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 1.0
        nums1 = new int[] {};
        nums2 = new int[] {1};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.0
        nums1 = new int[] {2};
        nums2 = new int[] {};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.5
        nums1 = new int[] {};
        nums2 = new int[] {2,3};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.0
        nums1 = new int[] {1};
        nums2 = new int[] {2,3};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.0
        nums1 = new int[] {3};
        nums2 = new int[] {1,2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 0.0
        nums1 = new int[] {0,0,0,0,0};
        nums2 = new int[] {-1,0,0,0,0,0,1};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 2.5
        nums1 = new int[] {2};
        nums2 = new int[] {1,3,4};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));

        // 3.0
        nums1 = new int[] {2};
        nums2 = new int[] {1,3,4,5};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));


    }
}

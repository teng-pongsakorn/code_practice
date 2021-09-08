package hard;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int maxNum = nums[0];
        int totalSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            maxNum = nums[i] > maxNum ? nums[i] : maxNum;
            totalSum += nums[i];
        }
        int lo = maxNum, hi = totalSum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int numGroup = getNumGroup(nums, mid);
            if (numGroup > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int getNumGroup(int[] nums, int maxAllowed) {
        int numGroup = 1;
        int count = 0;
        for (int num: nums) {
            count += num;
            if (count > maxAllowed) {
                numGroup++;
                count = num;
            }
        }
        return numGroup;
    }
//    public int splitArray(int[] nums, int m) {
//        // compute prefix sum
//        int[] cumsum = new int[nums.length + 1];
//        for (int i=0; i<nums.length; i++) {
//            cumsum[i+1] = cumsum[i] + nums[i];
//        }
//
//        System.out.println("nums: " + Arrays.toString(nums) + " m:" + m);
//        System.out.println("cumsum: " + Arrays.toString(cumsum));
//        // find larger non-max subarray one by one
//        int lo = 0, hi = cumsum.length-1;
//        while (m > 1) {
//            // find subarray sum as close as to this boundSum but not exceed
//            int boundSum = (cumsum[hi] - cumsum[lo]) / m;
//            // binary search for lo-candidate
//            int i = lo, j = hi;
//            while (i < j) {
//                int mid = i + (j - i + 1) / 2;
//                int leftSum = cumsum[mid] - cumsum[lo];
//                if (leftSum > boundSum) {
//                    j = mid - 1;
//                } else {
//                    i = mid;
//                }
//            }
//            int candidateLo = i;
//            // binary search for hi-candidate
//            i = lo; j = hi;
//            while (i < j) {
//                int mid = i + (j - i) / 2;
//                int rightSum = cumsum[hi] - cumsum[mid];
//                if (rightSum > boundSum) {
//                    i = mid + 1;
//                } else {
//                    j = mid;
//                }
//            }
//            int candidateHi = i;
//
//            // select the one with higher sum
//            if (cumsum[candidateLo] - cumsum[lo] > cumsum[hi] - cumsum[candidateHi]) {
//                System.out.print(cumsum[candidateLo] - cumsum[lo] + " ");
//                lo = candidateLo;
//            } else {
//                System.out.print(cumsum[hi] - cumsum[candidateHi] + " ");
//                hi = candidateHi;
//            }
//            m--;
//        }
//        System.out.println(cumsum[hi] - cumsum[lo]);
//        System.out.println("===".repeat(20));
////        System.out.println("nums: " + Arrays.toString(nums));
////        System.out.println("cumSum: " + Arrays.toString(cumsum));
////        System.out.println("lo:" + lo + " hi:" + hi);
//        return cumsum[hi] - cumsum[lo];
//    }

    public static void main(String[] args) {
        SplitArrayLargestSum sol = new SplitArrayLargestSum();
        int[] nums;
        int m;

        nums = new int[] {7,2,5,10,8};
        m = 2;
        System.out.println(sol.splitArray(nums, m)==18);

        nums = new int[] {1,2,3,4,5};
        m = 2;
        System.out.println(sol.splitArray(nums, m)==9);

        nums = new int[] {1,4,4};
        m = 3;
        System.out.println(sol.splitArray(nums, m)==4);

        nums = new int[] {1,1,1,1,1,1,1,8};
        m = 2;
        System.out.println(sol.splitArray(nums, m)==8);

        nums = new int[] {1,1,1,8,1,1,1,1,1};
        m = 2;
        System.out.println(sol.splitArray(nums, m)==11);

        nums = new int[] {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        m = 8;
        System.out.println(sol.splitArray(nums, m) == 25);

    }
}

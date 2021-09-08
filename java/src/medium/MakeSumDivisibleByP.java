package medium;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {

        return -1;
//        long[] cumsum = new long[nums.length];
//        cumsum[0] = nums[0];
//        remainder[(int) (cumsum[0]%p)] = 1;
//        for (int i=1; i<nums.length; i++) {
//            if (nums[i] % p != 0) {
//                remainder[nums[i]%p] = 1;
//            }
//            cumsum[i] = nums[i] + cumsum[i-1];
//            if (cumsum[i]%p == 0) {
//                remainder[0] = i;
//            } else if (remainder[(int) (cumsum[i]%p)] == 0) {
//                remainder[(int) (cumsum[i]%p)] = i-remainder[0];
//            } else {
//                remainder[(int) (cumsum[i]%p)] = Math.min(i-remainder[0], remainder[(int) (cumsum[i]%p)]);
//            }
//        }
//        System.out.println("cumsum: " + Arrays.toString(cumsum));
//        for (long x: cumsum) {
//            System.out.println(" >> " + x % p);
//        }
//        System.out.println(Arrays.toString(remainder) + " cumsum =" + cumsum[nums.length-1]%p);
//        int rem = (int) (cumsum[nums.length-1] % p);
//        if (rem == 0) return 0;
//        if (remainder[rem] == nums.length || remainder[rem]==0) return -1;
//
//        return remainder[rem];
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP solution = new MakeSumDivisibleByP();
        int[] nums;
        int p;

        // 1
        nums = new int[]{3,1,4,2};
        p = 6;
        System.out.println(solution.minSubarray(nums, p));

        // 2
        nums = new int[]{6,3,5,2};
        p = 9;
        System.out.println(solution.minSubarray(nums, p));

        // 0
        nums = new int[]{1,2,3};
        p = 3;
        System.out.println(solution.minSubarray(nums, p));

        // -1
        nums = new int[]{1,2,3};
        p = 7;
        System.out.println(solution.minSubarray(nums, p));

        // 0
        nums = new int[]{1000000000,1000000000,1000000000};
        p = 3;
        System.out.println(solution.minSubarray(nums, p));

        // -1
        nums = new int[]{3,6,8,1};
        p = 8;
        System.out.println(solution.minSubarray(nums, p));

//        [26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3]
//        26
        // expect 3
        nums = new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        p = 26;
        System.out.println(solution.minSubarray(nums, p));

    }
}

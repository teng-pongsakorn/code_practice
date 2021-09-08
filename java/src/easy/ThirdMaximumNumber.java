package easy;

import java.util.Arrays;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (int n: nums) {
            if (max1==null) {
                max1 = n;
            } else if (max2 == null) {
                if (n > max1) {
                    max2 = max1;
                    max1 = n;
                } else if (n < max1) {
                    max2 = n;
                }
            } else if (max3 == null) {
                if (n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if (n > max2 && n < max1) {
                    max3 = max2;
                    max2 = n;
                } else if (n < max2){
                    max3 = n;
                }
            } else {
                if (n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if (n > max2 && n < max1) {
                    max3 = max2;
                    max2 = n;
                } else if (n > max3 && n < max2) {
                    max3 = n;
                }
            }
        }
        System.out.println("max1:"+max1+" max2:"+max2+" max3:"+max3);
        return (max3==null || max2==null) ? max1 : max3;
    }
    public int thirdMax_v1(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i] != nums[i+1]) {
                count++;
                if (count == 3) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        ThirdMaximumNumber solve = new ThirdMaximumNumber();

        int[] nums = {1,2,3,4,3,2,3,4};
        System.out.println(solve.thirdMax(nums));

        nums = new int[] {1,2,-2147483648};
        System.out.println(solve.thirdMax(nums));

        nums = new int[] {1,1,2};
        System.out.println(solve.thirdMax(nums));

        nums = new int[] {5,2,2};
        System.out.println(solve.thirdMax(nums));
    }
}

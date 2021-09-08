package easy;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        for (int i=0, j=0; i<nums.length; j++) {
            if (j >= nums.length) {
                nums[i++] = 0;
            } else if (nums[i] != 0) {
                i++;
            } else if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
        }
    }
    public void moveZeroes_v2(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0 && nums[cur]!=nums[lastNonZeroFoundAt]) {
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = 0;
            } else if (nums[lastNonZeroFoundAt] != 0) {
                lastNonZeroFoundAt++;
            }
        }
    }

    private void swap(int num, int num1) {
    }

    public void moveZeroes_v1(int[] nums) {
        int i=0;
        int j=1;
        while (j < nums.length) {
            if (nums[i]!=0) {
                i++;
//                j++;
            }
//            else if (nums[i]==0 && nums[j]==0) {
//                j++;
//            }
            else if (nums[i]==0 && nums[j]!=0) {
                nums[i] = nums[j];
                nums[j] = 0;
//                j++;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        MoveZeros sol = new MoveZeros();
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        System.out.println(Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2,0,3,4,5,0,0};
        System.out.println(Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,0,2,0,3,0,4,0,5,0};
        System.out.println(Arrays.toString(nums));
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

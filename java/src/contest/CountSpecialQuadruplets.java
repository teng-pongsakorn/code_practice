package contest;

public class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                for (int k = j+1; k<nums.length-1; k++) {
                    for (int m=k+1; m<nums.length; m++) {
                        if (nums[i]+nums[j]+nums[k] == nums[m]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSpecialQuadruplets sol = new CountSpecialQuadruplets();
        int[] nums;


        nums = new int[] {1,2,3,6};
        System.out.println(sol.countQuadruplets(nums));

        nums = new int[] {3,3,6,4,5};
        System.out.println(sol.countQuadruplets(nums));

        nums = new int[] {1,1,1,3,5};
        System.out.println(sol.countQuadruplets(nums));
    }
}

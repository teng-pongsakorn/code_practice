package easy;

public class BuildArrayfromPermutation {
    public int[] buildArray_v2(int[] nums) {
        int q = nums.length;
        for (int i=0; i<nums.length; i++) {
            nums[i] = nums[i] + q * (nums[nums[i]] % q);
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] /= q;
        }
        return nums;
    }
    public int[] buildArray(int[] nums) {
        int[] permArray = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            permArray[i] = nums[nums[i]];
        }
        return permArray;
    }
}

package medium;

public class JumpGame {
    public boolean canJump_v1(int[] nums) {
        boolean[] isPossible = new boolean[nums.length];
        isPossible[0] = true;
        for (int i=0; i<nums.length; i++) {
            if (isPossible[i]) {
                for (int j=i+1; j<=i+nums[i] && j < nums.length; j++) {
                    isPossible[j] = true;
                }
            }
        }
        return isPossible[nums.length-1];
    }

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i=0; i<nums.length && i<=maxReach; i++) {
            maxReach = Math.max(maxReach, i+nums[i]);
            if (maxReach >= nums.length-1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(new int[] {2,3,1,1,4}));
        System.out.println(sol.canJump(new int[] {3,2,1,0,4}));
    }
}

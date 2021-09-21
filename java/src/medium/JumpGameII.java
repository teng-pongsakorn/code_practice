package medium;

public class JumpGameII {
    public int jump_v1(int[] nums) {
        int[] jumps = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<=i+nums[i] && j<nums.length; j++) {
                jumps[j] = jumps[j] == 0 ? jumps[i]+1 : Math.min(jumps[i]+1, jumps[j]);
            }
        }
        return jumps[nums.length-1];
    }

    public int jump_v2(int[] nums) {
        int newReach = 0;
        int step = 0;
        int i, reach;
        for (i=0, reach=0; i <= reach && i < nums.length; i++) {
            newReach = Math.min(Math.max(i + nums[i], newReach), nums.length-1);
            if (i == reach) {
                System.out.println("reach=" + reach + " newReach=" + newReach);
                reach = newReach;
                step += 1;
            }
        }
        return step-1;
    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int ladder = nums[0];
        int stairs = nums[0];
        int jump = 1;
        for (int step=1; step<nums.length; step++) {
            if (step == nums.length-1) return jump;
            if (step + nums[step] > ladder) {
                ladder = step + nums[step];
            }
            stairs--;
            if (stairs == 0) {
                jump++;
                stairs = ladder - step;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();
        System.out.println(sol.jump(new int[] {2,3,1,1,4}));  // 2
        System.out.println(sol.jump(new int[] {2,3,0,1,4}));  // 2
        System.out.println(sol.jump(new int[] {3,2,1,5,3,2,1,0,5,6,7,1,0,0,0})); // 4
    }
}

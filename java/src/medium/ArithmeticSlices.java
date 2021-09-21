package medium;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int seqCount = 0;
        int prevDiff = 0;
        for (int i=1; i<nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if (seqCount == 0 || prevDiff == diff) {
                seqCount += 1;
            } else {
                seqCount = 1;
            }
            if (seqCount > 1) {
                total += seqCount - 1;
            }
            prevDiff = diff;
        }
        return total;
    }
    public int numberOfArithmeticSlices_v1(int[] nums) {
        int total = 0;
        int seqCount = 0;
        int prevDiff = 0;
        for (int i=1; i<nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if (seqCount == 0 || diff == prevDiff) {
                seqCount++;
            } else {
                if (seqCount >= 2) {
                    System.out.println("diff = " + prevDiff + " seqCount = " + seqCount);
                    int n = seqCount + 1 - 2;
                    total += n * (n + 1) / 2;
                }
                seqCount = 1;
            }
            prevDiff = diff;
//            System.out.println("diff = " + prevDiff + " seqCount = " + seqCount);
        }
        if (seqCount >= 2) {
//            System.out.println("diff = " + prevDiff + " seqCount = " + seqCount);
            int n = seqCount + 1 - 2;
            total += n * (n + 1) / 2;
        }

        return total;
    }

    public static void main(String[] args) {
        ArithmeticSlices sol = new ArithmeticSlices();
        System.out.println(sol.numberOfArithmeticSlices(new int[] {1,2,3,4})==3);
        System.out.println(sol.numberOfArithmeticSlices(new int[] {1})==0);
    }
}

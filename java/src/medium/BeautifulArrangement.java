package medium;

public class BeautifulArrangement {
    public int countArrangement(int n) {
        boolean[] nums = new boolean[n+1];
//        Set<Integer> nums = new HashSet<>();
        return countHelper(nums, n, 0);
    }

    private int countHelper(boolean[] nums, int n, int size) {
        if (size == n) {
            return 1;
        }
        int count = 0;
        int position = size + 1;
        for (int num=1; num<=n; num++) {
            if (!nums[num] && (num % position == 0 || position % num == 0)){
                nums[num] = true;
                count += countHelper(nums, n, position);
                nums[num] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BeautifulArrangement sol = new BeautifulArrangement();

        System.out.println(sol.countArrangement(1));
        System.out.println(sol.countArrangement(2));
        System.out.println(sol.countArrangement(3));
        System.out.println(sol.countArrangement(4));
        System.out.println(sol.countArrangement(5));
        System.out.println(sol.countArrangement(15));
    }
}

package easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int lo, int hi, int target) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return search(nums, lo, mid-1, target);
            } else {
                return search(nums, mid+1, hi, target);
            }
        }
//        System.out.println("hi:" + hi + ", lo:" + lo);
        return lo;
    }

    public static void main(String[] args) {
        SearchInsertPosition app = new SearchInsertPosition();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(app.searchInsert(nums, 5));
        System.out.println(app.searchInsert(nums, 2));
        System.out.println(app.searchInsert(nums, 7));
        System.out.println(app.searchInsert(nums, 0));
        System.out.println(app.searchInsert(new int[]{1}, 0));
        System.out.println(app.searchInsert(new int[]{1, 3}, 0));
        System.out.println(app.searchInsert(new int[]{1, 3}, 2));
    }
}

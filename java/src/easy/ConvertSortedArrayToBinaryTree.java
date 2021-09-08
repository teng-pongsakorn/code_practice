package easy;

public class ConvertSortedArrayToBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedArrayToBST(nums, start, mid-1);
        TreeNode rightChild = sortedArrayToBST(nums, mid+1, end);
        return new TreeNode(nums[mid], leftChild, rightChild);
    }
}

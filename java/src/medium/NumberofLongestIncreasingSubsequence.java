package medium;

public class NumberofLongestIncreasingSubsequence {
    class Node {
        Node top;
        int val;
        int count;

        public Node(int val) {
            this.val = val;
        }
    }
    public int findNumberOfLIS_myversion(int[] nums) {
        Node[] paths = new Node[nums.length+1];
        paths[0] = new Node(-1000001);
        paths[0].count = 1;
        int i = 1;
        for (int num: nums) {
            // has new length
            if (paths[i-1].val < num) {
                Node next = new Node(num);
                // combine count from previous nodes having value < next node
                Node prev = paths[i-1];
                while (prev != null && prev.val < num) {
                    next.count += prev.count;
                    prev = prev.top;
                }
                paths[i++] = next;
            } else {
                // find first node x in path having value >= num
                int lo = 1, hi = i-1;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (paths[mid].val < num) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                Node node = new Node(num);
                node.top = paths[lo];        // connect node to current lo-th node
                Node prev = paths[lo-1];
                while (prev != null && prev.val < num) {
                    node.count += prev.count;
                    prev = prev.top;
                }
                paths[lo] = node;
            }
        }
        Node last = paths[i-1];
        int count = 0;
        while (last != null) {
            count += last.count;
            last = last.top;
        }
        return count;
    }

    public int findNumberOfLIS(int[] nums) {
        int[] maxLengthAti = new int[nums.length];
        int[] countMaxLengthAti = new int[nums.length];
        int maxlen = 0;
        int maxlenCount = 0;
        for (int i=0; i<nums.length; i++) {
            maxLengthAti[i] = 1;
            countMaxLengthAti[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (maxLengthAti[j] + 1 == maxLengthAti[i]) {
                        countMaxLengthAti[i] += countMaxLengthAti[j];
                    } else if (maxLengthAti[j] + 1 > maxLengthAti[i]) {
                        maxLengthAti[i] = maxLengthAti[j] + 1;
                        countMaxLengthAti[i] = countMaxLengthAti[j];
                    }
                }
            }
            if (maxLengthAti[i] > maxlen) {
                maxlen = maxLengthAti[i];
                maxlenCount = countMaxLengthAti[i];
            } else if (maxLengthAti[i] == maxlen) {
                maxlenCount += countMaxLengthAti[i];
            }
        }
        return maxlenCount;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence sol = new NumberofLongestIncreasingSubsequence();
        int[] nums;

        nums = new int[] {1,2,5,4,7};
        System.out.println(sol.findNumberOfLIS(nums) == 2);

        nums = new int[] {2,2,2,2,2};
        System.out.println(sol.findNumberOfLIS(nums) == 5);

        nums = new int[] {1,2,4,3,5,4,7,2};
        System.out.println(sol.findNumberOfLIS(nums) == 3);

        nums = new int[] {3,1,2};
        System.out.println(sol.findNumberOfLIS(nums) == 1);

//        nums = new int[] {1,2,5,4,7};
//        System.out.println(sol.findNumberOfLIS(nums) == 2);
    }

//    [1,3,5,4,7] -> 2
//    [2,2,2,2,2]
//    [1,2,4,3,5,4,7,2] -> 3
//    [3,1,2]
}

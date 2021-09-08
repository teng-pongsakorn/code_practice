package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start, end;
        for (int i=0; i<nums.length; i++) {
            start = nums[i];
            end = start;
            while (i+1 < nums.length && nums[i]+1 == nums[i+1]) {
                i++;
                end = nums[i];
            }
            result.add(start==end ? start+"" : start+"->"+end);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(SummaryRanges.summaryRanges(nums));

        nums = new int[]{1,2,4,5,7};
        System.out.println(Arrays.toString(nums));
        System.out.println(SummaryRanges.summaryRanges(nums));

        nums = new int[]{};
        System.out.println(Arrays.toString(nums));
        System.out.println(SummaryRanges.summaryRanges(nums));

        nums = new int[]{1 };
        System.out.println(Arrays.toString(nums));
        System.out.println(SummaryRanges.summaryRanges(nums));
    }
}

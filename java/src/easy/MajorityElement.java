package easy;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Integer current = null;
        int count = 0;
        for (int num: nums) {
            if (count == 0) {
                current = num;
            }
            count += (current == num) ? 1 : -1;
        }
        return current;
    }

    public static int majorityElement_v2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static int majorityElement_v1(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int k = nums.length / 2;
        for (int num: nums) {
            numCount.put(num, 1+numCount.getOrDefault(num, 0));
            if (numCount.get(num) > k) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MajorityElement.majorityElement(new int[]{3,2,3}) == 3);
        System.out.println(MajorityElement.majorityElement(new int[]{2,2,1,1,1,2,2}) == 2);
        System.out.println(MajorityElement.majorityElement(new int[]{2}) == 2);
    }
}

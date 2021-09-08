package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int i=0; i<stones.length; i++) total+=stones[i];
        int capacity = total / 2;
        // S1 u S2 => stones and S1 ^ S2 => {}
        // answer = sum(S1) - sum(S2)
        // sum(S1) + sum(S2) = total
        // sum(S1) >= sum(S2)
        // sum(S2) <= total / 2
        // new goal is to find maximum sum(S2)
        // answer = total - 2*sum(S2)
        Integer[][] memo = new Integer[stones.length+1][capacity+1];
        return total - 2* knapsack(stones.length, capacity, stones, memo);
    }

    private int knapsack(int index, int capacity, int[] stones, Integer[][] memo) {
        if (memo[index][capacity] != null) return memo[index][capacity];
        if (index == 0 || capacity <= 0) return 0;
        int result;
        if (stones[index-1] > capacity) {
            // just skip this one
            result = knapsack(index-1, capacity, stones, memo);
        } else {
            // 2 options available
            int takeIt = stones[index-1] + knapsack(index-1, capacity-stones[index-1], stones, memo);
            int leaveIt = knapsack(index-1, capacity, stones, memo);
            result = Math.max(takeIt, leaveIt);
        }
        memo[index][capacity] = result;
        return result;
    }

    public int lastStoneWeightII_v1(int[] stones) {
        Map<String, Integer> memo = new HashMap<>();
        return Math.abs(searchMin(0, 0, stones, memo));
    }

    private int searchMin(int sum, int index, int[] stones, Map<String, Integer> memo) {
        String key = Math.abs(sum) + "," + index;
        if (memo.containsKey(key)) return memo.get(key);
        if (index == stones.length) return sum;
        int posSum = searchMin(sum + stones[index], index+1, stones, memo);
        int negSum = searchMin(sum - stones[index], index+1, stones, memo);
        int result = Math.abs(posSum) < Math.abs(negSum) ? posSum : negSum;
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        LastStoneWeight2 solve = new LastStoneWeight2();
        int[] stones;
        stones = new int[] {31,26,33,21,40};
        System.out.println(solve.lastStoneWeightII(stones));
        Arrays.sort(stones);
        System.out.println(solve.lastStoneWeightII(stones));
        stones = new int[] {89,23,100,93,82,98,91,85,33,95,72,98,63,46,17,91,92,72,77,79,99,96,55,72,24,98,79,93,88,92};  // expect 0
        System.out.println(solve.lastStoneWeightII(stones));
        }
}

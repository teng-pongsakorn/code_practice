package medium;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2_v3(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, current, result);
        return result;
    }

    private void backtrack(int[] candidates, int currIdx, int remain, LinkedList<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=currIdx; i<candidates.length; i++) {
            if (i > currIdx && candidates[i]==candidates[i-1]) continue;

            int num = candidates[i];
            if (remain - num < 0) break;
            current.add(num);
            backtrack(candidates, i+1, remain-num, current, result);
            current.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2_v2(int[] candidates, int target) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: candidates) {
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> result = new ArrayList<>();
        int[][] numCounterList = new int[counter.size()][];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: counter.entrySet()) {
            numCounterList[idx++] = new int[] {entry.getKey(), entry.getValue()};
        }
        helper(new ArrayList<>(), target, 0, numCounterList, result);
        return result;
    }

    private void helper(ArrayList<Integer> currentList, int remain, int idx, int[][] counterList, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        } else if (remain < 0) {
            return;
        } else {
            for (int i=idx; i<counterList.length; i++) {
                if (counterList[i][1] > 0) {
                    counterList[i][1]--;
                    currentList.add(counterList[i][0]);
                    helper(currentList, remain - counterList[i][0], i+1, counterList, result);
                    counterList[i][1]++;
                    currentList.remove(currentList.size()-1);
                }
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combine(candidates, 0, current, target, result);
        return result;
    }

    private void combine(int[] candidates, int idx, List<Integer> current, int remain, List<List<Integer>> result) {
        System.out.println("current: " + current + " remain=" + remain);
        if (remain < 0 || idx==candidates.length) return;
        else if (remain == 0) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i=idx; i<candidates.length; i++) {
                if (i==idx || candidates[i] != candidates[i-1]) {
                    current.add(candidates[i]);
                    combine(candidates, i+1, current, remain - candidates[i], result);
                    current.remove(current.size()-1);
                }
            }
        }
    }
}

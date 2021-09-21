package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourcetoTarget {
//    public List<List<Integer>> allPathsSourceTarget_xxx(int[][] graph) {
//        List<List<Integer>> result = new LinkedList<>();
//        Stack<Integer> stack = new Stack<>();
//        Stack<Integer> seq = new Stack<>();
//        seq.add(0);
//        stack.add(0);
//        while (!stack.isEmpty()) {
//            int i = stack.pop();
//            seq.add(i);
//            if (i == graph.length-1) {
//                result.add(new LinkedList<>(seq));
//            }
//            for (int j: graph[i]) {
//                stack.add(j);
//            }
//        }
//    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> seq = new Stack<>();
        seq.push(0);
        dfs(graph, 0, seq, result);
        return result;
    }

    private void dfs(int[][] graph, int i, Stack<Integer> seq, List<List<Integer>> result) {
        if (i == graph.length - 1) {
            result.add(new LinkedList<>(seq));
        } else {
            for (int j: graph[i]) {
                seq.push(j);
                dfs(graph, j, seq, result);
                seq.pop();
            }
        }
    }
}

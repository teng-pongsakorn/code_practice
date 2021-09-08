package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] notRoots = new boolean[n];
        for (List<Integer> list: edges) {
            int to = list.get(1);
            notRoots[to] = true;
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (notRoots[i] == false) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfVerticesToReachAllNodes solution = new MinimumNumberOfVerticesToReachAllNodes();
        List<List<Integer>> edges;

        // n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]  => [0, 3]
        edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        System.out.println(edges);
        System.out.println(solution.findSmallestSetOfVertices(6, edges));
    }
}

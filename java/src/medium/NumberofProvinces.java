package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int numProvince = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        for (int k=0; k<isConnected.length; k++) {
            if (!isVisited[k]) {
                numProvince++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(k);
                isVisited[k] = true;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size > 0) {
                        int i = queue.poll();
                        for (int j = 0; j < isConnected.length; j++) {
                            if (i != j && !isVisited[j] && isConnected[i][j]==1) {
                                queue.add(j);
                                isVisited[j] = true;
                            }
                        }
                        size--;
                    }
                }
            }
        }
        return numProvince;
    }
}

package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    final int EMPTY = 0;
    final int FRESH = 1;
    final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();

        int numFresh = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.add(r*n + c);
                } else if (grid[r][c] == FRESH) {
                    numFresh++;
                }
            }
        }
        if (numFresh == 0) return 0;
        int depth = 0;
        System.out.println(Arrays.deepToString(grid));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int idx = queue.poll();
                int r = idx / n;
                int c = idx % n;
                if (r - 1 >= 0 && grid[r-1][c] == FRESH) {
                    queue.add(n*(r-1)+c);
                    grid[r-1][c] = ROTTEN;
                    numFresh--;
                }
                if (r + 1 < m && grid[r+1][c] == FRESH) {
                    queue.add(n*(r+1)+c);
                    grid[r+1][c] = ROTTEN;
                    numFresh--;
                }
                if (c - 1 >= 0 && grid[r][c-1] == FRESH) {
                    queue.add(n*r+c-1);
                    grid[r][c-1] = ROTTEN;
                    numFresh--;
                }
                if (c + 1 < n && grid[r][c+1] == FRESH) {
                    queue.add(n*r+c+1);
                    grid[r][c+1] = ROTTEN;
                    numFresh--;
                }
                size--;
            }
            depth++;
            System.out.println("depth:" + depth + " numFresh:" + numFresh);
            System.out.println(Arrays.deepToString(grid));
        }
        return numFresh > 0 ? -1 : depth;
    }
}

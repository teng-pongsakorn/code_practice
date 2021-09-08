package medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
    public final char LAND = '1';
    public final char VISITED = '2';

    public int numIslands(char[][] grid) {
        int[] dirs = {0,-1,0,1,0};
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == LAND) {
                    islandCount++;
                    visit(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    private void visit(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != LAND) return;
        grid[r][c] = VISITED;
        visit(grid, r+1, c);
        visit(grid, r-1, c);
        visit(grid, r, c+1);
        visit(grid, r, c-1);
    }

    public int numIslands_v1(char[][] grid) {
        int[] dirs = {0,-1,0,1,0};
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == LAND) {
                    numIslands++;
                    // traverse all connected land and converted to visited
                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.add(new Integer[] {r, c});
                    grid[r][c] = VISITED;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size > 0) {
                            Integer[] coord = queue.poll();
                            // check any neighbor land
                            for (int i=1; i<dirs.length; i++) {
                                int rNew = coord[0] + dirs[i];
                                int cNew = coord[1] + dirs[i-1];
                                if (rNew >= 0 && rNew < rows && cNew >= 0 && cNew < cols && grid[rNew][cNew] == LAND) {
                                    queue.add(new Integer[]{rNew, cNew});
                                    grid[rNew][cNew] = VISITED;
                                }
                            }
                            size--;
                        }
                    }
                }
            }
        }
        return numIslands;
    }
}

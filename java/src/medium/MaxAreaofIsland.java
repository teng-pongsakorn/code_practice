package medium;

public class MaxAreaofIsland {

    private final int SEA = 0;
    private final int LAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == LAND) {
                    int area = countArea(grid, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int countArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == SEA) return 0;

        int count = 1;
        grid[r][c] = SEA;
        count += countArea(grid, r+1, c);
        count += countArea(grid, r-1, c);
        count += countArea(grid, r, c+1);
        count += countArea(grid, r, c-1);
        return count;
    }
}

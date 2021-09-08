package easy;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int coundLand = 0;
        int discount = 0;
        int width = grid[0].length;
        int height = grid.length;
        for (int row=0; row < height; row++) {
            for (int col=0; col < width; col++) {
                if (grid[row][col] == 1) {
                    coundLand++;
                    // check right
                    if (col+1 < width && grid[row][col+1] == 1) {
                        discount += 2;
                    }
                    // check below
                    if (row+1 < height && grid[row+1][col] == 1) {
                        discount += 2;
                    }
                }
            }
        }
        return 4*coundLand - discount;
    }
    public int islandPerimeter_v1(int[][] grid) {
        int count = 0;
        for (int row=0; row < grid.length; row++) {
            for (int col=0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    count += getPerimeter(row-1, col, grid);
                    count += getPerimeter(row+1, col, grid);
                    count += getPerimeter(row, col-1, grid);
                    count += getPerimeter(row, col+1, grid);
                }
            }
        }
        return count;
    }

    private int getPerimeter(int row, int col, int[][] grid) {
        // row-1,col | row+1,col | row, col+1 | row, col-1
        try {
            return  (grid[row][col] == 1) ? 0 : 1;
        } catch (IndexOutOfBoundsException e) {
            return 1;
        }
    }

    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();

        int[][] grid;

        grid = new int[][] {{1}};
        System.out.println(solution.islandPerimeter(grid) == 4);

        grid = new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(solution.islandPerimeter(grid) == 16);

        grid = new int[][] {{1, 0}};
        System.out.println(solution.islandPerimeter(grid) == 4);
    }
}

package easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void fill(int[][] image, int row, int col, int targetColor, int newColor) {
        if (image[row][col] == targetColor) {
            image[row][col] = newColor;
            int m = image.length;
            int n = image[0].length;
            if (row + 1 < m) {
                fill(image, row+1, col, targetColor, newColor);
            }
            if (row - 1 >= 0) {
                fill(image, row-1, col, targetColor, newColor);
            }
            if (col + 1 < n) {
                fill(image, row, col+1, targetColor, newColor);
            }
            if (col - 1 >= 0) {
                fill(image, row, col-1, targetColor, newColor);
            }
        }
    }
}

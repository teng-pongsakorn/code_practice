package medium;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        // find row index
        int lo = 0, hi = numRows - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][numCols-1] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int row = lo;
        // find target in that row
        lo = 0;
        hi = matrix[0].length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return matrix[row][lo] == target;
    }
    public boolean searchMatrix_1Dbinary(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / n;
            int c = mid % n;
            if (matrix[r][c] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int r = lo / n, c = lo % n;
        return matrix[r][c] == target;
    }


}

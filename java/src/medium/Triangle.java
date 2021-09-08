package medium;

import java.util.List;

public class Triangle {
    public int minimumTotal_dp_bottomup(List<List<Integer>> triangle) {
        int nRows = triangle.size();
        List<Integer> resultRow = triangle.get(nRows - 1);
        for (int row=nRows-2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            for (int col=0; col <= row; col++) {
                resultRow.set(col, currentRow.get(col) + Math.min(resultRow.get(col), resultRow.get(col+1)));
            }
        }
        return resultRow.get(0);
    }
    public int minimumTotal_dp_topdown(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] result = new int[n][n];
        result[0][0] = triangle.get(0).get(0);
        for (int row=1; row < n; row++) {
            List<Integer> rowList = triangle.get(row);
            for (int col=0; col <= row; col++) {
                if (col == 0) {
                    // first item in the row
                    result[row][col] = result[row-1][col] + rowList.get(col);
                } else if (col == row) {
                    // last item in the row
                    result[row][col] = result[row-1][col-1] + rowList.get(col);
                } else {
                    result[row][col] = Math.min(result[row-1][col], result[row-1][col-1]) + rowList.get(col);
                }
            }
        }
        int min = result[n-1][0];
        for (int num: result[n-1]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}

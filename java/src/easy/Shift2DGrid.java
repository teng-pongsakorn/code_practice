package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid_v2(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int totalElements = n * m;
        k %= totalElements;

        int start = (totalElements - k) % totalElements;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> rows = new LinkedList<>();
        for (int sourceIndex=start; sourceIndex<start+totalElements; sourceIndex++) {
            int i = sourceIndex % totalElements;
            int sourceRow = i / m;
            int sourceCol = i % m;
            rows.add(grid[sourceRow][sourceCol]);
            if (rows.size() == m) {
                result.add(rows);
                rows = new LinkedList<>();
            }
        }
        return result;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        Integer[][] shiftedGrid = new Integer[numRows][numCols];

        int newRow, newCol;
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                int flatIndex = (row*numCols + col + k) % (numRows * numCols);
                newRow = flatIndex / numCols;
                newCol = flatIndex % numCols;
                shiftedGrid[newRow][newCol] = grid[row][col];
            }
        }
       List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            result.add(Arrays.asList(shiftedGrid[row]));
        }
        return result;
    }
}

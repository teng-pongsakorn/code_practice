package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> currentRow = new ArrayList<>(Arrays.asList(1));
        List<Integer> nextRow;
        for (int row=1; row<=rowIndex; row++) {
            nextRow = new ArrayList<>();
            nextRow.add(1);
            for (int i=1; i<currentRow.size(); i++) {
                nextRow.add(currentRow.get(i-1) + currentRow.get(i));
            }
            nextRow.add(1);

            currentRow = nextRow;
        }
        return currentRow;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int row=1; row<numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> prevRowList = result.get(row-1);

            // add first
            rowList.add(prevRowList.get(0));
            // add between
            for (int j=1; j<prevRowList.size(); j++) {
                int val = prevRowList.get(j-1) + prevRowList.get(j);
                rowList.add(val);
            }
            // add last
            rowList.add(prevRowList.get(prevRowList.size()-1));

            result.add(rowList);
        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = PascalTriangle.generate(2);
//        System.out.println(PascalTriangle.generate(2));
//        System.out.println(PascalTriangle.generate(1));
//        System.out.println(PascalTriangle.generate(5));
        System.out.println(PascalTriangle.getRow(0));
        System.out.println(PascalTriangle.getRow(2));
        System.out.println(PascalTriangle.getRow(3));
        System.out.println(PascalTriangle.getRow(5));
    }
}

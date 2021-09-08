package easy;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            builder.append((char) ((columnNumber-1)%26 + 65));
            columnNumber = (columnNumber-1)/26;
        }
        String result = builder.reverse().toString();
        return result;
    }

    public static void main(String[] args) {

        System.out.println(ExcelSheetColumnTitle.convertToTitle(1).equals("A"));
        System.out.println(ExcelSheetColumnTitle.convertToTitle(28).equals("AB"));
        System.out.println(ExcelSheetColumnTitle.convertToTitle(701).equals("ZY"));
        System.out.println(ExcelSheetColumnTitle.convertToTitle(2147483647).equals("FXSHRXW"));

        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) '@');
    }
}

package easy;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int total = 0;
        int base = 1;
        for (int i=columnTitle.length()-1; i>=0; i--) {
            total += base * (columnTitle.charAt(i) - 'A' + 1);
            base *= 26;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnNumber.titleToNumber("A") == 1);
        System.out.println(ExcelSheetColumnNumber.titleToNumber("AB") == 28);
        System.out.println(ExcelSheetColumnNumber.titleToNumber("ZY") == 701);
        System.out.println(ExcelSheetColumnNumber.titleToNumber("FXSHRXW") == 2147483647);
    }
}

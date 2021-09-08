package easy;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            sum = carry;
            if (i >= 0) {
                sum += (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                sum += (b.charAt(j--) - '0');
            }
            carry = sum / 2;
            sum %= 2;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    public static String addBinary_v2(String a, String b) {
        final char ONE = '1';
        final char ZERO = '0';
        int maxLen = Math.max(a.length(), b.length());
        // normalize length
        a = a.length() == maxLen ? a : ("0".repeat(maxLen - a.length()) + a);
        b = b.length() == maxLen ? b : ("0".repeat(maxLen - b.length()) + b);
        String c = "";
        char top = ZERO;
        for (int i = maxLen - 1; i >= 0; i--) {
            if (a.charAt(i) != b.charAt(i)) {   // 0+1 , 1+0
                if (top == ONE) {
                    c = ZERO + c;
                } else {
                    c = ONE + c;
                }
            } else if (a.charAt(i) == ONE){   // 1 + 1
                if (top == ONE) {
                    c = ONE + c;
                } else {
                    c = ZERO + c;
                    top = ONE;
                }
            } else {  // 0 + 0
                if (top == ONE) {
                    c = ONE + c;
                    top = ZERO;
                } else {
                    c = ZERO + c;
                }
            }
        }
        if (top == ONE) {
            c = ONE + c;
        }
        return c;
    }

    public static void main(String[] args) {
//        System.out.println('1' - '0');
//        System.out.println('0' - '0');
        System.out.println(AddBinary.addBinary("11", "1"));  // "100"
        System.out.println(AddBinary.addBinary("1010", "101"));  // "1111"
    }
}

package easy;

public class AddStrings {
    public String addStrings(String num1, String num2) {
//        System.out.print(num1 + " + " + num2 + " = ");
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            carry += num1.charAt(i--)-'0';
            carry += num2.charAt(j--)-'0';
            sb.append(carry % 10);
            carry /= 10;
        }
        while (i >= 0) {
            carry += carry += num1.charAt(i--)-'0';
            sb.append(carry % 10);
            carry /= 10;
        }
        while (j >= 0) {
            carry += num2.charAt(j--)-'0';
            sb.append(carry % 10);
            carry /= 10;
        }
        sb.append((carry == 0) ? "" : "1");

        String result = sb.reverse().toString();
//        System.out.println(result);
        return  result;
    }

    public static void main(String[] args) {
        AddStrings solve = new AddStrings();
        solve.addStrings("111", "999");
        solve.addStrings("9", "1");
        solve.addStrings("1", "99999999");

    }
}


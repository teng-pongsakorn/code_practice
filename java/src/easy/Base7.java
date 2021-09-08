package easy;

public class Base7 {

    public String convertToBase7(int num) {
        if (num < 0) return "-" + convertToBase7(-num);
        if (num < 7) return num+"";
        return convertToBase7(num / 7) + (num % 7);
    }
    public String convertToBase7_v1(int num) {
        if (num == 0) return "0";
        StringBuilder builder = new StringBuilder();
        String sign = num < 0 ? "-" : "";
        num = num < 0 ? -num : num;
        while (num > 0) {
            builder.append(num % 7);
            num /= 7;
        }
        builder.append(sign);
        return builder.reverse().toString();
    }
    public static void main(String[] args) {
        Base7 solution = new Base7();
//        System.out.println(-7 % 7);
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(0));
    }
}

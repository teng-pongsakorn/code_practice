package easy;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int left=0, right=s.length()-1; left < right; ) {
            if (!Character.isLetter(s.charAt(left))) {
                left++;
            } else if (!Character.isLetter(s.charAt(right))) {
                right--;
            } else {
                sb.setCharAt(left, s.charAt(right));
                sb.setCharAt(right, s.charAt(left));
                right--; left++;
            }
        }
        return sb.toString();
    }
    public String reverseOnlyLetters_v1(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left < s.length()) {
            if (!Character.isAlphabetic(s.charAt(left))) {
                sb.append(s.charAt(left++));
            } else if (!Character.isAlphabetic(s.charAt(right))) {
                right--;
            } else {
                sb.append(s.charAt(right--));
                left++;
            }
        }
        return sb.toString();
    }
}

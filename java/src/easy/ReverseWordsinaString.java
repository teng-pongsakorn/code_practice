package easy;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            } else {
                int start = i;
                while (i < chars.length-1 && chars[i+1] != ' ') {
                    i++;
                }
                // swap
                int end = i;
                while (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;
                }
            }
        }
        return new String(chars);
    }
    public String reverseWords_v1(String s) {

        StringBuilder fullBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                fullBuilder.append(wordBuilder.reverse().toString());
                fullBuilder.append(c);
                wordBuilder.setLength(0);
            } else {
                wordBuilder.append(c);
            }
        }
        if (wordBuilder.length() > 0) {
            fullBuilder.append(wordBuilder.reverse().toString());
        }
        return fullBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsinaString sol = new ReverseWordsinaString();
        System.out.println(sol.reverseWords("Let's take LeetCode contest"));
        System.out.println(sol.reverseWords("God Ding"));
//        System.out.println(sol.reverseWords(""));
//        System.out.println(sol.reverseWords(""));
    }
}

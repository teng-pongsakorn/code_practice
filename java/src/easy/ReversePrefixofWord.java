package easy;

public class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int idx = -1;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ch) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return word;
        int start = 0, end = idx;
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReversePrefixofWord sol = new ReversePrefixofWord();
        System.out.println(sol.reversePrefix("abcdefd", 'd'));
        System.out.println(sol.reversePrefix("xyxzxe", 'z'));
        System.out.println(sol.reversePrefix("abcd", 'z'));
//        System.out.println(sol.reversePrefix());
    }
}

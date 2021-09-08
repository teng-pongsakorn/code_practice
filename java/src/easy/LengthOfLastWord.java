package easy;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
//        s = s.trim();
//        int i = s.lastIndexOf(' ');
//        return i==-1 ? s.length() : s.length() - i - 1;
        int i = s.length() - 1;
        int len = 0;
        // remove white space after word
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        // cout length until reaching a space
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        // "Hello World"
        // "a "
        // "a"
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord.lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("   "));
    }
}

package easy;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(s.length());
        for (int i=0; i<s.length(); i++) {
            c -= s.charAt(i);
            c += t.charAt(i);
        }
        return c;
    }
    public char findTheDifference_v1(String s, String t) {
        int result = 0;
        for (char c: s.toCharArray()) {
            result ^= c;
        }
        for (char c: t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }

    public static void main(String[] args) {
        FindTheDifference solve = new FindTheDifference();
        System.out.println(solve.findTheDifference("abcde", "abcdfe"));
        System.out.println(solve.findTheDifference("", "y"));
        System.out.println(solve.findTheDifference("a", "aa"));
        System.out.println(solve.findTheDifference("ae", "aea"));
    }
}

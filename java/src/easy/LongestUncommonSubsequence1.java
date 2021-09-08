package easy;

public class LongestUncommonSubsequence1 {
    public int findLUSlength(String a, String b) {
        if (a.length() > b.length()) return a.length();
        if (b.length() > a.length()) return b.length();
        if (a.equals(b)) return -1;
        return a.length();
    }
}

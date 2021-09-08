package easy;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ascii = new int[26];
        for (char c: magazine.toCharArray()) {
            ascii[c-'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--ascii[c-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote solve = new RansomNote();

        System.out.println(solve.canConstruct("aa", "ab")==false);
        System.out.println(solve.canConstruct("aa", "aab")==true);
    }
}

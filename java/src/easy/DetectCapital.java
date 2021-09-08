package easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) <= 'Z' && word.charAt(0) >= 'A') {
            return allUpper(word.substring(1)) || allLower(word.substring(1));
        }
        return allLower(word.substring(1));
    }

    private boolean allUpper(String text) {
        for (char c: text.toCharArray()) {
            if (!(c <= 'Z' && c >= 'A')) {
                return false;
            }
        }
        return true;
    }

    private boolean allLower(String text) {
        for (char c: text.toCharArray()) {
            if (!(c <= 'z' && c >= 'a')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetectCapital sol = new DetectCapital();
        System.out.println(sol.detectCapitalUse("LEETCODE"));
        System.out.println(sol.detectCapitalUse("leetcode"));
        System.out.println(sol.detectCapitalUse("Leetcode"));
        System.out.println(sol.detectCapitalUse("LeETcOdE"));
    }
}

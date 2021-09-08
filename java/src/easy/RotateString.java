package easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        return (s.length() == goal.length()) && (s.repeat(2).contains(goal));
    }
    public boolean rotateString_v1(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int i = s.length();
        while (i > 0) {
            if (goal.endsWith(s.substring(0, i)) && goal.startsWith(s.substring(i, s.length()))) {
                return true;
            }
            i--;
        }
        return false;
    }

    public static void main(String[] args) {
        RotateString sol = new RotateString();
        String s, goal;

//        Input: s = "abcde", goal = "cdeab"
//        Output: true
        s = "abcde";
        goal = "cdeab";
        System.out.println(sol.rotateString(s, goal));

        s = "abcde";
        goal = "abcde";
        System.out.println(sol.rotateString(s, goal));

        s = "abdce";
        goal = "abcde";
        System.out.println(sol.rotateString(s, goal));
    }
}

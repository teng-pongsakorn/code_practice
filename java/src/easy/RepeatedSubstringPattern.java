package easy;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String s2 = s + s;
        return s2.substring(1, s2.length()-1).contains(s);
    }
    public boolean repeatedSubstringPattern_v1(String s) {
        int midway = s.length()/2;
        for (int i=0; i<midway; i++) {
            // found a candidate
            int size = i+1;
            if (s.charAt(i+1) == s.charAt(0) && s.length()%size==0) {
                boolean isSubstring = true;
                for (int j=0; j<=i; j++) {
                    for (int k=j; k<s.length(); k+=(i+1)) {
                        if (s.charAt(k) != s.charAt(j)) {
                            isSubstring = false;
                        }
                    }
                }
                if (isSubstring) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        RepeatedSubstringPattern solve = new RepeatedSubstringPattern();
        System.out.println(solve.repeatedSubstringPattern("aaaaa") == true);
        System.out.println(solve.repeatedSubstringPattern("abab") == true);
        System.out.println(solve.repeatedSubstringPattern("abcab") == false);
        System.out.println(solve.repeatedSubstringPattern("abcabcabcabc") == true);
        System.out.println(solve.repeatedSubstringPattern("abcabcabcabcj") == false);
    }
}

package easy;

import java.util.ArrayList;
import java.util.List;

//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//        A subsequence of a string is a new string that is formed from the original string
//        by deleting some (can be none) of the characters without disturbing the relative positions
//        of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] charPositions = new List[256];
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (charPositions[c] == null) {
                charPositions[c] = new ArrayList<>();
            }
            charPositions[c].add(i);
        }
        int sIndex = -1;
        for (char c: s.toCharArray()) {
            if (charPositions[c]==null || charPositions[c].size()==0) return false;
            int i=0, pos;
            do {
                pos = charPositions[c].get(i++);
            } while (i < charPositions[c].size() && sIndex > pos);
            if (sIndex > pos) return false;
            sIndex = pos;
        }
        return true;
    }
    public boolean isSubsequence_v1(String s, String t) {
        // empty string case
        if (s.length()==0) return true;

        int tIndex = 0, sIndex = 0;
        while (tIndex < t.length()) {
            if (s.charAt(sIndex)==t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) return true;
            }
            tIndex++;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence solve = new IsSubsequence();
        System.out.println(solve.isSubsequence("abc", "ahbgdc")==true);
        System.out.println(solve.isSubsequence("axc", "ahbgdc")==false);
    }
}

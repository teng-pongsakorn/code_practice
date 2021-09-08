package easy;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() == goal.length()) {
            List<Integer> indices = new ArrayList<>();
            int[] counts = new int[26];
            int mismatchCount = 0;
            boolean hasDuplicate = false;
            for (int i=0; i<s.length(); i++) {
                counts[s.charAt(i)-'a']++;
                if (counts[s.charAt(i)-'a'] > 1) hasDuplicate = true;
                if (s.charAt(i) != goal.charAt(i)) {
                    mismatchCount++;
                    indices.add(i);
                }
                if (mismatchCount > 2) return false;
            }
            if (mismatchCount == 0 && hasDuplicate) {
                return true;
            }
            if (indices.size()==2) {
                int i = indices.get(0);
                int j = indices.get(1);
                return s.charAt(i)==goal.charAt(j) && s.charAt(j)==goal.charAt(i);
            }

        }
        return false;
    }
}

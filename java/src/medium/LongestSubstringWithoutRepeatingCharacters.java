package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[256];
        int maxSize = 0;
        for (int tail=0, head=0; tail<s.length(); tail++) {
            char c = s.charAt(tail);
            if (chars[c] != null && chars[c] >= head) {
                head = chars[c] + 1;
            }
            chars[c] = tail;
            maxSize = Math.max(maxSize, tail - head + 1);
        }
        return maxSize;
    }
    public int lengthOfLongestSubstring_v3(String s) {
        int[] chars = new int[256];
        int maxSize = 0;
        for (int i=0, j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            chars[c]++;
            if (chars[c] > 1) {
                // repeat encounter
                while (i <= j) {
                    chars[s.charAt(i)]--;
                    i++;
                    if (s.charAt(i-1) == c) {
                        break;
                    }
                }
            }
            maxSize = Math.max(j - i + 1, maxSize);
        }
        return maxSize;
    }
    public int lengthOfLongestSubstring_v2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int head=0, tail=0, longest=0;
        while (tail < s.length()) {
            Integer headCandidate = map.put(s.charAt(tail), tail);
            if (headCandidate != null) {
                // check if heacCandidate still in current substring or not
                head = head < headCandidate+1 ? headCandidate + 1 : head;
            }
            int size = tail - head + 1;
            longest = size > longest ? size : longest;
            tail++;
        }
        return longest;
    }
    public int lengthOfLongestSubstring_v1(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, j=0, longest=0;
        while (j < s.length()) {
            if (!set.add(s.charAt(j))) {
                // move i until reach char-j while remove all char along
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i++));
                }
                i++;
            } else {
                longest = j-i+1 > longest ? j-i+1 : longest;
            }
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbbbbbbb"));  // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));  // 3
        System.out.println(solution.lengthOfLongestSubstring(""));  // 0
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt")); // 5
    }
}

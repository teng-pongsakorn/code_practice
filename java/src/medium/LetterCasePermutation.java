package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        if (s == null) return new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        for (int i=0; i<s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                int size = queue.size();
                while (size > 0) {
                    String task = queue.poll();
                    char[] chars = task.toCharArray();
                    chars[i] = Character.toUpperCase(chars[i]);
                    queue.add(String.valueOf(chars));
                    chars[i] = Character.toLowerCase(chars[i]);
                    queue.add(String.valueOf(chars));
                    size--;
                }
            }
        }
        return new LinkedList<>(queue);
    }
    public List<String> letterCasePermutation_v2(String s) {
        List<String> results = new ArrayList<>();
        perm_v3(results, 0, s.toCharArray());
        return results;
    }

    private void perm_v3(List<String> results, int idx, char[] chars) {
        if (idx == chars.length) {
            results.add(new String(chars));
            return;
        }
        if (Character.isAlphabetic(chars[idx])) {
            chars[idx] = Character.toUpperCase(chars[idx]);
            perm_v3(results, idx+1, chars);
            chars[idx] = Character.toLowerCase(chars[idx]);
            perm_v3(results, idx+1, chars);
        } else {
            perm_v3(results, idx+1, chars);
        }
    }

    public List<String> letterCasePermutation_v1(String s) {
        List<String> results = new ArrayList<>();
//        perm(results, "", 0, s);
        perm_v2(results, new StringBuilder(), 0, s);
        return results;
    }
    private void perm_v2(List<String> results, StringBuilder sb, int index, String s) {
        if (sb.length() == s.length()) {
            results.add(sb.toString());
            return;
        }
        if (Character.isLetter(s.charAt(index))) {
            sb.append(Character.toUpperCase(s.charAt(index)));
            perm_v2(results, sb, index+1, s);
            sb.setLength(sb.length()-1);
            sb.append(Character.toLowerCase(s.charAt(index)));
            perm_v2(results, sb, index+1, s);
            sb.setLength(sb.length()-1);
        } else {
            sb.append(s.charAt(index));
            perm_v2(results, sb, index+1, s);
            sb.setLength(sb.length()-1);
        }
    }

    private void perm(List<String> results, String current, int start, String s) {
        if (current.length() == s.length()) {
            results.add(current);
            return;
        }
        if (Character.isLetter(s.charAt(start))) {
            perm(results, current+Character.toUpperCase(s.charAt(start)), start+1, s);
            perm(results, current+Character.toLowerCase(s.charAt(start)), start+1, s);
        } else {
            perm(results, current + s.charAt(start), start+1, s);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation sol = new LetterCasePermutation();
        System.out.println(sol.letterCasePermutation("a1b2"));
        System.out.println(sol.letterCasePermutation("12345"));
        System.out.println(sol.letterCasePermutation("abcd"));
    }
}

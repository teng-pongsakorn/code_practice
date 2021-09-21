package medium;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsofaPhoneNumber {

    Map<Character, String> mapper = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
//    String[] groups = "abc def ghi jkl mno pqrs tuv wxyz".split(" ");
    public List<String> letterCombinations_v3(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int i, StringBuilder builder, List<String> result) {
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char digit = digits.charAt(i);
        String letters = mapper.get(digit);
//        int len = builder.length();
        for (char c: letters.toCharArray()) {
            builder.append(c);
            backtrack(digits, i+1, builder, result);
            builder.setLength(i);
        }
    }

    public List<String> letterCombinations_v2(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        String[] groups = "abc def ghi jkl mno pqrs tuv wxyz".split(" ");
        LinkedList<char[]> result = new LinkedList<>();
        result.add(new char[digits.length()]);
        for (int i=0; i<digits.length(); i++) {
            char[] chars = groups[digits.charAt(i)-'0' - 2].toCharArray();
            int size = result.size();
            while (size > 0) {
                char[] x = result.remove();
                for (char c: chars) {
                    char[] copy = x.clone();
                    copy[i] = c;
                    result.add(copy);
                }
                size--;
            }
        }
        return result.stream().map(x -> new String(x)).collect(Collectors.toList());
    }
    public List<String> letterCombinations(String digits) {
        // char groups for 2 - 9
        String[] groups = "abc def ghi jkl mno pqrs tuv wxyz".split(" ");
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        result.add("");
        for (int i=0; i<digits.length(); i++) {
            char[] chars = groups[digits.charAt(i) - '0' - 2].toCharArray();
            int size = result.size();
            while (size > 0) {
                String x = result.removeFirst();
                for (char c: chars) {
                    result.addLast(x + c);
                }
                size--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        char[] x = new char[3];
        char[] y = x.clone();
        x[0] = 'a';
        y[1] = 'b';
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}

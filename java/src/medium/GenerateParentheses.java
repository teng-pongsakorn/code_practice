package medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    char OPEN = '(';
    char CLOSE = ')';
    int OPEN_INDEX = OPEN - OPEN;
    int CLOSE_INDEX = CLOSE - OPEN;

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        int[] counter = new int[2];
        generate(n*2, new StringBuilder(), counter, result);
        return result;
    }

    private void generate(int remain, StringBuilder builder, int[] counter, List<String> result) {
        // terminate invalid combinations
        int half = (remain + builder.length()) / 2;
        if (counter[OPEN_INDEX] < counter[CLOSE_INDEX] || counter[OPEN_INDEX] > half || counter[CLOSE_INDEX] > half) {
            return;
        }
        // success combination
        if (remain == 0) {
            result.add(builder.toString());
            return;
        }
        // try adding OPEN, then reset to original state
        counter[OPEN_INDEX]++;
        generate(remain - 1, builder.append(OPEN), counter, result);
        counter[OPEN_INDEX]--;
        builder.setLength(builder.length()-1);

        // try adding CLOSE, then reset to original state
        counter[CLOSE_INDEX]++;
        generate(remain-1, builder.append(CLOSE), counter, result);
        builder.setLength(builder.length()-1);
        counter[CLOSE_INDEX]--;
    }

    private boolean invalid(StringBuilder builder, int remain, int[] coun) {
        int n = remain + builder.length();
        // invalid when ')" > "(" or "(" > n/2
        char last = (char) builder.codePointAt(builder.length()-1);
        int openCount = 0;
        int closeCount = 0;
        for (int i=0; i<builder.length(); i++) {
            char c = (char) builder.codePointAt(i);
            if (c == '(') openCount++;
            if (c == ')') closeCount++;
        }
        if (last == ')') {
            return closeCount > openCount;
        }
        return openCount > n/2;
    }

    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        System.out.println(sol.generateParenthesis(1));
        System.out.println(sol.generateParenthesis(2));
        System.out.println(sol.generateParenthesis(3));
        System.out.println(')'-'(');
    }
}

package easy;

import java.util.Stack;

public class CrawlerLogFolder {

    final String BACK = "../";
    final String SAME = "./";

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String s: logs) {
            if (s.equals(SAME)) continue;
            else if (s.equals(BACK)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        return stack.size();
    }
}

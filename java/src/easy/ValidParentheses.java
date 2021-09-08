package easy;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> remains = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') remains.push(')');
            else if (c == '[') remains.push(']');
            else if (c == '{') remains.push('}');
            else {
                if (remains.isEmpty() || c != remains.pop()) {
                    return false;
                }
            }
        }
        return remains.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses paren = new ValidParentheses();
        System.out.println(paren.isValid("()") == true);
        System.out.println(paren.isValid("()[]{}") == true);
        System.out.println(paren.isValid("(]") == false);
        System.out.println(paren.isValid("([)]") == false);
        System.out.println(paren.isValid("{[]}") == true);
    }
}

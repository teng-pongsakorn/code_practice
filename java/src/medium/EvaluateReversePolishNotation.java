package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    final String PLUS = "+";
    final String MINUS = "-";
    final String PRODUCT = "*";
    final String DIVIDE = "/";

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int idx = 0;
        for (String token: tokens) {
            switch (token) {
                case PLUS:
                    stack[idx-2] = stack[idx-2] + stack[idx-1];
                    idx--;
                    break;
                case MINUS:
                    stack[idx-2] = stack[idx-2] - stack[idx-1];
                    idx--;
                    break;
                case PRODUCT:
                    stack[idx-2] = stack[idx-2] * stack[idx-1];
                    idx--;
                    break;
                case DIVIDE:
                    stack[idx-2] = stack[idx-2] / stack[idx-1];
                    idx--;
                    break;
                default:
                    stack[idx++] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }

    public int evalRPN_v1(String[] tokens) {
//        "+", "-", "*", "/"
        Stack<Integer> operands = new Stack<>();
        for (String token: tokens) {
            try {
                operands.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                int second = operands.pop();
                int first = operands.pop();
                int result;
                switch (token) {
                    case PLUS:
                        result = first + second;
                        break;
                    case MINUS:
                        result = first - second;
                        break;
                    case PRODUCT:
                        result = first * second;
                        break;
                    case DIVIDE:
                        result = first / second;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown token: " + token);
                }
                operands.push(result);
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
        String[] tokens;

        tokens = new String[] {"2","1","+","3","*"};
        System.out.println(sol.evalRPN(tokens)==9);

        tokens = new String[] {"4","13","5","/","+"};
        System.out.println(sol.evalRPN(tokens)==6);

        tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sol.evalRPN(tokens)==22);
    }
}

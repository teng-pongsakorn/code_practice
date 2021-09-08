package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        return process(queue);
    }

    private String process(Queue<Character> queue) {
        int numRepeat = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char x = queue.poll();
            if (x == '[') {
                String text = process(queue);
                for (int i=0; i<numRepeat; i++) {
                    sb.append(text);
                }
                numRepeat = 0;
            } else if (x == ']') {
                break;
            } else if (Character.isDigit(x)) {
                numRepeat = 10*numRepeat + (x - '0');
            } else {
                sb.append(x);
            }
        }
        return sb.toString();
    }

    public String decodeString_v1(String s) {
        int PLUS = -1;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '[') continue;
            else if (Character.isDigit(s.charAt(i))) {
                if (i > 0 && (s.charAt(i-1)==']' || Character.isAlphabetic(s.charAt(i-1)))) {
                    numStack.push(PLUS);
                }
                // parse all consecutive digits and push to numStack
                int start = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                numStack.push(Integer.parseInt(s.substring(start, i--)));
            } else if (Character.isAlphabetic(s.charAt(i))) {
                if (i > 0 && s.charAt(i-1)==']') {
                    numStack.push(PLUS);
                }
                // parse all consecutive alphabets and push to strStack
                int start = i;
                while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    i++;
                }
                strStack.push(s.substring(start, i--));
            } else if (s.charAt(i) == ']') {
                String text = strStack.pop();
                int num = numStack.pop();
                while (num == PLUS) {
                    text = strStack.pop() + text;
                    num = numStack.pop();
                }
                strStack.push(text.repeat(num));
            }
        }
        System.out.println(strStack);
        String result = strStack.pop();
        while (!strStack.isEmpty()) {
            result = strStack.pop() + result;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("3[a2[c]]"));
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
        System.out.println(sol.decodeString("abc3[cd]xyz"));
        System.out.println(sol.decodeString("abc10[cd]xyz"));
        System.out.println(sol.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(sol.decodeString("3[2[a]]"));

        // "2[abc]3[cd]ef"
        // "abc3[cd]xyz"
    }
}

package easy;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int i=0, j=s.length-1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public void reverse(char[] s, int i) {
        if (i >= s.length / 2) return ;
        char tmp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = tmp;
        reverse(s, i+1);
    }

    public static void main(String[] args) {

        ReverseString solution = new ReverseString();

        char[] s = "hello".toCharArray();
        System.out.println(Arrays.toString(s));
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}

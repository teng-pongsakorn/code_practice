package easy;

import java.util.*;

public class ReverseVowelOfString {
    public String reverseVowels(String s) {
        Map<Character, Boolean> vowels = new HashMap<>();
        vowels.put('a', true);
        vowels.put('e', true);
        vowels.put('i', true);
        vowels.put('o', true);
        vowels.put('u', true);
        vowels.put('A', true);
        vowels.put('E', true);
        vowels.put('I', true);
        vowels.put('O', true);
        vowels.put('U', true);
        char[] chars = s.toCharArray();
        int head=0, tail=s.length()-1;
        while (head < tail) {
            boolean headIsVowel = vowels.getOrDefault(chars[head], false);
            boolean tailIsVowel = vowels.getOrDefault(chars[tail], false);
            if (!headIsVowel) head++;
            if (!tailIsVowel) tail--;
            if (headIsVowel && tailIsVowel) {
                char tmp = chars[head];
                chars[head] = chars[tail];
                chars[tail] = tmp;
                head++;
                tail--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return (c-'A'==0 || c-'E'==0 || c-'I'==0 || c-'O'==0 || c-'U'==0 ||
                c-'a'==0 || c-'e'==0 || c-'i'==0 || c-'o'==0 || c-'u'==0) ;
    }

    public static void main(String[] args) {
        ReverseVowelOfString solution = new ReverseVowelOfString();
        String s = "leetcode";
        System.out.println(s);
        System.out.println(solution.reverseVowels(s));

        for (char c: "aeiouAEIOU".toCharArray()) {
            System.out.println(c + " = " + ((int) c));
        }
    }

}

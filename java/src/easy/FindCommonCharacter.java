package easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacter {
    public List<String> commonChars(String[] words) {
        char offset = 'a';
        int[][] charCountWords = new int[26][words.length];
        // count char from each word
        for (int wordIndex=0; wordIndex<words.length; wordIndex++) {
            String word = words[wordIndex];
            for (char c: word.toCharArray()) {
                charCountWords[c-offset][wordIndex]++;
            }
        }
        // get common char
        List<String> result = new ArrayList<>();
        for (int charIndex=0; charIndex<charCountWords.length; charIndex++) {
            int min = Integer.MAX_VALUE;
            for (int wordIndex=0; wordIndex<words.length; wordIndex++) {
                min = charCountWords[charIndex][wordIndex] < min ? charCountWords[charIndex][wordIndex] : min;
            }
            for (int repeat=0; repeat<min; repeat++) {
                result.add(String.valueOf((char) (charIndex+offset)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacter solve = new FindCommonCharacter();
        String[] words = {"bella","label","roller"};
        System.out.println(solve.commonChars(words));
        words = new String[]{"cool","lock","cook"};
        System.out.println(solve.commonChars(words));
    }
}

package medium;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isPossible = new boolean[s.length()+1];
        isPossible[0] = true;
        for (int i=0; i<isPossible.length; i++) {
            if (isPossible[i]) {
                String sub = s.substring(i);
                for (String word: wordDict) {
                    if (sub.startsWith(word) && i+word.length() <= s.length()) {
                        isPossible[i + word.length()] = true;
                    }
                }
            }
        }
        return isPossible[s.length()];
    }
}

package easy;

public class ShortestCompletingString {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        String shortest = "?".repeat(16);
        for (String word: words) {
            if (word.length() < shortest.length() && isCompletingWord(licensePlate, word)) {
                shortest = word;
            }
        }
        return shortest;
    }

    private boolean isCompletingWord(String licensePlate, String word) {
        int[] chars = new int[26];
        int count = 0;
        for (char c: licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                chars[c-'a']++;
                count++;
            }
        }
        for (char c: word.toCharArray()) {
            if (chars[c-'a'] > 0) {
                chars[c-'a']--;
                count--;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}

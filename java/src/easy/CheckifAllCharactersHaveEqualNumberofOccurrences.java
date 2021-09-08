package easy;

public class CheckifAllCharactersHaveEqualNumberofOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        int countMax = -1;
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
            countMax = counts[c - 'a'] > countMax ? counts[c - 'a'] : countMax;
        }
        for (int n: counts) {
            if (n > 0 && n != countMax) {
                return false;
            }
        }
        return true;
    }
}

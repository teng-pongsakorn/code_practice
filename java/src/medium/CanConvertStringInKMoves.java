package medium;

public class CanConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] availableMoves = new int[26+1];
        int x = k / 26;
        for (int i=1; i<availableMoves.length; i++) {
            availableMoves[i] = x;
        }
        for (int i=1; i<=k%26; i++) {
            availableMoves[i]++;
        }
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
                if (availableMoves[shift] == 0) {
                    return false;
                }
                availableMoves[shift]--;
            }
        }
        return true;
    }
}

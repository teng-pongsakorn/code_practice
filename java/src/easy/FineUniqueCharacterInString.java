package easy;

public class FineUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char c: s.toCharArray()) {
            charCount[c-'a']++;
        }
        for (int i=0; i<s.length(); i++) {
            if (charCount[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FineUniqueCharacterInString solve = new FineUniqueCharacterInString();

        System.out.println(solve.firstUniqChar("hello") == 0);
        System.out.println(solve.firstUniqChar("loveleetcode")==2);
        System.out.println(solve.firstUniqChar("aabb") == -1);
    }
}


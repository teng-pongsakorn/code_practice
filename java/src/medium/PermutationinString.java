package medium;

import java.util.Arrays;

public class PermutationinString {

    public boolean checkInclusion_v1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        for (char c: s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        for (int i=0; i<s2.length(); i++) {
            if (i < s1.length()) {
                countS2[s2.charAt(i)-'a']++;
            } else {
                // check if equal countS1
                // if true -> return true
                if (isEqual(countS1, countS2)) {
                    return true;
                }
                // else -> add new char & remove head char
                countS2[s2.charAt(i) - 'a']++;
                countS2[s2.charAt(i-s1.length()) - 'a']--;
            }
        }
        return isEqual(countS1, countS2);
    }

    public boolean checkInclusion_v2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        int sizeCount = 0;
        for (char c: s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        System.out.println("S1 count: " + Arrays.toString(countS1));
        for (int i=0; i<s2.length(); i++) {
            System.out.println("i=" + i + " char:" + s2.charAt(i) + " count: " + Arrays.toString(countS2));
            if (countS1[s2.charAt(i) - 'a'] > 0) {
                sizeCount++;
                countS2[s2.charAt(i) - 'a']++;
                if (sizeCount == s1.length()) {
                    int invalidIndex = findMismatchIndex(countS1, countS2);
                    if (invalidIndex == -1) {
                        return true;
                    } else {
                        // start-index = i - (sizeCount - 1);
                        // target char = (char) invalidIndex + 'a';
                        // remove all chars from countS2 up to the first target char (inclusive);
                        System.out.println("mismatch invalidIndex=" + invalidIndex + "(char=" + (char)(invalidIndex+'a') + ")" + " countSize=" + sizeCount);
                        for (int j=i-(sizeCount-1); j<=i; j++) {
                            sizeCount--;
                            countS2[s2.charAt(j)-'a']--;
                            if (s2.charAt(j)-'a' == invalidIndex) {
                                break;
                            }
                        }
                    }
                }
            } else {
                sizeCount = 0;
                countS2 = new int[26];
            }
        }
        return (sizeCount == s1.length()) && (findMismatchIndex(countS1, countS2) == -1);
    }

    public boolean checkInclusion_v3(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        int sizeCount = 0;
        for (char c: s1.toCharArray()) {
            countS1[c - 'a']++;
        }
        for (int i=0; i<s2.length(); i++) {
            if (countS1[s2.charAt(i) - 'a'] > 0) {
                sizeCount++;
                countS2[s2.charAt(i) - 'a']++;
                if (countS2[s2.charAt(i) - 'a'] > countS1[s2.charAt(i) - 'a']) {
                    for (int j=i-(sizeCount-1); j<=i; j++) {
                        sizeCount--;
                        countS2[s2.charAt(j)-'a']--;
                        if (s2.charAt(i) == s2.charAt(j)) {
                            break;
                        }
                    }
                }
                if (sizeCount == s1.length()) {
                    return true;
                }
            } else {
                sizeCount = 0;
                countS2 = new int[26];
            }
        }
        return false;
    }

    private int findMismatchIndex(int[] countS1, int[] countS2) {
        for (int i=0; i<countS1.length; i++) {
            // whenever mismatch, there're always 2 places, so select the one that was overcount from s2
            if (countS1[i] != countS2[i] && countS2[i] > countS1[i]) return i;
        }
        // both arrays are equal
        return -1;
    }

    private boolean isEqual(int[] countS1, int[] countS2) {
        for (int i=0; i<countS1.length; i++) {
            if (countS1[i] != countS2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] counts = new int[26];
        int count = s1.length();
        for (int i=0; i<s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (allZero(counts)) return true;
        for (int i=s1.length(); i<s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(counts)) return true;
        }
        return false;
    }

    private boolean allZero(int[] counts) {
        for (int n: counts) {
            if (n != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationinString sol = new PermutationinString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(sol.checkInclusion(s1, s2) == true);

        s2 = "eidboaoo";
        System.out.println(sol.checkInclusion(s1, s2) == false);

        System.out.println(sol.checkInclusion(s2, s1) == false);
        System.out.println(sol.checkInclusion("abcd", "eidcbdaoij") == true);
        System.out.println(sol.checkInclusion("adc", "dcda") == true);




    }
}

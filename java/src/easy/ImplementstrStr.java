package easy;

import java.util.Arrays;

class KMP {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        int[] lps = makeLPS(needle);
        int n = haystack.length();
        int m = needle.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
            if (j == m) {
                return i-j;
            }
        }
        return -1;
    }

    public static int[] makeLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (needle.charAt(len) == needle.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    i++;
                } else {
                    len = lps[len-1];
                }
            }
        }
        return lps;
    }
}

public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        int len = haystack.length() - needle.length();
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    i += j;
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStr_v2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        int len = haystack.length() - needle.length();
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStr_v1(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int i = 0;
        while (!haystack.startsWith(needle)) {
            haystack = haystack.substring(1);
            i++;
            if (haystack.length() < needle.length()) {
                return -1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(ImplementstrStr.strStr("hello", "ll"));
        System.out.println(ImplementstrStr.strStr("hello", "x"));
        System.out.println(ImplementstrStr.strStr("", ""));
        System.out.println(ImplementstrStr.strStr("", "a"));

        // aaac -> [0, 1, 2, 0]
        System.out.println(Arrays.toString(KMP.makeLPS("aaac")) + ": expect [0, 1, 2, 0]");
        // abcab -> [0, 0, 0, 1, 2]
        System.out.println(Arrays.toString(KMP.makeLPS("abcab")) + ": expect [0,0,0,1,2]");
        // aaacbaaaaac -> [0, 1, 2, 0, 0, 1, 2, 3, 3, 3, 4]
        System.out.println(Arrays.toString(KMP.makeLPS("aaacbaaaaac")) + ": expect [0, 1, 2, 0, 0, 1, 2, 3, 3, 3, 4]");
        System.out.println(KMP.strStr("hello", "ll"));
        System.out.println(KMP.strStr("hello", "x"));
        System.out.println(KMP.strStr("", ""));
        System.out.println(KMP.strStr("", "a"));
    }
}

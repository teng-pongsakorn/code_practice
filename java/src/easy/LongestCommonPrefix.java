package easy;

public class LongestCommonPrefix {

//    public String longestCommonPrefix(String[] strs) {
//        String result = strs[0];
//        for (String newStr: strs) {
//            result = findCommon(result, newStr);
//            if (result.length() == 0) {
//                return result;
//            }
//        }
//        return result;
//    }
//
//    private String findCommon(String str1, String str2) {
//        int len = Math.min(str1.length(), str2.length());
//        for (int i = 0; i < len; i++) {
//            if (str1.charAt(i) != str2.charAt(i)) {
//                return str1.substring(0, i);
//            }
//        }
//        return str1.substring(0, len); // builder.toString();
//    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    public String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftCommon = longestCommonPrefix(strs, left, mid);
        String rightCommon = longestCommonPrefix(strs, mid+1, right);
        return findCommon(leftCommon, rightCommon);
    }

    private String findCommon(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, minLen);
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[] {"flower","flow","flight"}).equals("fl"));
        System.out.println(lcp.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[] {"dog","racecar","car"}).equals(""));
        System.out.println(lcp.longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}

package easy;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            // get alphanumeric from left
            while (i < s.length() && !(isAlpha(s.charAt(i)) || isNum(s.charAt(i)))) {
                i++;
            }
            // get alphanumeric from right
            while (j >= 0 && !(isAlpha(s.charAt(j)) || isNum(s.charAt(j)))) {
                j--;
            }
            if (i < j && (s.charAt(i) != s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isNum(char c) {
        int aInt = (int) 'a';
        int zInt = (int) 'z';
        int val = (int) c;
        return val >= aInt && val <= zInt;
    }

    private static boolean isAlpha(char c) {
        int zeroInt = (int) '0';
        int nineInt = (int) '9';
        int val = (int) c;
        return val >= zeroInt && val <= nineInt;
    }

    public static void main(String[] args) {
        System.out.println(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));  // true
        System.out.println(ValidPalindrome.isPalindrome("race a car"));  // false
        System.out.println(ValidPalindrome.isPalindrome(".,"));   // true
//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
//        System.out.println((int) '0');
//        System.out.println((int) '9');
//        System.out.println('z' > 'a');
    }
}

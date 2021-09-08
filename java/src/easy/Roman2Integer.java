package easy;

import java.security.InvalidParameterException;

public class Roman2Integer {

    public int romanToInt(String s) {
        int total = 0;
        int prev = 1000;
        int current;
        for (int i = 0; i < s.length(); i++) {
            current = getValue(s.charAt(i));
            total += current;
            if (prev < current) {
                // undo previous addition & subtract from current
                total = total - prev - prev;
            }
            prev = current;
        }
        return total;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new InvalidParameterException("invalid roman character: " + c);
        }
    }

    // test
    public static void main(String[] args) {
        Roman2Integer sol = new Roman2Integer();
        System.out.println(sol.romanToInt("III") == 3);
        System.out.println(sol.romanToInt("IV") == 4);
        System.out.println(sol.romanToInt("IX") == 9);
        System.out.println(sol.romanToInt("LVIII") == 58);
        System.out.println(sol.romanToInt("MCMXCIV") == 1994);
        System.out.println(sol.romanToInt("MCMXCIV"));
//        assert sol.romanToInt("III") == 3;
//        assert sol.romanToInt("IV") == 4;
//        assert sol.romanToInt("IX") == 9;
//        assert sol.romanToInt("LVIII") == 58;
//        assert sol.romanToInt("MCMXCIV") == 1994;
    }
}

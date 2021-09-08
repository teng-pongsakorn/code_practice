package easy;

import java.util.*;

public class IsomorphicStrings {

    public static boolean isIsomorphic_v1(String s, String t) {
        Map<Character, Character> sMapper = new HashMap<>();
        Map<Character, Character> tMapper = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            boolean hasS = sMapper.containsKey(sChar);
            boolean hasT = tMapper.containsKey(tChar);
            if (!hasS && !hasT) {
                sMapper.put(sChar, tChar);
                tMapper.put(tChar, sChar);
            } else if (!hasS || !hasT) {
                return false;
            }else if (sMapper.get(sChar)!=tChar || tMapper.get(tChar)!=sChar) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        Integer[] sMapper = new Integer[127];
        Integer[] tMapper = new Integer[127];
        int count = 0;
        char sChar, tChar;
        for (int i=0; i<s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (sMapper[sChar]==null && tMapper[tChar]==null) {
                sMapper[sChar] = count;
                tMapper[tChar] = count;
                count++;
            } else if (sMapper[sChar]==null || tMapper[tChar]==null) {
                return false;
            } else if (sMapper[sChar] != tMapper[tChar]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(IsomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(IsomorphicStrings.isIsomorphic("badc", "baba"));
        System.out.println('1' - 'a');
    }
}

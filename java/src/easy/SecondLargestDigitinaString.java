package easy;

import java.util.TreeSet;

public class SecondLargestDigitinaString {
    public int secondHighest_v2(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                set.add(s.charAt(i)-'0');
                System.out.println(set);
            }
        }
        set.pollLast();
        System.out.println(set);
        return set.isEmpty() ? -1 : set.pollLast();
    }
    public int secondHighest(String s) {
        Integer firstMax = null;
        Integer secondMax = null;
        for (char c: s.toCharArray()) {
            System.out.println("firstMax="+firstMax + " secondMax=" + secondMax);
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (firstMax == null || digit > firstMax) {
                    secondMax = firstMax;
                    firstMax = digit;
                } else if (digit == firstMax) {
                    continue;
                } else if (secondMax == null || digit > secondMax) {
                    secondMax = digit;
                }
            }
        }
        return secondMax == null ? -1 : secondMax;
    }
}

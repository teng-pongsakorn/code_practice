package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    static final int[] hourMinutes = {8,4,2,1,32,16,8,4,2,1};
    static final int sizeHour = 4;

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        helper(result, 0, 0, 0, turnedOn);
        return result;
    }

    private static void helper(List<String> result, int hour, int minute, int startIndex, int turnedOn) {
        if (turnedOn == 0) {
            result.add(hour + ":" + (minute < 10 ? "0"+minute : minute));
            return;
        }
        for (int i=startIndex; i<hourMinutes.length; i++) {

            if (i < sizeHour) {    // hour
                if (hour + hourMinutes[i] < 12) {
                    helper(result, hour+hourMinutes[i], minute, i+1, turnedOn-1);
                }
            } else {        // minute
                if (minute + hourMinutes[i] < 60) {
                    helper(result, hour, minute+hourMinutes[i], i+1, turnedOn-1);
                }
            }
        }
    }

    public static List<String> readBinaryWatch_v1(int turnedOn) {
        List<Integer> candidates = getCandidates(turnedOn);
        List<String> result = new ArrayList<>();
        for (Object s: candidates.stream().map(BinaryWatch::num2Time).toArray()) {
            if (s != null) {
                result.add((String) s);
            }

        }
        return result;
    }

    private static String num2Time(int num) {
        int hour = num >> 6;
        int minutes = num & 0x3f;
//        System.out.println("num=" + num + " -> hour=" + hour + ", minutes=" + minutes);
        if (hour >= 12 || minutes > 59) {
            return null;
        }
        return hour+":"+((minutes < 10) ? "0"+minutes : minutes);
//        return String.format("%d:%02d", hour, minutes);
    }

    private static List<Integer> getCandidates(int turnedOn) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<1024; i++) {
            if (getNumBits(i) == turnedOn) {
                result.add(i);
            }
        }
        return result;
    }

    private static int getNumBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf("1111111111", 2));
//        System.out.println(0x03ff & Integer.MAX_VALUE);
//        System.out.println(0x3f & Integer.MAX_VALUE);
//        System.out.println(15 & (6 >> Integer.MAX_VALUE));
//        Map<Integer, Integer> countDict = new HashMap<>();
//        Map<Integer, List<Integer>> countToNums = new HashMap<>();
//        for (int i=0; i<1024; i++) {
//            int k = getNumBits(i);
//            countDict.put(k, countDict.getOrDefault(k, 0) + 1);
//            if (!countToNums.containsKey(k)) {
//                countToNums.put(k, new ArrayList<>());
//            }
//            countToNums.get(k).add(i);
//        }
//        System.out.println(countDict);
//        for (int key: countToNums.keySet()) {
//            System.out.println("key: " + key);
//            System.out.println(countToNums.get(key));
//            System.out.println("=".repeat(50));
//        }
//
//        System.out.println(Integer.toBinaryString(383));
//        System.out.println(Integer.toBinaryString(383 >> 6));   // get hour
//        System.out.println(383 >> 6);
//        System.out.println(Integer.toBinaryString(383 & 0x3f)); // get minute
//        System.out.println(383 & 0x3f);

        System.out.println("*".repeat(40));
        for (int i=0; i<=10; i++) {
            System.out.println(i + " => " + BinaryWatch.readBinaryWatch(i));
        }
    }


}

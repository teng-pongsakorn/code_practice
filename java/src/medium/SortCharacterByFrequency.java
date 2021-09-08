package medium;

import java.util.*;

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c: s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(counter.size(),
                                                                                (entry1, entry2)->entry2.getValue()-entry1.getValue());
        for (Map.Entry<Character, Integer> entry: counter.entrySet()) {
            queue.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i=0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public String frequencySort_v2(String s) {
        // charIdx: [charIdx, count]
        int[][] asciiCount = new int[128][2];
        for (char c: s.toCharArray()) {
            asciiCount[c][0] = c;
            asciiCount[c][1]++;
        }

        // sort by count
        Arrays.sort(asciiCount, (a, b) -> b[1]-a[1]);

        // make result string
        StringBuilder sb = new StringBuilder();
        for (int[] charCount: asciiCount) {
            if (charCount[1] > 0) {
                for (int i=0; i<charCount[1]; i++) {
                    sb.append(Character.toChars(charCount[0]));
                }
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public String frequencySort_v1(String s) {
        // asciiCount each alphabet
        int[] asciiCount = new int[128];
        for (char c: s.toCharArray()) {
            asciiCount[c]++;
        }
        // sort chars by asciiCount
        Integer[] ascii = new Integer[128];
        for (int i=0; i<ascii.length; i++) ascii[i] = i;
        Arrays.sort(ascii, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -Integer.compare(asciiCount[a], asciiCount[b]);
            }
        });
        // rebuild string
        StringBuilder sb = new StringBuilder();
        for (Integer c: ascii) {
            if (asciiCount[c] > 0) {
                sb.append((Character.toString(c)).repeat(asciiCount[c]));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharacterByFrequency solve = new SortCharacterByFrequency();
        String s = "tree";
        System.out.println(s + " -> " + solve.frequencySort(s));

        s = "cccaaa";
        System.out.println(s + " -> " + solve.frequencySort(s));

        s = "Aabb";
        System.out.println(s + " -> " + solve.frequencySort(s));

        s = "loveleetcode";
        System.out.println(s + " -> " + solve.frequencySort(s));
    }
}

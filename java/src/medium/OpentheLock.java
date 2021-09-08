package medium;

import java.util.*;

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target.equals(start)) return 0;

        Set<String> visited = new HashSet<>();
        for (String s: deadends) {
            visited.add(s);
        }
        Queue<char[]> queue = new LinkedList<>();
        if (!visited.contains(start)) {
            queue.add(start.toCharArray());
            visited.add(start);
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size > 0) {
                char[] current = queue.poll();
                for (String s: neighbor(current)) {
                    if (!visited.contains(s)) {
                        queue.add(s.toCharArray());
                        visited.add(s);
                    }
                    if (s.equals(target)) {
//                        System.out.println("depth=" + depth);
                        return depth;
                    }
                }
                size--;
            }
        }
        return -1;
    }

    private String[] neighbor(char[] lock) {
        String[] result = new String[8];
        int idx = 0;
        for (int i=0; i<lock.length; i++) {
            char original = lock[i];
            int x = lock[i] - '0';
            lock[i] = (char) (((x + 1) % 10) + '0');
            result[idx++] = new String(lock);
            lock[i] = (char) (((x - 1 + 10) % 10) + '0');
            result[idx++] = new String(lock);
            lock[i] = original;
        }
//        System.out.println("next: " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        OpentheLock sol = new OpentheLock();
        String[] deadends;
        String target;

        deadends = new String[] {"0201","0101","0102","1212","2002"};
        target = "0202";
        System.out.println(sol.openLock(deadends, target)==6);

        deadends = new String[] {"8888"};
        target = "0009";
        System.out.println(sol.openLock(deadends, target)==1);

        deadends = new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"};
        target = "8888";
        System.out.println(sol.openLock(deadends, target)==-1);

        deadends = new String[] {"0000"};
        target = "8888";
        System.out.println(sol.openLock(deadends, target)==-1);

//        System.out.println('1' - '0');
    }
}

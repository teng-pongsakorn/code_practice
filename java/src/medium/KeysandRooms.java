package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numRemains = rooms.size();
        boolean[] visited = new boolean[numRemains];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        numRemains--;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int room = queue.poll();
                for (int n: rooms.get(room)) {
                    if (!visited[n]) {
                        queue.add(n);
                        numRemains--;
                        visited[n] = true;
                        if (numRemains == 0) return true;
                    }
                }
                size--;
            }
        }
        return numRemains == 0;
    }
}

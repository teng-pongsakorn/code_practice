package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    class Point implements Comparable{
        int row;
        int col;
        int cost;
        int step;
        Point parent;

        public Point(int row, int col, int cost, Point parent) {
            this.row = row;
            this.col = col;
            this.step = parent == null ? 1 : parent.step + 1;
            this.cost = cost + this.step;
            this.parent = parent;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(cost, ((Point) o).cost);
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] neighbors = {0,-1,1,1,-1,-1,0,1,0};
       int n = grid.length;

       // impossible to reach the destination
       if (grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;

       PriorityQueue<Point> queue = new PriorityQueue<>();
       queue.add(new Point(0, 0, distance(0, 0, n), null));
       while (!queue.isEmpty()) {
           Point current = queue.poll();
           if (grid[current.row][current.col] == 1) {
               continue;
           }
           grid[current.row][current.col] = 1;
           if (current.row == n-1 && current.col == n-1) {
               return countPath(current);
           }
           for (int i=1; i<neighbors.length; i++) {
               int rNew = current.row + neighbors[i];
               int cNew = current.col + neighbors[i-1];
               if (rNew >= 0 && cNew >= 0 && rNew < n && cNew < n && grid[rNew][cNew]==0) {
                   queue.add(new Point(rNew, cNew, distance(rNew, cNew, n), current));
               }
           }
       }
       return -1;
    }

    private int countPath(Point point) {
        int count = 0;
        while (point != null) {
            count++;
            point = point.parent;
        }
        return count;
    }

    private int distance(int r, int c, int n) {
        // compute distance from (0,0) -> (r,c)
        // compute distance from (r,c) -> (n-1, n-1)
        // return combined distance
        return dist(r, c, n-1, n-1);
    }

    private int dist(int r1, int c1, int r2, int c2) {
        int r = Math.abs(r1 - r2);
        int c = Math.abs(c2 - c1);
        int min = Math.min(r, c);
        int max = Math.max(r, c);
        return min + (max - min);
    }

    public int shortestPathBinaryMatrix_v2(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1) return -1;
        if (n == 1) return 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        grid[0][0] = 1;
        int path = 1;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size > 0) {
                int i = queue.poll();
                for (int[] coord: getValidNeighbors(i, grid)) {
                    int idx = coord[0] * n + coord[1];
                    if (idx == n*n-1) return path;
                    queue.add(idx);
                }
                size--;
            }
        }
        return -1;
    }

    private List<int[]> getValidNeighbors(int idx, int[][] grid) {
        int r = idx / grid.length;
        int c = idx % grid.length;
        List<int[]> result = new LinkedList<>();
        int[] neigh = {0,-1,1,1,-1,-1,0,1,0};
        for (int i=1; i<neigh.length; i++) {
            int rNew = r + neigh[i];
            int cNew = c + neigh[i-1];
            if (rNew >= 0 && cNew >= 0 && cNew < grid.length && rNew < grid.length && grid[rNew][cNew]==0) {
                result.add(new int[] {rNew, cNew});
                grid[rNew][cNew] = 1;
            }
        }
        return result;
    }

    public int shortestPathBinaryMatrix_v1(int[][] grid) {
        int n = grid.length;
        int destination = n * n - 1;
        if (grid[0][0] == 1) return -1;
        if (destination == 0) return 1;
        boolean[] visited = new boolean[n*n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int path = 1;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size > 0) {
                int idx = queue.poll();
                int r = idx / n;
                int c = idx % n;
                for (int[] rc: neighbors(r, c, n)) {
                    int j = rc[0] * n + rc[1];
                    if (!visited[j] && grid[j/n][j%n]==0) {
                        if (j == destination) return path;
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                size--;
            }
        }
        return -1;
    }

    private List<int[]> neighbors(int r, int c, int n) {
        List<int[]> result = new LinkedList<>();
        int[] set1 = {0,-1,0,1,0};
        int[] set2 = {1,-1,-1,1,1};
        for (int i=1; i<set1.length; i++) {
            int rNew = r + set1[i];
            int cNew = c + set1[i-1];
            if (rNew >= 0 && cNew >= 0 && rNew < n && cNew < n) {
                result.add(new int[] {rNew, cNew});
            }
        }
        for (int i=1; i<set2.length; i++) {
            int rNew = r + set2[i];
            int cNew = c + set2[i-1];
            if (rNew >= 0 && cNew >= 0 && rNew < n && cNew < n) {
                result.add(new int[] {rNew, cNew});
            }
        }
        return result;
    }
}

//[[0,0,1,0,0,0,0],[0,1,0,0,0,0,1],[0,0,1,0,1,0,0],[0,0,0,1,1,1,0],[1,0,0,1,1,0,0],[1,1,1,1,1,0,1],[0,0,1,0,0,0,0]]

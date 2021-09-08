package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class O1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] nearestMat = new int[mat.length][mat[0].length];
        Queue<Integer> queue = new LinkedList<>();
        int VISITED = -1;
        int depth = 0;

        // get all 0
        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (mat[r][c] == 0) {
                    queue.add(m*r + c);
                    mat[r][c] = VISITED;
                }
            }
        }

        // breadth first traverse
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int idx = queue.poll();
                int r = idx / m;
                int c = idx % m;
                nearestMat[r][c] = depth;
                // check all neighbor -> add to queue if not visited
                int neighborIdx;
                if (r - 1 >= 0) {
                    neighborIdx = m * (r - 1) + c;
                    if (mat[r-1][c] != VISITED) {
                        queue.add(neighborIdx);
                        mat[r-1][c] = VISITED;
                    }
                }
                if (r + 1 < n) {
                    neighborIdx = m * (r + 1) + c;
                    if (mat[r+1][c] != VISITED) {
                        queue.add(neighborIdx);
                        mat[r+1][c] = VISITED;
                    }
                }
                if (c - 1 >= 0) {
                    neighborIdx = m * r + c - 1;
                    if (mat[r][c-1] != VISITED) {
                        queue.add(neighborIdx);
                        mat[r][c-1] = VISITED;
                    }
                }
                if (c + 1 < m) {
                    neighborIdx = m * r + c + 1;
                    if (mat[r][c+1] != VISITED) {
                        queue.add(neighborIdx);
                        mat[r][c+1] = VISITED;
                    }
                }
                levelSize--;
            }
            depth++;
        }
        return nearestMat;
    }
    public int[][] updateMatrix_v1(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] nearestMat = new int[mat.length][mat[0].length];
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;

        // get all 0
        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                if (mat[r][c] == 0) {
                    queue.add(m*r + c);
                    visited.add(m*r+c);
                }
            }
        }

        // breadth first traverse
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int idx = queue.poll();
                int r = idx / m;
                int c = idx % m;
                nearestMat[r][c] = depth;
                // check all neighbor -> add to queue if not visited
                int neighborIdx;
                if (r - 1 >= 0) {
                    neighborIdx = m * (r - 1) + c;
                    if (!visited.contains(neighborIdx)) {
                        queue.add(neighborIdx);
                        visited.add(neighborIdx);
                    }
                }
                if (r + 1 < n) {
                    neighborIdx = m * (r + 1) + c;
                    if (!visited.contains(neighborIdx)) {
                        queue.add(neighborIdx);
                        visited.add(neighborIdx);
                    }
                }
                if (c - 1 >= 0) {
                    neighborIdx = m * r + c - 1;
                    if (!visited.contains(neighborIdx)) {
                        queue.add(neighborIdx);
                        visited.add(neighborIdx);
                    }
                }
                if (c + 1 < m) {
                    neighborIdx = m * r + c + 1;
                    if (!visited.contains(neighborIdx)) {
                        queue.add(neighborIdx);
                        visited.add(neighborIdx);
                    }
                }
                levelSize--;
            }
            depth++;
        }

        return nearestMat;
    }
}

package medium;

public class UniquePaths {
    public int uniquePaths_memo(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        memo[1][1] = 1;
        return uniquePaths(m, n, memo);
    }

    private int uniquePaths(int m, int n, int[][] memo) {
        if (m < 1 || n < 1) return 0;
        if (memo[m][n] > 0) return memo[m][n];
        memo[m][n] = uniquePaths(m-1, n, memo) + uniquePaths(m, n-1, memo);
        return memo[m][n];
    }

    public int uniquePath_dp(int m, int n) {
        int[][] path = new int[m+1][n+1];
        for (int row=1; row<=m; row++) {
            for (int col=1; col<=n; col++) {
                if (row == 1 || col == 1) {
                    path[row][col] = 1;
                } else {
                    path[row][col] = path[row-1][col] + path[row][col-1];
                }
            }
        }
        return path[m][n];
    }
}

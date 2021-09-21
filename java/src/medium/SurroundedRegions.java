package medium;

public class SurroundedRegions {
    final char X = 'X';
    final char O = 'O';
    final char Y = 'Y';
    public void solve(char[][] board) {
        solve_bfs(board);
    }

    private void solve_bfs(char[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;

        // check first & last rows
        for (int c=0; c<numCols; c++) {
            if (board[0][c] == 'O') {
                flip(board, 0, c);
            }
            if (board[numRows-1][c] == 'O') {
                flip(board, numRows-1, c);
            }
        }
        // check first & last columns
        for (int r=0; r<numRows; r++) {
            if (board[r][0] == 'O') {
                flip(board, r, 0);
            }
            if (board[r][numCols-1] == 'O') {
                flip(board, r, numCols-1);
            }
        }
        // convert Y->O, O->X
        for (int r=0; r<numRows; r++) {
            for (int c=0; c<numCols; c++) {
                if (board[r][c] == Y) {
                    board[r][c] = O;
                } else if (board[r][c] == O) {
                    board[r][c] = X;
                }
            }
        }
    }

    private void flip(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != O) return;

        board[r][c] = Y;
        flip(board, r+1, c);
        flip(board, r-1, c);
        flip(board, r, c+1);
        flip(board, r, c-1);
    }

//    private void flip(char[][] board, int r, int c) {
//        int[] neighbor = {0,1,0,-1,0};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{r,c});
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                int[] coord = queue.poll();
//                size--;
//                if (board[coord[0]][coord[1]] != O) continue;
//                board[coord[0]][coord[1]] = Y;
//                for (int i=1; i<neighbor.length; i++) {
//                    int rNew = coord[0] + neighbor[i];
//                    int cNew = coord[1] + neighbor[i-1];
//                    if (rNew>=0 && rNew<board.length && cNew>=0 && cNew<board[0].length && board[rNew][cNew] == O) {
//                        queue.add(new int[] {rNew, cNew});
//                    }
//                }
//            }
//        }
//    }
}

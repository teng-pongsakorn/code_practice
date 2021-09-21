package medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && found(board, new boolean[board.length][board[0].length], i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean found(char[][] board, boolean[][] visited, int i, int j, String word, int wordIndex) {
        System.out.println("search i=" + i + " j=" + j + " word: " + word + " [" + wordIndex + "]");
        if (wordIndex == word.length()-1 && board[i][j] == word.charAt(wordIndex)) {
            return true;
        }
        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int[] NEWS = {0,-1,0,1,0};
        for (int k=1; k<NEWS.length; k++) {
            int iNew = i + NEWS[k];
            int jNew = j + NEWS[k-1];
            if (iNew >= 0 && jNew >= 0 && iNew < board.length && jNew < board[0].length
                    && !visited[iNew][jNew] && word.charAt(wordIndex+1) == board[iNew][jNew]) {
                if (found(board, visited, iNew, jNew, word, wordIndex+1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}

class Solution {
    boolean[][] safe;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        safe = new boolean[ROWS][COLS];
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (x == 0 || y == 0 || x == ROWS - 1 || y == COLS - 1) {
                    dfs(board, x, y);
                }

            }
        }

        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (!safe[x][y]) {
                    board[x][y]='X';
                }

            }
        }

    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= ROWS || y >= COLS) {
            return;
        }

        if (safe[x][y]) {
            return;
        }
        if (board[x][y] == 'O') {
            safe[x][y]=true;
            for (int[] d : directions) {
                dfs(board, x + d[0], y + d[1]);
            }
        }
    }
}

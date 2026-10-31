class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (x == 0 || y == 0 || x == ROWS - 1 || y == COLS - 1) {
                    dfs(board, x, y);
                }

            }
        }

        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (board[x][y]=='T') {
                    board[x][y]='O';
                }else if (board[x][y]=='O') {
                    board[x][y]='X';
                }

            }
        }

    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= ROWS || y >= COLS) {
            return;
        }

        if (board[x][y]=='T') {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y]='T';
            for (int[] d : directions) {
                dfs(board, x + d[0], y + d[1]);
            }
        }
    }
}

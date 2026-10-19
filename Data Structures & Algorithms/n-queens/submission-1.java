class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        StringBuilder[] board = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            board[i] = new StringBuilder();
            for (int j = 0; j < n; j++) {
                board[i].append(".");
            }
        }
        backtrack(board, n, 0, 0, 0);
        return res;
    }

    public void backtrack(StringBuilder[] board, int n, int qCount, int x, int y) {
        if (qCount == n) {
            List<String> str = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                str.add(board[i].toString());
            }
            res.add(new ArrayList(str));
            return;
        }

        if (y == n) {
            y = 0;
            x++;
        }

        if (x >= n) {
            return;
        }
        if (vertCheck(board, x, y) && diagCheck(board, x, y)) {
            board[x].setCharAt(y, 'Q');
            qCount++;
            backtrack(board, n, qCount, x+1, 0);
            board[x].setCharAt(y, '.');
            qCount--;
        }
        backtrack(board, n, qCount, x, y + 1);

        return;
    }

    public boolean vertCheck(StringBuilder[] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (board[i].charAt(y) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public boolean horiCheck(StringBuilder[] board, int x) {
        for (int i = 0; i < board.length; i++) {
            if (board[x].charAt(i) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public boolean diagCheck(StringBuilder[] board, int x, int y) {
        // left up
        int p1 = x - 1, p2 = y - 1;
        while (p1 > -1 && p2 > -1) {
            if (board[p1].charAt(p2) == 'Q') {
                return false;
            }
            p1--;
            p2--;
        }
        // right down
        // p1 = x + 1;
        // p2 = y + 1;
        // while (p1 < board.length && p2 < board.length) {
        //     if (board[p1].charAt(p2) == 'Q') {
        //         return false;
        //     }
        //     p1++;
        //     p2++;
        // }
        // left down
        // p1 = x + 1;
        // p2 = y - 1;
        // while (p1 < board.length && p2 > -1) {
        //     if (board[p1].charAt(p2) == 'Q') {
        //         return false;
        //     }
        //     p1++;
        //     p2--;
        // }
        // right up
        p1 = x - 1;
        p2 = y + 1;
        while (p1 > -1 && p2 < board.length) {
            if (board[p1].charAt(p2) == 'Q') {
                return false;
            }
            p1--;
            p2++;
        }
        return true;
    }
}

public class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> set = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(r, c, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, char[][] board, String word, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r >= ROWS || r < 0 || c >= COLS || c < 0 || board[r][c] != word.charAt(i)
            || set.contains(new Pair<>(r, c))) {
            return false;
        }

        System.out.println(board[r][c]);
        set.add(new Pair<>(r, c));
        boolean res = backtrack(r + 1, c, board, word, i + 1)
            || backtrack(r - 1, c, board, word, i + 1) || backtrack(r, c + 1, board, word, i + 1)
            || backtrack(r, c - 1, board, word, i + 1);

        set.remove(new Pair<>(r, c));
        return res;
    }
}

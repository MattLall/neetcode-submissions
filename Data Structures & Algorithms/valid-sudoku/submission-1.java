class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rows = checkRows(board);

        if (!rows) {
            return false;
        }
        // boolean cols = checkColumns(board);
        // if (!cols) {
        //     System.out.println("Cols");
        //     return false;
        // }
        // boolean boxes = checkBoxes(board);
        // if (!boxes) {
        //     System.out.println("Boxes");
        //     return false;
        // }

        return true;
    }

    public boolean checkRows(char[][] board) {
        HashMap<Integer, Set<Character>> colMap = new HashMap<Integer, Set<Character>>();
        HashMap<Integer, Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
        HashMap<Integer, Set<Character>> squareMap = new HashMap<Integer, Set<Character>>();
        // System.out.println("TEST");
        for (int row = 0; row < 9; row++) {
            // System.out.println("")
            if (!rowMap.containsKey(row)) {
                rowMap.put(row, new HashSet<Character>());
            }

            for (int col = 0; col < 9; col++) {
                int squareIndex = (row / 3) * 3 + (col / 3);
                System.out.println(squareIndex);
                if (!colMap.containsKey(col)) {
                    colMap.put(col, new HashSet<Character>());
                }
                if (!squareMap.containsKey(squareIndex)) {
                    squareMap.put(squareIndex, new HashSet<Character>());
                }
                char val = board[row][col];
                if (val == '.') {
                    continue;
                }
                if (!colMap.get(col).add(val)) {
                    return false;
                }
                if (!rowMap.get(row).add(val)) {
                    return false;
                }
                if (!squareMap.get(squareIndex).add(val)) {
                    return false;
                }
            }
            
        }
        return true;
    }

    public boolean checkColumns(char[][] board) {
        for (int a = 0; a < 10; a++) {
            Set<Character> map = new HashSet<Character>();
            for (int b = 0; b > 10; b++) {
                if (board[b][a] == '.') {
                    continue;
                }
                if (map.contains(board[b][a])) {
                    return false;
                }
                map.add(board[b][a]);
            }
        }
        return true;
    }

    public boolean checkBoxes(char[][] board) {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (!checkBox(board, b * 3, a * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBox(char[][] board, int startCol, int startRow) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                int row = startRow + a;
                int col = startCol + b;
                if (board[col][row] == '.') {
                    continue;
                }
                if (map.containsKey(board[col][row])) {
                    return false;
                }
                map.put(board[col][row], 1);
            }
        }
        return true;
    }
}

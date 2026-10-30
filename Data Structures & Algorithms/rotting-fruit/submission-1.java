class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshFruit = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();

        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                if (grid[x][y] == 1) {
                    freshFruit++;
                } else if (grid[x][y] == 2) {
                    q.offerLast(new int[] {x, y});
                }
            }
        }

        while (freshFruit>0 && !q.isEmpty()) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] rot = q.pollFirst();
                for (int[] d : dirs) {
                    int r = rot[0] + d[0];
                    int c = rot[1] + d[1];
                    if (r < 0 || c < 0 || r >= ROWS || c >= COLS) {
                        continue;
                    }
                    if (grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offerLast(new int[]{r,c});
                        freshFruit--;
                    }
                }
            }
            time++;
        }

        return freshFruit==0?time:-1;
    }
}

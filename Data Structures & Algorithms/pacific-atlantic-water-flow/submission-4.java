class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights);
            dfs(rows - 1, c, atl, heights);
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, cols - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public void dfs(int x, int y, boolean[][] ocean, int[][] heights) {
        ocean[x][y] = true;
        int h = heights[x][y];
        for (int[] d : directions) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length
                && !ocean[nx][ny] && heights[nx][ny] >= h) {
                dfs(nx, ny, ocean, heights);
            }
        }
    }
}

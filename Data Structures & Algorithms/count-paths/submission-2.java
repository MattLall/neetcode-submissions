class Solution {
    int[][] paths;
    public int uniquePaths(int m, int n) {
        paths = new int[m][n];
        for(int[] p:paths){
            Arrays.fill(p,-1);
        }
        return dfs(0, 0, m, n);
    }

    public int dfs(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if(paths[i][j]!=-1){
            return paths[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        return paths[i][j]=dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }
}

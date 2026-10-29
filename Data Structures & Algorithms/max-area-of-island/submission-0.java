class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                count= Math.max(count,dfs(grid,new int[]{i,j}));
            }
        }

        return count;
    }

    public int dfs(int[][] grid, int[] coords) {
        int x = coords[0], y = coords[1];
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y]=0;
        int count = 1;
        for(int[] d : directions){
            count+=dfs(grid,new int[]{x+d[0],y+d[1]});
        }
        return count;
    }
}

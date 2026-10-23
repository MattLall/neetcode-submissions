class Solution {
    int count;
    // Set<String> viewed;

    public int numIslands(char[][] grid) {
        count=0;
        // viewed = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                dfs(grid,i,j);
                count++;

                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y){
        if(x<0||x>grid.length-1||y<0||y>grid[0].length-1){
            return;
        }
        char val = grid[x][y];
        if(val=='0'){
            return;
        }
        grid[x][y]='0';

        dfs(grid,x+1,y);
        dfs(grid,x,y+1);
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);

    }
}

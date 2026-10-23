class Solution {
    int count;
    Set<String> viewed;

    public int numIslands(char[][] grid) {
        count=0;
        viewed = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dfs(grid,i,j,false);
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y,boolean isLand){
        if(x<0||x>grid.length-1||y<0||y>grid[0].length-1){
            return;
        }
        char val = grid[x][y];
        if(viewed.contains(x+","+y) || val=='0'){
            return;
        }
        viewed.add(x+","+y);
        if(!isLand){
        count++;

        }
        dfs(grid,x+1,y,true);
        dfs(grid,x,y+1,true);
        dfs(grid,x-1,y,true);
        dfs(grid,x,y-1,true);

    }
}

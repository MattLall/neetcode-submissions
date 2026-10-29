class Solution {
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offerLast(new int[]{i,j});
                }
            }
        }

        if(q.size()==0)return;
        while(!q.isEmpty()){
            int[] cell = q.pollFirst();
            int row = cell[0];
            int col = cell[1];
            for(int[] d : directions){
                int r = row+d[0];
                int c = col+d[1];
                if(r>=m || c>=n || r<0 || c<0 || grid[r][c]!=Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{r,c});
                grid[r][c]=grid[row][col]+1;
            }
        }
        
    }
}

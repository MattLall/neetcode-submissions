class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshFruit = 0;
        int changes;
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

                    for (int x = 0; x < ROWS; x++) {
                for (int y = 0; y < COLS; y++) {
                    if(grid[x][y]==1){
                        freshFruit++;
                    }
                }
            }
        do {
            
            changes = 0;
            boolean[][] changed = new boolean[ROWS][COLS];
            for (int x = 0; x < ROWS; x++) {
                for (int y = 0; y < COLS; y++) {
                    if(!changed[x][y] && grid[x][y]==2){
                        for(int[] d : dirs){
                            int r = x+d[0];
                            int c = y+d[1];
                            if(r<0||c<0||r>=ROWS||c>=COLS){
                                continue;
                            }
                            if(grid[r][c]==1){
                                grid[r][c]=2;
                                changed[r][c]=true;
                                changes++;
                                freshFruit--;
                            }
                        }
                    }
                }
            }
            if(changes>0){
                time++;
            }
        } while (changes != 0);

            if (freshFruit != 0) {
            return -1;
        }
        return time;
    }
}

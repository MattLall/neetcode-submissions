class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<Integer[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visit = new boolean[N][N];

        minHeap.offer(new Integer[] {grid[0][0], 0, 0});
        visit[0][0] = true;
        // int maxEl = 0;

        while (!minHeap.isEmpty()) {
            Integer[] cell = minHeap.poll();
            if(cell[1]==N-1 && cell[2]==N-1){
                return cell[0];
            }
            // maxEl = Math.max(maxEl, cell[0]);
            for (int[] d : dirs) {
                int x = cell[1] + d[0];
                int y = cell[2] + d[1];
                if (x < N && x >= 0 && y < N && y >= 0) {
                    int time = Math.max(grid[x][y], cell[0]);
                    Integer[] nei = new Integer[] {time, x, y};
                    if (!visit[x][y]) {
                        visit[x][y] = true;
                        minHeap.offer(nei);
                    }
                }
            }
        }
return minHeap.peek()[0];
        // return Math.max(maxEl, grid[N - 1][N - 1]);
    }
}

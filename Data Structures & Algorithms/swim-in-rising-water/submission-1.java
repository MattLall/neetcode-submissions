class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<List<Integer>> visit = new HashSet<>();
        minHeap.offer(new Integer[] {grid[0][0], 0, 0});
        int maxEl = 0;

        while (minHeap.peek()[1] != ROWS - 1 || minHeap.peek()[2] != COLS - 1) {
            Integer[] cell = minHeap.poll();
            List<Integer> l = Arrays.asList(cell);
            visit.add(l);

            


            maxEl = Math.max(maxEl, cell[0]);
            for (int[] d : dirs) {
                int x = cell[1] + d[0];
                int y = cell[2] + d[1];
                if (x < ROWS && x >= 0 && y < COLS && y >= 0) {
                    Integer[] nei = new Integer[] {grid[x][y], x, y};
                    if(!visit.contains(Arrays.asList(nei))){

                    minHeap.offer(nei);
                    }
                }
            }
        }

        return Math.max(maxEl,grid[ROWS-1][COLS-1]);
    }
}

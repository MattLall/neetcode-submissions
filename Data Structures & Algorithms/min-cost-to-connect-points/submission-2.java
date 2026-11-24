class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> frontier = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        frontier.offer(new int[] {0, 0});
        int totalCost = 0;
        while (visited.size() < N) {
            int[] curr = frontier.poll();
            int cost = curr[0];
            int i = curr[1];
            if (visited.contains(i)) {
                continue;
            }
            totalCost += cost;
            visited.add(i);
            for(int[] n : adj.getOrDefault(i,Collections.emptyList())){
                int nCost=n[0];
                int nIndex=n[1];
                if(!visited.contains(nIndex)){
                    frontier.offer(new int[]{nCost,nIndex});
                }
            }
        }
        return totalCost;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 1) {
                q.offerLast(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.pollLast();
            indegree[node]--;
            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 1) {
                    q.offerLast(i);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (indegree[a] ==2 && indegree[b] != 0) {
                return new int[] {a, b};
            }
        }

        return new int[2];
    }
}

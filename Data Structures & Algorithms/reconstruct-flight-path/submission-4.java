class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> l : tickets) {
            String src = l.get(0);
            String dst = l.get(1);

            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        List<String> res = new ArrayList<>();
        dfs(adj,"JFK",res);

        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String src, List<String> res){
        PriorityQueue<String> queue = adj.get(src);
        while(queue !=null && !queue.isEmpty()){
            String dst = queue.poll();
            dfs(adj,dst,res);
        }
        res.add(src);
    }
}

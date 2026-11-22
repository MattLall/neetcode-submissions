class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
         Map<Integer,Integer> dist = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
            dist.put(i,Integer.MAX_VALUE);
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[] {t[1], t[2]});
        }

        dfs(k,0,adj,dist);
        int res=Collections.max(dist.values());
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(int node,int time,Map<Integer,List<int[]>> adj, Map<Integer,Integer> dist){
        if(time>=dist.get(node))return;
        dist.put(node,time);
        if(!adj.containsKey(node))return;
        for(int[] edge: adj.get(node)){
            dfs(edge[0],time+edge[1],adj,dist);
        }

    }
}

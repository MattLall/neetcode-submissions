class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        for(int i = 0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i=0;i<n;i++){
            if(!seen.contains(i)){
                count++;
            dfs(i);
            }
        }

        return count;

    }

    public void dfs(int i){
        if(seen.contains(i)){
            return;
        }
        seen.add(i);
        for(int a : adj.get(i)){
            dfs(a);
        }
    }
}

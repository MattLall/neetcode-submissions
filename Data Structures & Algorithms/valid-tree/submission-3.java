class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set =new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] i : edges) {
            int parent = i[0], child = i[1];
            map.get(parent).add(child);
            map.get(child).add(parent);
        }
        if(!dfs(0,-1)){
            return false;
        }
        return set.size()==n;
        
    }

    public boolean dfs(int node, int parent){
        if(set.contains(node)){return false;}
        set.add(node);

        for(int n : map.get(node)){
            if(n==parent){
                continue;
            }
            if(!dfs(n,node)){
                return false;
            }
        }
        return true;
    }
}

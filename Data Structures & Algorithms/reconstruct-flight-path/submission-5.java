class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> l : tickets) {
            String src = l.get(0);
            String dst = l.get(1);

            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        LinkedList<String> res = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.offerFirst("JFK");

        while(!stack.isEmpty()){
            String curr = stack.peek();
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()){
                res.addFirst(stack.pollFirst());
            }else{
                stack.offerFirst(adj.get(curr).poll());
            }
        }
        return res;
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s : stones){
            heap.offer(s);
        }

        while(heap.size()>1){
            int x = heap.poll(),y=heap.poll();
            if(x==y){
                continue;
            }
            if(x<y){
                heap.offer(y-x);
            }else{
                heap.offer(x-y);
            }
        }
        if(heap.size()==0){
            return 0;
        }
        return heap.poll();
    }
}

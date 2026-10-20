class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int[] count = new int[26];
        for(char t : tasks){
            count[t-'A']++;
        }

        for(int cnt : count){
            if(cnt>0){
                heap.offer(cnt);
            }
        }

        int time=0;
        Deque<int[]> q = new ArrayDeque<>();
        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            if(heap.isEmpty()){
                time=q.peek()[1];
            }else{
                int cnt = heap.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                heap.add(q.poll()[0]);
            }
        }

        return time;
    }
}

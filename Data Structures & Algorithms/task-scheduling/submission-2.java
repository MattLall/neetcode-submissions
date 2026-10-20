class Solution {
    public int leastInterval(char[] tasks, int n) {
                PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }

        for (int cnt : count) {
            if (cnt > 0) {
                heap.offer(cnt);
            }
        }

        int maxF = heap.poll();
        int idle = (maxF - 1) * n;
        int out = maxF;
        while (!heap.isEmpty()) {
            int c = heap.poll();
            out += c;
            idle -= Math.min(c, maxF - 1);
        }

        if(idle>0){
            return out+idle;
        }

        return out;
    }
}

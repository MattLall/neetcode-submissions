class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }
        Arrays.sort(count);
        int maxF = count[25];
        int idle = (maxF-1)*n;

        for(int i = 24;i>=0;i--){
            idle-=Math.min(count[i],maxF-1);
        }

        return Math.max(idle,0) + tasks.length;
    }
}

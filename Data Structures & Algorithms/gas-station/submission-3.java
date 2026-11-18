class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n - 1;
        int end = 0;
        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            }else{

            tank += gas[end] - cost[end];
            end++;
            }
        }
        if (tank >= 0) {
            return start;
        }
        return -1;
    }
}

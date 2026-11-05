class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for(int i= 0;i<cache.length;i++){
            cache[i]=-1;
        }

        for(int x = cache.length-1;x>=0;x--){
            minCost(cost,x);
        }

        return Math.min(cache[0],cache[1]);
    }

    public int minCost(int[] cost,int step){
        if(step>=cost.length){
            return 0;
        }
if(cache[step]!=-1){
    return cache[step];
}
        int oneStep = minCost(cost,step+1)+cost[step];
        int twoStep = minCost(cost,step+2)+cost[step];
        cache[step]=Math.min(oneStep,twoStep);
        return cache[step];

    }
}

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1000000);
        dp[nums.length-1]=0;
        for(int i =nums.length-2;i>=0;i--){
            int start = i+1;
            int end=Math.min(i+nums[i],nums.length-1);
            for(int j=start;j<=end;j++){
                dp[i]=Math.min(1+dp[j],dp[i]);
            }
        }
        return dp[0];
    }
}

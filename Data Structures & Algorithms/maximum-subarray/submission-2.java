class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = Arrays.copyOf(nums,nums.length);
        for(int i =1;i<dp.length;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int maxSum=dp[0];
        for(int i =0;i<nums.length;i++){
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}

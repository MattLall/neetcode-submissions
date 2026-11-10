class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
        int max=0;
        for(int i = 0;i<n;i++){
            max=Math.max(findSeq(nums,i),max);
        }
        return max;
    }

    public int findSeq(int[] nums, int i) {
        if (memo[i]!=-1) {
            return memo[i];
        }
        int max = 1;
        for (int x = i + 1; x < nums.length; x++) {
            if (nums[x] > nums[i]) {
                max = Math.max(findSeq(nums, x)+1, max);
            }
        }
        memo[i]= max;
        return max;
    }
}

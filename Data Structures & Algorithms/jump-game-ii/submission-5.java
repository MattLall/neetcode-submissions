class Solution {
    Integer[] jumps;
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        jumps=new Integer[nums.length];
        return jumpCount(nums,0);
    }

    public int jumpCount(int[] nums, int i) {
        if (i == nums.length - 1) {
            return 0;
        }
        if(nums[i]==0){
            return Integer.MAX_VALUE;
        }

        if(jumps[i]!=null){
            return jumps[i];
        }

        int count = Integer.MAX_VALUE;
        int end = Math.min(nums.length-1,i+nums[i]);
        for (int x = i + 1; x <= end;x++) {
            count = Math.min(count, jumpCount(nums, x));
        }
        jumps[i]=count==Integer.MAX_VALUE ? 1 : count + 1;
        return jumps[i];
    }
}

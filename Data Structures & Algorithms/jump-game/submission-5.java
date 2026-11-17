class Solution {
    public boolean canJump(int[] nums) {
        boolean[] jump = new boolean[nums.length];
        jump[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int end=Math.min(nums.length,i+nums[i]+1);
            for (int x = i; x <end; x++) {
                if(jump[x]){
                    jump[i]=true;
                    break;
                }
            }

        }

        return jump[0];
    }
}

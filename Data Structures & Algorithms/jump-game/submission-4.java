class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] jump = new Boolean[nums.length];
        jump[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int x = 1; x <= nums[i]; x++) {
                jump[i] = jump[i + x];
                if (jump[i] != null && jump[i])
                    break;
            }
            if(jump[i]==null){
                jump[i]=false;
            }
        }

        return jump[0];
    }
}

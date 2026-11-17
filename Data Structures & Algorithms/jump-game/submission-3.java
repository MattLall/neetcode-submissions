class Solution {
    Boolean[] jumps;
    public boolean canJump(int[] nums) {
        jumps = new Boolean[nums.length];
        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int i) {
        System.out.println(i);
        if (i >= nums.length - 1) {
            return true;
        }
        if (jumps[i] != null) {
            return jumps[i];
        }
        boolean reach = false;
        for (int x = 1; x <= nums[i]; x++) {
            reach = reach || jump(nums, x + i);
        }
        jumps[i] = reach;
        return reach;
    }
}

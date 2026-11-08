class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;
        for (int num : nums) {
            int temp = curMax * num;
            curMax = Math.max(num, Math.max(temp, curMin * num));
            curMin = Math.min(num, Math.min(temp, curMin * num));
            res = (Math.max(res, curMax));
        }

        return res;
    }
}

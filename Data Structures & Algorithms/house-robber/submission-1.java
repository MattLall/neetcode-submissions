class Solution {
    int[] cache;

    public int rob(int[] nums) {
        int n = nums.length;
        cache = new int[n];

        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        int maxLoot = 0;
        for (int i = 0; i < n; i++) {
            maxLoot = Math.max(maxLoot, loot(nums, i));
        }

        return maxLoot;
    }

    public int loot(int[] nums, int h) {
        if (h >= nums.length) {
            return 0;
        }
        if (cache[h] != -1) {
            return cache[h];
        }

        int amount = nums[h];
        int max = Math.max(amount + loot(nums, h + 2),loot(nums,h+1));
        cache[h] = max;
        return max;
    }
}

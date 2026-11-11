class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];

        return subsets(nums, 0, target);
    }

    public boolean subsets(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0;
        }

        if (target < 0) {
            return false;
        }

        if (memo[i][target] != null) {
            return memo[i][target];
        }
        memo[i][target] =
            (subsets(nums, i + 1, target - nums[i])) || (subsets(nums, i + 1, target));

            return memo[i][target];
    }
}

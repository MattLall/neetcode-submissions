class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }
        return subsets(nums, 0, sum / 2);
    }

    public boolean subsets(int[] nums, int i, int target) {
        if (i >= nums.length) {
            return false;
        }

        if (0 == target) {
            return true;
        }
        if (0 > target) {
            return false;
        }
        return (subsets(nums, i + 1, target-nums[i])) || (subsets(nums, i + 1, target));
    }
}

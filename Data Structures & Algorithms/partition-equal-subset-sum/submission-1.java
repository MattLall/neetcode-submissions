class Solution {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return subsets(nums, 0, 0, sum / 2);
    }

    public boolean subsets(int[] nums, int i, int total, int target) {
        if (i >= nums.length) {
            return false;
        }

        if (total == target) {
            return true;
        }
        if (total > target) {
            return false;
        }
        total += nums[i];
        if (subsets(nums, i + 1, total, target)) {
            return true;
        }
        total -= nums[i];
        if (subsets(nums, i + 1, total, target)) {
            return true;
        }
        return false;
    }
}

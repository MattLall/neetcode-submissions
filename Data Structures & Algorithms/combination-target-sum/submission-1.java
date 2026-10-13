class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, target, 0, subset, res);
        return res;
    }

    public void backtrack(
        int[] nums, int index, int target, int sum, List<Integer> subset, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (index >= nums.length) {
            return;
        }
        int val = nums[index];
        subset.add(val);

        backtrack(nums, index, target, sum + val, subset, res); // add without moving to next index

        subset.remove(subset.size() - 1);
        backtrack(nums, index + 1, target, sum, subset, res); // do not add, move to next
                                                              // index
    }
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int index, boolean[] seen, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        seen[index] = true;
        backtrack(nums, index + 1, seen, subset);
        subset.remove(subset.size() - 1);
        seen[index] = false;
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(nums, index + 1, seen, subset);
    }
}

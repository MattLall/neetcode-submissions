class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> perm, boolean[] pick) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }



        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i]=true;
                backtrack(nums, perm, pick);
                perm.remove(perm.size()-1);
                pick[i]=false;
            }
        }

    }
}

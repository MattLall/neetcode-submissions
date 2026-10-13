class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, cur);
        return res;
    }

    private void dfs(int[] candidates, int i, int target, int total, List<Integer> cur) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (total > target || i == candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        dfs(candidates, i + 1, target, total + candidates[i], cur);
        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        dfs(candidates, i + 1, target, total, cur);
    }
}

class Solution {
    Map<Integer, Integer> minMap;
    public int coinChange(int[] coins, int amount) {
        minMap = new HashMap<>();

        int minSize = dfs(coins, amount);

        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }

    public int dfs(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }

        if (minMap.containsKey(target)) {
            return minMap.get(target);
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (target - coin >= 0) {
                int result = dfs(coins, target - coin);
                if (result != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + result);
                }
            }
        }

        minMap.put(target, min);
        return min;
    }
}

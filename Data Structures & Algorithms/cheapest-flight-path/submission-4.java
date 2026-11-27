class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k ; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);
            for (int[] f : flights) {
                int s = f[0];
                int d = f[1];
                int p = f[2];
                if (prices[s] == Integer.MAX_VALUE)
                    continue;

                tmpPrices[d] = Math.min(tmpPrices[d], prices[s] + p);
            }
            prices=tmpPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}

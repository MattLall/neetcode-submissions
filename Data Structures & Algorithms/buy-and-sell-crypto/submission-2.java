class Solution {
    public int maxProfit(int[] prices) {
        int max=0;

        for(int i=0;i<prices.length;i++){
            
            int profit = profit(Arrays.copyOfRange(prices,i,prices.length));
            max = Math.max(profit,max);
        }
        return max;
    }

    public int profit(int[] arr){
        if(arr.length<2) return 0;
        int max = 0;
        int buy = arr[0];
        for(int i =1;i<arr.length;i++){
            int sell = arr[i]-buy;
            max=Math.max(sell,max);
        }
        return max;
    }
}

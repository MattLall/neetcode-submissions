class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
    
int out = Integer.MAX_VALUE;
        int l = 1, r=piles[piles.length-1];
        while(l<=r){
            int k = (l+r)/2;
            int hours=0;
            for(int i : piles){
                hours+=Math.max(1,Math.ceil((double)i/k));
            }
            System.out.println(hours);
            // out=Math.min(out,hours);
            if(hours<=h){
                out=k;
                r=k-1;
            }else{
                l=k+1;
            }
        
        }
        return out;
    }
}

class Solution {
    public int findMin(int[] nums) {

        int length = nums.length;
        int out = nums[0];
        if(nums[0]<=nums[length-1]){
            return nums[0];
        }
        

        int l = 0, r = length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[l]<nums[r]){
                out=Math.min(out,nums[l]);
                break;
            }
            out=Math.min(out,nums[m]);
            if(nums[m]>=nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
            
        }

        return out;
        
        
    }
}

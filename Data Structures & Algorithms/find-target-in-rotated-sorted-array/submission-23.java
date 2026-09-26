class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0, r = nums.length-1;
        while(l<=r){
            int m = (r+l)/2;
            if(nums[m]==target){
                return m;
            }

            if(nums[l]<= nums[m]){
                if(target>nums[m] || target<nums[l]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }else{
                if(target<nums[m] || target>nums[r]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }

            // if(nums[m]>=nums[l]){

            //     if(nums[m]>target || target <nums[l]){
            //         l=m+1;
            //     }else{
            //         r=m-1;
            //         //return binarySearch(nums,new int[]{l,m},target);
            //     }
                
            // }else{
            //     if(nums[m]<target || target>nums[r]){
            //         r=m-1;
            //     }else{
            //         l=m+1;
            //         //return binarySearch(nums,new int[]{m,l},target);
            //     }
            // }

        }

        return -1;
    }

    public int binarySearch(int[] nums,int[] bounds,int target){
        int l = bounds[0], r = bounds[1];
        while(l<=r){
            int m = l+ (r-l)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }

        }
        return -1;
    }
}

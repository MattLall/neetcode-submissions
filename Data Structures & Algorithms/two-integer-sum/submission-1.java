class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int x=i+1;x<nums.length;x++){
                if(nums[x]+nums[i]==target){
                    return new int[]{i,x};
                }
            }
        }
        return new int[2];
    }
}

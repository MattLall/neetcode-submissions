class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int[] output = new int[nums.length];
        int zeroCount=0;


        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
                if(zeroCount>1){
                    return new int[nums.length];
                }
                continue;
            }
            product*=nums[i];
        }

        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0){
                output[i]=product;
            }else{
                if(zeroCount==1){
                    output[i]=0;
                }else{

            output[i]=product/nums[i];
                }
            }
        }

        return output;
        
    }
}  

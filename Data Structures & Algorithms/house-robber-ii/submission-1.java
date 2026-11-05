class Solution {
    int[] c1;
    int[] c2;
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int n = nums.length;
        int[] h1 = Arrays.copyOfRange(nums,0,n-1);
        int[] h2 = Arrays.copyOfRange(nums,1,n);
        c1 = new int[n-1];
        c2 = new int[n-1];

        c1[0]=h1[0];
        c1[1]=Math.max(h1[0],h1[1]);

        c2[0]=h2[0];
        c2[1]=Math.max(h2[0],h2[1]);

        for(int i = 2;i<n-1;i++){
            c1[i]=Math.max(c1[i-2]+h1[i],c1[i-1]);
            c2[i]=Math.max(c2[i-2]+h2[i],c2[i-1]);
        }

        return Math.max(c1[n-2],c2[n-2]);

    }
}

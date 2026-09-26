class Solution {
    public int search(int[] nums, int target) {
        int smallestIndex = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if(smallestIndex==-1){
                smallestIndex=m;
            }
            if (nums[l] < nums[r]) {
                smallestIndex = (Math.min(nums[l], nums[smallestIndex]) == nums[smallestIndex])
                    ? smallestIndex
                    : l;
                break;
            }

            smallestIndex =
                (Math.min(nums[m], nums[smallestIndex]) == nums[smallestIndex]) ? smallestIndex : m;
            
            if(nums[m]>=nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
        }

        System.out.println("Smallest Index = "+smallestIndex);
        int targIndex = binarySearch(nums,new int[]{smallestIndex,nums.length-1},target);

        if (targIndex != -1) {
            return targIndex;
        }
        return binarySearch(nums,new int[]{0,smallestIndex},target);
    }

    public int binarySearch(int[] nums,int[] bounds, int target) {
        int l = bounds[0], r = bounds[1];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println("Not found with bounds: "+ bounds[0] + " " + bounds[1]);
        return -1;
    }
}

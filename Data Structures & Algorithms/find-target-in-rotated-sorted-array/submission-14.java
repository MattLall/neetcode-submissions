class Solution {
    public int search(int[] nums, int target) {
        int smallestIndex = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
System.out.println(l+ " " + m + " " + r);
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
        int targIndex = binarySearch(Arrays.copyOfRange(nums, smallestIndex, nums.length), target);

        if (targIndex != -1) {
            return smallestIndex+targIndex;
        }
        return binarySearch(Arrays.copyOfRange(nums, 0, smallestIndex + 1), target);
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
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
        return -1;
    }
}

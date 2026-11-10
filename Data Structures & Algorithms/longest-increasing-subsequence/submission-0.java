class Solution {
    Map<Integer, Integer> map;
    public int lengthOfLIS(int[] nums) {
        map = new HashMap<>();
        int max=0;
        for(int i = 0;i<nums.length;i++){
            max=Math.max(findSeq(nums,i),max);
        }
        return max;
    }

    public int findSeq(int[] nums, int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int max = 0;
        for (int x = i + 1; x < nums.length; x++) {
            if (nums[x] > nums[i]) {
                max = Math.max(findSeq(nums, x), max);
            }
        }
        map.put(i, max + 1);
        return max + 1;
    }
}

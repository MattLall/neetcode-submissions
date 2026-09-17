class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Set<Integer> valSet = new HashSet<Integer>();
        int longest = 1;
        for(int i : nums){
            valSet.add(i);
        }

        // Iterator<Integer> it = valSet.iterator();
        for(int curr : valSet){
            // int curr = it.next();
            if(valSet.contains(curr-1)){
                continue;
            }
        int seq = 1;
            while(valSet.contains(curr+seq)){
                seq++;
                // curr++;
            }
            longest = Math.max(longest,seq);
            // seq=1;
        }
        return longest;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Set<Integer> valSet = new HashSet<Integer>();
        int longest = 1;
        int seq = 1;
        for(int i : nums){
            valSet.add(i);
        }

        Iterator<Integer> it = valSet.iterator();
        while(it.hasNext()){
            int curr = it.next();
            if(valSet.contains(curr-1)){
                continue;
            }
            while(valSet.contains(curr+1)){
                seq++;
                curr++;
            }
            longest = Math.max(longest,seq);
            seq=1;
        }
        return longest;
    }
}

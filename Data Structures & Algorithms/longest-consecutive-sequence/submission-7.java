class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> valSet = new HashSet<Integer>();

        for (int i : nums) {
            valSet.add(i);
        }

        int longest = 0;

        for (int curr : valSet) {
            int seq = 1;

            if (!valSet.contains(curr - 1)) {
                while (valSet.contains(curr + seq)) {
                    seq++;
                }
            }
            longest = Math.max(longest, seq);
        }
        return longest;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        HashSet<Character> set = new HashSet<>();
        int max=0;
        while(l<s.length() && r<s.length()){

            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }else{
                set.add(s.charAt(r));
                r++;
            }
            max=Math.max(set.size(),max);
        }

        return max;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int l=0,r=s1.length()-1;
        String s1Key = freq(s1);

        for(;r<s2.length();l++,r++){
            String s = s2.substring(l,r+1);
            String key = freq(s);
            if(key.equals(s1Key)) return true;
        }

        return false;
    }

    public String freq(String s){
        int[] freq = new int[26];
        for(int i = 0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        return Arrays.toString(freq);
    }
}

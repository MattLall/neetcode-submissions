class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int l=0,r=s1.length()-1;
        HashMap<String,Integer> map = new HashMap<>();
        String s1Key = freq(s1);

        for(;r<s2.length();l++,r++){
            String s = s2.substring(l,r+1);
            String key = freq(s);
            map.put(key,map.getOrDefault(key,0)+1);
            if(map.containsKey(s1Key)) return true;
        }
        // while(r<s2.length()){
        //     map.put(s2.charAt(r),map.getOrDefault(s2.charAt(r),0)+1);
        //     if(r-l<length){
        //         r++;
        //         continue;
        //     }else{
        //         map.put(s2.charAt(l),map.get(s2.charAt(l))-1);
        //         l++;
        //         r++;
        //     }
        // }

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

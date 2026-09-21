class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;

        int l=0,r=0;
        HashMap<Character,Integer> ht = new HashMap<>();
        char mostFrequent=0;
        while(l<s.length() && r<s.length()){
            int length = 1+(r-l);
            char right = s.charAt(r);
            ht.put(right,(ht.getOrDefault(right,0)+1));
            if(mostFrequent==0 || ht.get(right)>ht.get(mostFrequent)){
                mostFrequent=right;
            }
            
            if((length-ht.get(mostFrequent)>k)){
                ht.put(s.charAt(l),ht.get(s.charAt(l))-1);
                l++;
                ht.put(right,(ht.getOrDefault(right,1)-1));
                for(char c : ht.keySet()){
                    if(ht.get(c)>ht.get(mostFrequent)){
                        mostFrequent=c;
                    }
                }
            }else{
                if(s.substring(l,r+1).length()==5){
                    System.out.println(s.substring(l,r+1));
                    System.out.println(length+" "+ht.get(mostFrequent));
                }
                max=Math.max(max,length);
                r++;
            }

            
        }

        return max;
        
    }
}

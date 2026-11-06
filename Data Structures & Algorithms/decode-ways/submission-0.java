class Solution {
    int baseVal = 64; // A is 65 in ASCII, so number + 64 will equal the letter
    Map<Integer, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        map.put(s.length(),1);
        return dfs(s,0);
    }

    public int dfs(String s, int i) {
        if(map.containsKey(i)){
            return map.get(i);
        }
        if(i==s.length()){
            System.out.println(1);
         return 1;
        }    
        if(s.charAt(i)=='0') return 0;

        int res = dfs(s,i+1);
        if(i<s.length()-1){
            if(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'){
                res+=dfs(s,i+2);
            }
        }
        map.put(i,res);
        return res;
    }
}

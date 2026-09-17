class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String,List<String>> seen = new HashMap<>();

        for(int i = 0; i<strs.length;i++){
            int[] freq = letterFrequency(strs[i]);
            String code = Arrays.toString(freq);
            List<String> list = seen.getOrDefault(code,new ArrayList<>());
            list.add(strs[i]);
            seen.put(code,list);
        }

        for (List<String> l : seen.values()){
            output.add(l);
        }
        
        

        
    return output;
    }

    public int[] letterFrequency(String s){
        int[] freq = new int[26];
        for(int i = 0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        return freq;
    }

    public boolean areAnagrams(String st1, String st2){
        if(st1.length()!=st2.length()) return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0; i<st1.length();i++){
            map1.put(st1.charAt(i),map1.getOrDefault(st1.charAt(i),0)+1);
            map2.put(st2.charAt(i),map2.getOrDefault(st2.charAt(i),0)+1);
        }
        return map1.equals(map2);
    }
}

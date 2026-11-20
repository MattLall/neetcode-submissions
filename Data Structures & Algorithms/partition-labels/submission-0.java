class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> out = new ArrayList();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
           map.put(s.charAt(i),Math.max(i,map.getOrDefault(i,0)));
        }

        int size=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            size++;
            end=Math.max(end,map.get(s.charAt(i)));
            if(i==end){
                out.add(size);
                size=0;
            }
        }

        return out;



    }
}

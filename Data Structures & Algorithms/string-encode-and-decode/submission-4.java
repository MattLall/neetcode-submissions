class Solution {

    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0){
            return "";
        }

        String output="";

        for(String s : strs){
            output+=String.format("%d#%s",s.length(),s);
        }
        return output;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<String>();
        int pointer =0;
        int curr = 0;


        while(pointer<str.length()){
            if(str.charAt(pointer)=='#'){
                
                int nextLength = Integer.parseInt(str.substring(curr,pointer));
                int endIndex = curr+nextLength+1+String.valueOf(nextLength).length();
                String nextStr = str.substring(pointer+1,endIndex);

                output.add(nextStr);
                pointer+=nextLength+1;
                curr=pointer;
            }else{
                pointer++;
            }
        }
        return output;
    }
}

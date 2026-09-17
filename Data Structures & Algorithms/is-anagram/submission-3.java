class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();

        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.compare(schar,tchar)==0;

        // for(char c : t.toCharArray()){
        //     int index = s.indexOf(c);
        //     if(index>-1){
        //         s=s.replaceFirst(Character.toString(c),"");
        //     }else{
        //         return false;
        //     }
        // }
        // return true;
    }
}

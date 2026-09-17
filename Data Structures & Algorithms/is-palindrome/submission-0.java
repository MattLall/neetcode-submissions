class Solution {
    public boolean isPalindrome(String s) {
        String cleared = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int point1 = 0;
        int point2 = cleared.length()-1;
        while(point1<point2){

            if(cleared.charAt(point1)!=cleared.charAt(point2)){
                System.out.println(cleared.charAt(point1));
                return false;
            }
            
            point1++;
            point2--;
        }
        return true;
    }
}

class Solution {
    public boolean checkValidString(String s) {


        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> stars = new ArrayDeque<>();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                open.offerFirst(i);
                continue;
            }
            if(c=='*'){
                stars.offerFirst(i);
                continue;
            }

            if(!open.isEmpty()){
                open.pollFirst();
            }else if(!stars.isEmpty()){
                stars.pollFirst();
            }else{
                return false;
            }

        }

        while(!open.isEmpty()){
            if(stars.isEmpty()){
                return false;
            }
            if(open.pollFirst()>stars.pollFirst()){
                return false;
            }
        }

        return true;
    }
}

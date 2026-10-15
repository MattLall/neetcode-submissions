class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        backtrack(n,str,0,0);
        return res;
    }

    public void backtrack(int n, StringBuilder str,int open,int close){

        if(close>open){

            return;
        }
        if(close==n && open==n){
            res.add(str.toString());
            return;
        }
        if(close>n || open>n){
            return;
        }
        str.append("(");
        open++;
        backtrack(n,str,open,close);
        str.replace(str.length()-1,str.length(),"");
        open--;
        str.append(")");
        close++;
        backtrack(n,str,open,close);
        str.replace(str.length()-1,str.length(),"");
        close--;
    }
}

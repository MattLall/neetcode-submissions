class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0){
        backtrack(digits,new StringBuilder(0),0);
        }
        return res;
    }

    public void backtrack(String digits, StringBuilder str, int index) {
        if (index == digits.length()) {
            res.add(str.toString());
            return;
        }

        char c = digits.charAt(index);
        char[] letters=new char[3];

        switch (c) {
            case '2':
                letters = new char[] {
                    'a', 'b', 'c'
                };
                break;
            case '3':
                letters = new char[] {
                    'd', 'e', 'f'
                };
                break;
            case '4':
                letters = new char[] {
                    'g', 'h', 'i'
                };
                break;
            case '5':
                letters = new char[] {
                    'j', 'k', 'l'
                };
                break;
            case '6':
                letters = new char[] {
                    'm', 'n', 'o'
                };
                break;
            case '7':
                letters = new char[] {
                    'p', 'q', 'r', 's'
                };
                break;
            case '8':
                letters = new char[] {
                    't', 'u', 'v'
                };
                break;
            case '9':
                letters = new char[] {
                    'w', 'x', 'y', 'z'
                };
                break;
        }

        for(int i =0; i<letters.length;i++){
            str.append(letters[i]);
            backtrack(digits,str,index+1);
        str.deleteCharAt(str.length()-1);
        }
    }
}

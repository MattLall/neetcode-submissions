class Solution {
    public boolean isValid(String s) {
        char[] open = new char[] {'(', '{', '['};
        char[] close = new char[] {')', '}', ']'};
        Stack braces = new Stack();

        for (int i =0; i<s.length();i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(': braces.push(s.charAt(i));
                    break;
                case '}': if(braces.empty() || (char) braces.pop()!='{') return false;
                    break;
                case ']': if(braces.empty() || (char) braces.pop()!='[') return false;
                    break;
                case ')': if(braces.empty() || (char) braces.pop()!='(') return false;
                    break;
                default:
            }
        }

        return braces.empty();
    }
}

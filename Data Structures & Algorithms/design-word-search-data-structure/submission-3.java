class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
        // System.out.println(root.children);
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;

        return searchNode(cur, word);
    }

    private boolean searchNode(TrieNode cur, String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int j, TrieNode root){
        TrieNode cur=root;

        for(int i =j;i<word.length();i++){
            char c =word.charAt(i);
            if(c=='.'){
                for(TrieNode child : cur.children){
                    if(child!=null && dfs(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(cur.children[c-'a']==null){
                    return false;
                }
                cur = cur.children[c-'a'];
            }
        }
        return cur.endOfWord;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;

    public TrieNode() {
        // children = new TrieNode[26];
        // endOfWord=false;
    }
}

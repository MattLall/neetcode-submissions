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
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (TrieNode n : cur.children) {
                    if (n != null) {
                        boolean found = searchNode(n, word.substring(i+1, word.length()));
                        if (found){
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int x = word.charAt(i) - 'a';
                if (cur.children[x] == null) {
                    return false;
                } else {
                    return searchNode(cur.children[x], word.substring(i+1, word.length()));
                }
            }
        }
        // System.out.println(cur.endOfWord);
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

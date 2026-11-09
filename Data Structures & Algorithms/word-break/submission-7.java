class Solution {
    Set<String> set;
    Boolean[] cache;
    int maxLength = 0;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        cache = new Boolean[s.length()];

        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
            set.add(word);
        }

        return findWord(0, s, wordDict);
    }

    public boolean findWord(int i, String s, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if (cache[i] != null) {
            return cache[i];
        }

        for (int x = i; x <= s.length(); x++) {
            if (x - i > maxLength) {
                cache[i] = false;
                return false;
            }
            if (set.contains(s.substring(i, x))) {
                if (findWord(x, s, wordDict)) {
                    cache[i] = true;
                    return true;
                }
            }
        }
        cache[i] = false;
        return false;
    }
}

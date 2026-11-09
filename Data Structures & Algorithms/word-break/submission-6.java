class Solution {
    Map<Integer, Set<String>> map;
    Boolean[] cache;
    int maxLength = 0;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        cache = new Boolean[s.length()];

        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
            map.computeIfAbsent(word.length(), k -> new HashSet<>()).add(word);
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
            if (!map.containsKey(x - i)) {
                continue;
            }
            String sub = s.substring(i, x);
            if (map.get(x-i).contains(s.substring(i, x))) {
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

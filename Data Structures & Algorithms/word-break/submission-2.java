class Solution {
    Map<Integer, Set<String>> map;
    Map<Integer,Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        cache = new HashMap<>();
        for (String word : wordDict) {
            map.computeIfAbsent(word.length(), k -> new HashSet<>()).add(word);
        }

        return findWord(0, s, wordDict);
    }

    public boolean findWord(int i, String s, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if(cache.containsKey(i)){
            return cache.get(i);
        }


        for (int x = i; x <= s.length(); x++) {
            String sub = s.substring(i, x);
            if(!map.containsKey(sub.length())) continue;
            for (String word : map.get(sub.length())) {
                if (sub.equals(word)) {
                    if (findWord(x, s, wordDict)) {
                        cache.put(i,true);
                        return true;
                    }
                }
            }
        }
        cache.put(i,false);
        return false;
    }
}

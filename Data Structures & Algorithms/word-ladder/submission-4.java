class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Deque<String> q = new ArrayDeque<>();
        int distance = 0;

        q.offerLast(beginWord);

        while (!q.isEmpty()) {
            distance++;

            for (int x = q.size(); x > 0; x--) {
                String s = q.pollFirst();
                if (s.equals(endWord)) {
                    return distance;
                }
                for (int i = 0; i < s.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.replace(i, i + 1, Character.toString('a' + j));
                        if (sb.toString().equals(s)) {
                            continue;
                        }

                        if (wordSet.contains(sb.toString())) {
                            wordSet.remove(sb.toString());
                            q.offerLast(sb.toString());
                        }
                    }
                }
            }
        }

        return 0;
    }
}

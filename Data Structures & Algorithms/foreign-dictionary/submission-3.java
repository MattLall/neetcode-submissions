class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length()
                && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            System.out.println(c + ": " + indegree.get(c));

            if (indegree.get(c) == 0) {
                queue.offerLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            sb.append(c);
            for (char ch : adj.get(c)) {
                indegree.put(ch, indegree.get(ch) - 1);
                if (indegree.get(ch) == 0) {
                    queue.offerLast(ch);
                }
            }
        }

        for (char c : indegree.keySet()) {
            System.out.println(c + ": " + indegree.get(c));
        }
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}

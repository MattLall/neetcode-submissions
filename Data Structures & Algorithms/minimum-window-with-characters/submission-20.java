class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) {
            return "";
        }


        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        String out = "";

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int matches = 0;
        int required = tMap.size();


        for(Map.Entry<Character,Integer> e : tMap.entrySet()){
            if (e.getValue() <= sMap.getOrDefault(e.getKey(), -1)) {
                matches++;
            }
        }
        int l = 0, r = t.length() - 1;

        while (r < s.length()) {
            if (matches == required) {
                String substring = s.substring(l, r + 1);
                if (out.isEmpty()) {
                    out = substring;
                } else if (substring.length() < out.length()) {
                    out = substring;
                }
                char lChar = s.charAt(l);

                sMap.put(lChar, sMap.get(lChar) - 1);

                if (tMap.containsKey(lChar) && sMap.get(lChar) < tMap.get(lChar)) {
                    matches--;
                }
                l++;
            } else {
                r++;
                if (r < s.length()) {
                    char rChar = s.charAt(r);
                    sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
                    if (tMap.containsKey(rChar) && sMap.get(rChar) == tMap.get(rChar)) {
                        matches++;
                    }
                }
            }
        }

        return out;
    }
}

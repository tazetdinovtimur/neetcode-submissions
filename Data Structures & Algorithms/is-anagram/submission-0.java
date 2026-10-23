class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        var chars1 = getCharMap(s);
        var chars2 = getCharMap(t);

        for (var c: chars1.keySet()) {
            if (!chars2.containsKey(c) || !chars2.get(c).equals(chars1.get(c))) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getCharMap(String s) {
        var chars = new HashMap<Character, Integer>();

        for (var c: s.toCharArray()) {
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }

         return chars;
    }
}

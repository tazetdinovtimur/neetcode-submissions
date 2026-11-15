class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int numDecodings(String s) {
        cache.put(s.length(), 1);
        return count(s, 0);
    }

    private int count(String s, int i) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        var res = count(s, i+1);

        if (i + 1 < s.length() && (s.charAt(i) == '1' ||
            s.charAt(i) == '2' && s.charAt(i+1) < '7')
        ) {
            res += count(s, i+2);
        }

        cache.put(i, res);

        return res;
    }
}

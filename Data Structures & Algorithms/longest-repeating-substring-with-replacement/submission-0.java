class Solution {
    public int characterReplacement(String s, int k) {
        var chars = new HashSet<Character>();
        var maxLen = 0;

        for (var c: s.toCharArray()) {
            chars.add(c);
        }

        for (var c: chars) {
            var l = 0;
            var count = 0;

            for (var r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while (r - l + 1 - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }

                    l++;
                }

                maxLen = Math.max(r - l + 1, maxLen);
            }
        }

        return maxLen;
    }
}

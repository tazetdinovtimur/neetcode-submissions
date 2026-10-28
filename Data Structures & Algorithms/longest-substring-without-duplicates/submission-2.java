class Solution {
    public int lengthOfLongestSubstring(String s) {
        var chars = new HashSet<Character>();
        var maxLen = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (chars.contains(s.charAt(r))) {
                while (l < s.length() && chars.contains(s.charAt(r))) {
                    chars.remove(s.charAt(l));
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);
            chars.add(s.charAt(r));
        }

        return maxLen;
    }
}

class Solution {
    boolean[][] p;

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        var n = s.length();
        var maxLen = 0;
        var start = 0;

        if (n == 1) {
            return s;
        }

        p = new boolean[n][n];

        for (var i = n-1; i >= 0; i--) {
            for (var j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || p[i+1][j-1])
                ) {
                    p[i][j] = true;

                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

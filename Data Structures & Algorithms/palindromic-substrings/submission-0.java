class Solution {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        var n = s.length();

        if (n == 1) {
            return 1;
        }

        var p = new boolean[n][n];
        var res = 0;

        for (var i = n-1; i >= 0; i--) {
            for (var j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || p[i+1][j-1])
                ) {
                    p[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}

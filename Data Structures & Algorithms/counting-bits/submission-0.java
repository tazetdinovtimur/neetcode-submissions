class Solution {
    public int[] countBits(int n) {
        var result = new int[n + 1];

        for (var i = 0; i <= n; i++) {
            for (var b = 0; b < 32; b++) {
                var bit = 1 & (i >> (31 - b));

                if (bit == 1) {
                    result[i]++;
                }
            }
        }

        return result;
    }
}

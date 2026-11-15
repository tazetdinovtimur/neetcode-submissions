class Solution {
    public int hammingWeight(int n) {
        var res = 0;

        for (var i = 0; i < 32; i++) {
            if ((1 & (n >> (31 - i))) == 1) {
                res++;
            }
        }

        return res;
    }
}

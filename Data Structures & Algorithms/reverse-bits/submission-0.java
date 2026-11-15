class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 & (n >> i);
            res = (bit << 31 - i) | res;
        }

        return res;
    }
}

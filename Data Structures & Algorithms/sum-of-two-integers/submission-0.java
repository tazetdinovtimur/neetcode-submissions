class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            var inMem = (a & b) << 1;
            a = a ^ b;
            b = inMem;
        }

        return a;
    }
}

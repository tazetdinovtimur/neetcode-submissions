class Solution {
    public int rob(int[] nums) {
        var prevMax = 0;
        var prevMaxInc = 0;

        for (var n: nums) {
            var tmp = Math.max(prevMax + n, prevMaxInc);
            prevMax = prevMaxInc;
            prevMaxInc = tmp;
        }

        return prevMaxInc;
    }
}

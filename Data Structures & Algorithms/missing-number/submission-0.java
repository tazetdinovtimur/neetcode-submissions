class Solution {
    public int missingNumber(int[] nums) {
        var sum = 0;

        for (var n: nums) {
            sum += n;
        }

        var n = nums.length;
        var arifmeticSum = n * (n + 1) / 2;

        return arifmeticSum - sum;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        var res = nums[0];
        var currenSum = 0;

        for (var n: nums) {
            if (currenSum < 0) {
                currenSum = 0;
            }

            currenSum += n;
            res = Math.max(res, currenSum);
        }

        return res;
    }
}

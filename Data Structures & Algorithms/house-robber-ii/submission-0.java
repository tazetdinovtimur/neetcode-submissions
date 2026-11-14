class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(
            houseRob(Arrays.copyOfRange(nums, 1, nums.length)),
            houseRob(Arrays.copyOfRange(nums, 0, nums.length - 1))
        );
    }

    private int houseRob(int[] nums) {
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

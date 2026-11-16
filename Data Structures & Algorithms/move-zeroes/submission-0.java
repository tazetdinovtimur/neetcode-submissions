class Solution {
    public void moveZeroes(int[] nums) {
        var l = 0;

        for (var r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                var tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
        }
    }
}
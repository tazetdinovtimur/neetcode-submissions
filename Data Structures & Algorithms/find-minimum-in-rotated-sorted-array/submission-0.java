class Solution {
    public int findMin(int[] nums) {
        // [1,2,3,4,5,6,7,8]
        // [6,7,8,1,2,3,4,5]
        var l = 0;
        var r = nums.length - 1;
        var min = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            var mid = (l + r) / 2;

            min = Math.min(min, nums[mid]);

            if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }
}

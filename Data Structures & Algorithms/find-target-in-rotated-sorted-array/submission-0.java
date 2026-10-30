class Solution {
    public static int search(int[] nums, int target) {
        var start = findStart(nums);
        var result = binSearch(nums, target, 0, start - 1);

        if (result != -1) {
            return result;
        }

        return binSearch(nums, target, start, nums.length - 1);
    }

    public static int binSearch(int[] nums, int target, int start, int end) {
        int l = start;
        int r = end;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public static int findStart(int[] nums) {
        var l = 0;
        var r = nums.length - 1;

        while (l < r) {
            var m = (l + r) / 2;

            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}

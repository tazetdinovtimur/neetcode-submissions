class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        int agg = 0;
        int zeroes = 0;

        for (var n: nums) {
            if (n == 0) {
                zeroes++;
                continue;
            }

            if (agg == 0) {
                agg = 1;
            }

            agg = agg * n;
        }

        for (var i = 0; i < nums.length; i++) {
            if (zeroes == 0) {
                result[i] = agg / nums[i];
            } else {
                if (nums[i] == 0 && zeroes == 1) {
                    result[i] = agg;
                } else {
                    result[i] = 0;
                }
            }
        }

        return result;
    }
}  

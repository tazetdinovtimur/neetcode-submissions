class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var target = 0;
        var result = new HashMap<String, int[]>();

        for (var i = 0; i < nums.length; i++) {
            var twoSums = twoSum(nums, target - nums[i], i);

            if (twoSums.isEmpty()) {
                continue;
            }

            for (var twoSum: twoSums) {
                var threeSum = new int[]{nums[i], twoSum[0], twoSum[1]};
                Arrays.sort(threeSum);
                var key = Arrays.toString(threeSum);

                result.put(key, threeSum);
            }
        }

        var res = new ArrayList<List<Integer>>();

        for (var kv: result.entrySet()) {
            res.add(Arrays.stream(kv.getValue()).boxed().toList());
        }

        return res;
    }

    public static List<int[]> twoSum(int[] nums, int target, int j) {
        var seen = new HashSet<Integer>();
        var result = new ArrayList<int[]>();

        for (var i = 0; i < nums.length; i++) {
            if (i == j) {
                continue;
            }

            if (seen.contains(target - nums[i])) {
                result.add(new int[] {target - nums[i], nums[i]});
            }

            seen.add(nums[i]);
        }

        return result;
    }
}

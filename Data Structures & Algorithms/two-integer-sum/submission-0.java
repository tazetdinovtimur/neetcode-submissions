class Solution {
    public int[] twoSum(int[] nums, int target) {
        var seen = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var current = nums[i];
            var search = target - current;

            if (seen.containsKey(search)) {
                return new int[] {(int)seen.get(search), i};
            }

            seen.put(current, i);
        }

        return new int[] {0, 0};
    }
}

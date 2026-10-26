class Solution {
    public int longestConsecutive(int[] nums) {
        var allNums = new HashSet();
        var longest = 0;

        for (var n: nums) {
            allNums.add(n);
        }

        for (var n: nums) {
            if (!allNums.contains(n - 1)) {
                var l = 1;

                while (allNums.contains(n + l)) {
                    l++;
                }

                longest = Math.max(longest, l);
            }
        }

        return longest;
    }
}

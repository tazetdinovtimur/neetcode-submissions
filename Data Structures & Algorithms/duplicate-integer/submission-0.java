class Solution {
    public boolean hasDuplicate(int[] nums) {
        var seen = new HashSet<Integer>();

        for (var n: nums) {
            if (seen.contains(n)) {
                return true;
            }

            seen.add(n);
        }

        return false;
    }
}
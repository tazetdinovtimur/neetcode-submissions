class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            var h = Math.min(heights[l], heights[r]);
            var area = h * (r - l);

            maxArea = Math.max(maxArea, area);

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}

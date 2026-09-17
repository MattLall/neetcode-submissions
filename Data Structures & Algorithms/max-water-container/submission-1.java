class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[r], heights[l]);
            int vol = height * width;
            // System.out.println(vol);
            if (max < vol) {
                // System.out.println("??");
                max = vol;
            }
            if (heights[r] < heights[l]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}

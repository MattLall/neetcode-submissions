class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int l = leftMost[i] + 1;
            int r = rightMost[i] - 1;
            int area = heights[i] * (r - l + 1);
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }
}

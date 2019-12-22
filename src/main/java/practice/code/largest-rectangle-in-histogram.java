// Largest Rectangle in Histogram
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int result = 0;
        for (int i = 0; i <= heights.length; ) {
            final int value = i < heights.length ? heights[i] : 0;
            if (s.isEmpty() || value > heights[s.peek()])
                s.push(i++);
            else {
                int tmp = s.pop();
                result = Math.max(result,
                        heights[tmp] * (s.isEmpty() ? i : i - s.peek() - 1));
            }
        }
        return result;
    }
}
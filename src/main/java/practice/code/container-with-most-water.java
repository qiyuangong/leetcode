// Container With Most Water
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (start < end) {
            int area = Math.min(height[end], height[start]) * (end - start);
            result = Math.max(result, area);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
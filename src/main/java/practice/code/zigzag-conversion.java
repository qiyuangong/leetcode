// ZigZag Conversion
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) return s;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0, index = i; index < s.length();
                 j++, index = (2 * numRows - 2) * j + i) {
                result.append(s.charAt(index));  // 垂直元素
                if (i == 0 || i == numRows - 1) continue;   // 斜对角元素
                if (index + (numRows - i - 1) * 2 < s.length())
                    result.append(s.charAt(index + (numRows - i - 1) * 2));
            }
        }
        return result.toString();
    }
}
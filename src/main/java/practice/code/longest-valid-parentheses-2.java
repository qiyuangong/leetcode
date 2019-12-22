// Longest Valid Parenthese
// 时间复杂度O(n)，空间复杂度O(n)
// @author 一只杰森(http://weibo.com/wjson)
class Solution {
    public int longestValidParentheses(final String s) {
        int[] f = new int[s.length()];
        int result = 0;
        for (int i = s.length() - 2; i >= 0; --i) {
            int match = i + f[i + 1] + 1;
            // case: "((...))"
            if (s.charAt(i) == '(' && match < s.length() &&
                    s.charAt(match) == ')') {
                f[i] = f[i + 1] + 2;
                // if a valid sequence exist afterwards "((...))()"
                if (match + 1 < s.length()) f[i] += f[match + 1];
            }
            result = Math.max(result, f[i]);
        }
        return result;
    }
}
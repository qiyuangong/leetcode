// Longest Valid Parenthese
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int longestValidParentheses(String s) {
        // the position of the last ')'
        int maxLen = 0, last = -1;
        // keep track of the positions of non-matching '('s
        Stack<Integer> lefts = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) =='(') {
                lefts.push(i);
            } else {
                if (lefts.empty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.empty()) {
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
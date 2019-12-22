// Longest Valid Parenthese
// 两遍扫描，时间复杂度O(n)，空间复杂度O(1)
// @author 曹鹏(http://weibo.com/cpcs)
class Solution {
public:
    int longestValidParentheses(const string& s) {
        int result = 0, depth = 0, start = -1;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                ++depth;
            } else {
                --depth;
                if (depth < 0) {
                    start = i;
                    depth = 0;
                } else if (depth == 0) {
                    result = max(result, i - start);
                }
            } 
        }

        depth = 0;
        start = s.size();
        for (int i = s.size() - 1; i >= 0; --i) {
            if (s[i] == ')') {
                ++depth;
            } else {
                --depth;
                if (depth < 0) {
                    start = i;
                    depth = 0;
                } else if (depth == 0) {
                    result = max(result, start - i);
                }
            } 
        }
        return result;
    }
};
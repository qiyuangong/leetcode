// Word Break
// 深搜，超时
// 时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        return dfs(s, dict, 0, 1);
    }
private:
    static bool dfs(const string &s, unordered_set<string> &dict,
            size_t start, size_t cur) {
        if (cur == s.size()) {
            return dict.find(s.substr(start, cur-start)) != dict.end();
        }
        if (dfs(s, dict, start, cur+1)) return true; // no cut
        if (dict.find(s.substr(start, cur-start)) != dict.end()) // cut here
            if (dfs(s, dict, cur+1, cur+1)) return true;
        return false;
    }
};
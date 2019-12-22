// Longest Common Prefix
// 纵向扫描，从位置0开始，对每一个位置比较所有字符串，直到遇到一个不匹配
// 时间复杂度O(n1+n2+...)
// @author 周倩 (http://weibo.com/zhouditty)
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if (strs.empty()) return "";

        for (int j = 0; j < strs[0].size(); ++j) { // 纵向扫描
            for (int i = 1; i < strs.size(); ++i) {
            	// 不会越界，请参考string::[]的文档
                if (strs[i][j] != strs[0][j])
                	return strs[0].substr(0,j);
            }
        }
        return strs[0];
    }
};
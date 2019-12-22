// Longest Common Prefix
// 纵向扫描，从位置0开始，对每一个位置比较所有字符串，直到遇到一个不匹配
// 时间复杂度O(n1+n2+...)
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int j = 0; j < strs[0].length(); ++j) { // 纵向扫描
            for (int i = 1; i < strs.length; ++i) {
                if (j == strs[i].length() || 
                        strs[i].charAt(j) != strs[0].charAt(j))
                    return strs[0].substring(0, j);
            }
        }
        return strs[0];
    }
}
// Longest Common Prefix
// 横向扫描，每个字符串与第0个字符串，从左到右比较，直到遇到一个不匹配，
// 然后继续下一个字符串
// 时间复杂度O(n1+n2+...)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int right_most = strs[0].length();
        for (int i = 1; i < strs.length; i++)
            for (int j = 0; j < right_most; j++)
                // 不会越界，请参考string::[]的文档
                if (j == strs[i].length() ||
                        strs[i].charAt(j) != strs[0].charAt(j))
                    right_most = j;

        return strs[0].substring(0, right_most);
    }
}
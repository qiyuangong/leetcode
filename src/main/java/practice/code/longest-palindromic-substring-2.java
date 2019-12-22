// Longest Palindromic Substring
// 动规，时间复杂度O(n^2)，空间复杂度O(n^2)
class Solution {
    public String longestPalindrome(final String s) {
        final int n = s.length();
        final boolean[][] f = new boolean[n][n];
        int maxLen = 1, start = 0;  // 最长回文子串的长度，起点

        for (int i = 0; i < n; i++) {
            f[i][i] = true;
            for (int j = 0; j < i; j++) {  // [j, i]
                f[j][i] = (s.charAt(j) == s.charAt(i) && 
                        (i - j < 2 || f[j + 1][i - 1]));
                if (f[j][i] && maxLen < (i - j + 1)) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
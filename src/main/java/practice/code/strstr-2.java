// Implement strStr()
// KMP，时间复杂度O(N+M)，空间复杂度O(M)
public class Solution {
    public int strStr(final String haystack, final String needle) {
        return kmp(haystack, needle);
    }

    /*
     * 计算部分匹配表，即next数组.
     *
     * @param[in] pattern 模式串
     * @param[out] next next数组
     * @return 无
     */
    private static void compute_prefix(final String pattern, final int[] next) {
        int i;
        int j = -1;

        next[0] = j;
        for (i = 1; i < pattern.length(); i++) {
            while (j > -1 && pattern.charAt(j + 1) != pattern.charAt(i)) j = next[j];

            if (pattern.charAt(i) == pattern.charAt(j + 1)) j++;
            next[i] = j;
        }
    }

    /*
     * @brief KMP算法.
     *
     * @param[in] text 文本
     * @param[in] pattern 模式串
     * @return 成功则返回第一次匹配的位置，失败则返回-1
     */
    private static int kmp(final String text, final String pattern) {
        int i;
        int j = -1;
        final int n = text.length();
        final int m = pattern.length();
        if (n == 0 && m == 0) return 0; /* "","" */
        if (m == 0) return 0;  /* "a","" */
        int[] next = new int[m];

        compute_prefix(pattern, next);

        for (i = 0; i < n; i++) {
            while (j > -1 && pattern.charAt(j + 1) != text.charAt(i)) j = next[j];

            if (text.charAt(i) == pattern.charAt(j + 1)) j++;
            if (j == m - 1) {
                return i-j;
            }
        }

        return -1;
    }
}
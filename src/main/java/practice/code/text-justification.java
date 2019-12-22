// Text Justification
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        final int n = words.length;
        int begin = 0, len = 0; // 当前行的起点，当前长度
        for (int i = 0; i < n; ++i) {
            if (len + words[i].length() + (i - begin) > maxWidth) {
                result.add(connect(words, begin, i - 1, len, maxWidth, false));
                begin = i;
                len = 0;
            }
            len += words[i].length();
        }
        // 最后一行不足 maxWidth
        result.add(connect(words, begin, n - 1, len, maxWidth, true));
        return result;
    }
    /**
     * @brief 将 words[begin, end] 连成一行
     * @param[in] words 单词列表
     * @param[in] begin 开始
     * @param[in] end 结束
     * @param[in] len words[begin, end]所有单词加起来的长度
     * @param[in] L 题目规定的一行长度
     * @param[in] is_last 是否是最后一行
     * @return 对齐后的当前行
     */
    private static String connect(String[] words, int begin, int end,
                   int len, int L, boolean is_last) {
        StringBuilder sb = new StringBuilder();
        final int n = end - begin + 1;
        for (int i = 0; i < n; ++i) {
            sb.append(words[begin + i]);
            addSpaces(sb, i, n - 1, L - len, is_last);
        }

        final int m = L - sb.length();
        for (int i = 0; i < m; ++i) sb.append(' ');
        return sb.toString();
    }

    /**
     * @brief 添加空格.
     * @param[inout]s 一行
     * @param[in] i 当前空隙的序号
     * @param[in] n 空隙总数
     * @param[in] L 总共需要添加的空额数
     * @param[in] is_last 是否是最后一行
     * @return 无
     */
    private static void addSpaces(StringBuilder sb, int i,
                                  int n, int L, boolean is_last) {
        if (n < 1 || i > n - 1) return;
        int spaces = is_last ? 1 : (L / n + (i < (L % n) ? 1 : 0));
        for (int j = 0; j < spaces; ++j) sb.append(' ');
    }
 }
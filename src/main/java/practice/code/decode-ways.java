// Decode Ways
// 动规，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int prev = 0;
        int cur = 1;
        // 长度为n的字符串，有 n+1个阶梯
        for (int i = 1; i <= s.length(); ++i) {
            if (s.charAt(i-1) == '0') cur = 0;

            if (i < 2 || !(s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
                prev = 0;

            int tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        return cur;
    }
}
// Minimum Window Substring
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty()) return "";
        if (s.length() < t.length()) return "";

        final int ASCII_MAX = 256;
        int[] appeared_count = new int[ASCII_MAX];
        int[] expected_count = new int[ASCII_MAX];

        for (int i = 0; i < t.length(); i++) expected_count[t.charAt(i)]++;

        int minWidth = Integer.MAX_VALUE, min_start = 0;  // 窗口大小，起点
        int wnd_start = 0;
        int appeared = 0;  // 完整包含了一个T
        //尾指针不断往后扫
        for (int wnd_end = 0; wnd_end < s.length(); wnd_end++) {
            if (expected_count[s.charAt(wnd_end)] > 0)  {  // this char is a part of T
                appeared_count[s.charAt(wnd_end)]++;
                if (appeared_count[s.charAt(wnd_end)] <= expected_count[s.charAt(wnd_end)])
                    appeared++;
            }
            if (appeared == t.length()) {  // 完整包含了一个T
                // 收缩头指针
                while (appeared_count[s.charAt(wnd_start)] > expected_count[s.charAt(wnd_start)]
                        || expected_count[s.charAt(wnd_start)] == 0) {
                    appeared_count[s.charAt(wnd_start)]--;
                    wnd_start++;
                }
                if (minWidth > (wnd_end - wnd_start + 1)) {
                    minWidth = wnd_end - wnd_start + 1;
                    min_start = wnd_start;
                }
            }
        }

        if (minWidth == Integer.MAX_VALUE) return "";
        else return s.substring(min_start, min_start + minWidth);
    }
}
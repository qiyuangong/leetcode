// Count and Say
// @author 连城 (http://weibo.com/lianchengzju)
// 时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
    public String countAndSay(int n) {
        String s = "1";

        while (--n > 0)
            s = getNext(s);

        return s;
    }

    String getNext(final String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length();) {
            int j = notEqual(s, i);
            sb.append(j - i);
            sb.append(s.charAt(i));
            i = j;
        }

        return sb.toString();
    }
    // find the first char that not equal to fromIndex
    private static int notEqual(final String s, int fromIndex) {
        final char target = s.charAt(fromIndex);
        int i = fromIndex;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) != target) break;
        }
        return i;
    }
}
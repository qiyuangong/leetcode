// Longest Palindromic Substring
// Manacher’s Algorithm
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking
    public String preProcess(final String s) {
        int n = s.length();
        if (n == 0) return "^$";

        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++) ret.append("#" + s.charAt(i));

        ret.append("#$");
        return ret.toString();
    }

    String longestPalindrome(String s) {
        String T = preProcess(s);
        final int n = T.length();
        // 以T[i]为中心，向左/右扩张的长度，不包含T[i]自己，
        // 因此 P[i]是源字符串中回文串的长度
        int[] P = new int[n];
        int C = 0, R = 0;

        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * C - i; // equals to i' = C - (i-C)

            P[i] = (R > i) ? Math.min(R - i, P[iMirror]) : 0;

            // Attempt to expand palindrome centered at i
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
                P[i]++;

            // If palindrome centered at i expand past R,
            // adjust center based on expanded palindrome.
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Find the maximum element in P.
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        final int start =(centerIndex - 1 - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
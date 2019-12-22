// Implement strStr()
// 暴力解法，时间复杂度O(N*M)，空间复杂度O(1)
class Solution {
    public int strStr(final String haystack, final String needle) {
        if (needle.isEmpty()) return 0;

        final int N = haystack.length() - needle.length() + 1;
        for (int i = 0; i < N; i++) {
            int j = i;
            int k = 0;
            while (j < haystack.length() && k < needle.length() && 
                    haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
            }
            if (k == needle.length()) return i;
        }
        return -1;
    }
}
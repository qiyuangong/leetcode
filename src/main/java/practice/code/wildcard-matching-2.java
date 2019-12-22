// Wildcard Matching
// 迭代版，时间复杂度O(n*m)，空间复杂度O(1)
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int ii = -1, jj = -1;
        while (i < s.length()) {
            if (j < p.length() && p.charAt(j) == '*') {
                // skip continuous '*'
                while (j < p.length() && p.charAt(j) == '*') ++j;
                if (j == p.length()) return true;
                ii = i;
                jj = j;
            }
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i; ++j;
            } else {
                if (ii == -1) return false;
                ++ii;
                i = ii;
                j = jj;
            }
        }
        // skip continuous '*'
        while (j < p.length() && p.charAt(j) == '*') ++j;
        return i == s.length() && j == p.length();
    }
}
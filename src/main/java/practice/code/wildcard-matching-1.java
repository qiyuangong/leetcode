// Wildcard Matching
// 递归版，会超时，用于帮助理解题意
// 时间复杂度O(n!*m!)，空间复杂度O(n)
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    private boolean isMatch(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length() || j == p.length()) return false;

        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') ++j;  //skip continuous '*'
            if (j == p.length()) return true;
            while (i < s.length() && !isMatch(s, i, p, j)) ++i;

            return i < s.length();
        }
        else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') 
            return isMatch(s, ++i, p, ++j);
        else return false;
    }
}
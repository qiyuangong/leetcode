// Regular Expression Matching
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean isMatch(final String s, final String p) {
        return isMatch(s, 0, p, 0);
    }
    private static boolean matchFirst(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) return j == p.length();
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
    private static boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) return i == s.length();

        // next char is not '*', then must match current character
        final char b = p.charAt(j);
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (matchFirst(s, i, p, j)) return isMatch(s, i + 1, p, j + 1);
            else return false;
        } else { // next char is '*'
            if (isMatch(s, i, p, j+2)) return true;  // try the length of 0
            while (matchFirst(s, i, p, j))  // try all possible lengths 
                if (isMatch(s, ++i, p, j+2)) return true;
            return false;
        }
    }
}

// Longest Palindromic Substring
// 备忘录法，会超时
// 时间复杂度O(n^2)，空间复杂度O(n^2)
public class Solution {
    private final HashMap<Pair, String> cache = new HashMap<>();
    
    public String longestPalindrome(final String s) {
        cache.clear();
        return cachedLongestPalindrome(s, 0, s.length() - 1);
    }

    String longestPalindrome(final String s, int i, int j) {
        final int length = j - i + 1;
        if (length < 2) return s.substring(i, j + 1);

        final String s1 = cachedLongestPalindrome(s, i + 1, j - 1);

        if (s1.length() == length - 2 && s.charAt(i + 1) == s.charAt(j - 1))
            return s.substring(i, j + 1);

        final String s2 = cachedLongestPalindrome(s, i + 1, j);
        final String s3 = cachedLongestPalindrome(s, i, j - 1);

        // return max(s1, s2, s3)
        if (s1.length() > s2.length()) return s1.length() > s3.length() ? s1 : s3;
        else return s2.length() > s3.length() ? s2 : s3;
    }

    String cachedLongestPalindrome(final String s, int i, int j) {
        final Pair key = new Pair(i, j);
        
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            final String result = longestPalindrome(s, i, j);
            cache.put(key, result);
            return result;
        }
    }
    
    // immutable
    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (this.hashCode() != other.hashCode()) return false;
            if (!(other instanceof Pair)) return false;

            final Pair o = (Pair) other;
            return this.x == o.x && this.y == o.y;
        }
    }
}
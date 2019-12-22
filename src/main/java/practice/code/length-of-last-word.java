// Length of Last Word
// 偷懒，用 STL
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int lengthOfLastWord(String s) {
        final Predicate isAlphabet = new Predicate() {
            @Override
            public boolean apply(char ch) {
                return Character.isAlphabetic(ch);
            }
        };
        final Predicate isNotAlphabet = new Predicate() {
            @Override
            public boolean apply(char ch) {
                return !Character.isAlphabetic(ch);
            }
        };
        int j = findIf(s, s.length() - 1, isAlphabet);
        int i = findIf(s, j, isNotAlphabet);
        return j - i;
    }

    interface Predicate {
        boolean apply(char ch);
    }
    // from right to left
    private static int findIf(final String s, int fromIndex, Predicate p) {
        for (int i = fromIndex; i >= 0; --i) {
            if (p.apply(s.charAt(i))) return i;
        }
        return -1;
    }
}
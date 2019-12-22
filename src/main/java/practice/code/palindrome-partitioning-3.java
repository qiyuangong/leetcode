// Palindrome Partitioning
// 动规，时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public List<List<String>> partition(String s) {
        final int n = s.length();
        boolean[][] p = new boolean[n][n]; // whether s[i,j] is palindrome
        for (int i = n - 1; i >= 0; --i)
            for (int j = i; j < n; ++j)
                p[i][j] = s.charAt(i) == s.charAt(j) &&
                        ((j - i < 2) || p[i + 1][j - 1]);

        List<List<String>>[] subPalins = new ArrayList[n]; // sub palindromes of s[0,i]
        for (int i = 0; i < n; ++i) subPalins[i] = new ArrayList<>();
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j)
                if (p[i][j]) {
                    String palindrome = s.substring(i, j+1);
                    if (j + 1 < n) {
                        for (List<String> v : subPalins[j + 1]) {
                            ArrayList<String> tmp = new ArrayList<>(v);
                            tmp.add(0, palindrome);
                            subPalins[i].add(tmp);
                        }
                    } else {
                        ArrayList<String> tmp = new ArrayList<>();
                        tmp.add(palindrome);
                        subPalins[i].add(tmp);
                    }
                }
        }
        return subPalins[0];
    }
}
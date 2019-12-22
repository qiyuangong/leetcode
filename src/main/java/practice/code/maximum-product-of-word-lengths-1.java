// Maximum Product of Word Lengths
// Time Complexity: O(26n^2), Space Complexity: O(26n)
public class Solution {
    public int maxProduct(String[] words) {
        final int n = words.length;
        final boolean[][] hashset = new boolean[n][ALPHABET_SIZE];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                hashset[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                boolean hasCommon = false;
                for (int k = 0; k < ALPHABET_SIZE; ++k) {
                    if (hashset[i][k] && hashset[j][k]) {
                        hasCommon = true;
                        break;
                    }
                }
                int tmp = words[i].length() * words[j].length();
                if (!hasCommon && tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
    private static final int ALPHABET_SIZE = 26;
}
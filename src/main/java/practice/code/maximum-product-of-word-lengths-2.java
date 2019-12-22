// Maximum Product of Word Lengths
// Time Complexity: O(n^2), Space Complexity: O(n)
public class Solution {
    public int maxProduct(String[] words) {
        final int n = words.length;
        final int[] hashset = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                hashset[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = words[i].length() * words[j].length();
                if ((hashset[i] & hashset[j]) == 0 && tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}
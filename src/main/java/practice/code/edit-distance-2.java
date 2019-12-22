// Edit Distance
// 二维动规+滚动数组
// 时间复杂度O(n*m)，空间复杂度O(n)
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length())
            return minDistance(word2, word1);

        int[] f = new int[word2.length() + 1];
        int upper_left = 0; // 额外用一个变量记录f[i-1][j-1]

        for (int i = 0; i <= word2.length(); ++i)
            f[i] = i;

        for (int i = 1; i <= word1.length(); ++i) {
            upper_left = f[0];
            f[0] = i;

            for (int j = 1; j <= word2.length(); ++j) {
                int upper = f[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    f[j] = upper_left;
                else
                    f[j] = 1 + Math.min(upper_left, Math.min(f[j], f[j - 1]));

                upper_left = upper;
            }
        }

        return f[word2.length()];
    }
}
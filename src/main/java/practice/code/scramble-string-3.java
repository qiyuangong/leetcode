// Scramble String
// 递归+剪枝
// 时间复杂度O(n^6)，空间复杂度O(1)
public class Solution {
    public boolean isScramble(String s1, String s2) {
        return isScramble(s1, 0, s1.length(), s2, 0);
    }
    private static boolean isScramble(String s1, int begin1, int end1,
                                      String s2, int begin2) {
        final int length = end1 - begin1;
        final int end2 = begin2 + length;
        if (length == 1) return s1.charAt(begin1) == s2.charAt(begin2);

        // 剪枝，提前返回
        int[] A = new int[26]; // 每个字符的计数器
        for(int i = 0; i < length; i++) A[s1.charAt(begin1+i)-'a']++;
        for(int i = 0; i < length; i++) A[s2.charAt(begin2+i)-'a']--;
        for(int i = 0; i < 26; i++) if (A[i] != 0) return false;

        for (int i = 1; i < length; ++i)
            if ((isScramble(s1, begin1, begin1 + i, s2, begin2)
                    && isScramble(s1, begin1 + i, end1, s2, begin2 + i))
                    || (isScramble(s1, begin1, begin1 + i, s2, end2 - i)
                    && isScramble(s1, begin1 + i, end1, s2, begin2)))
                return true;

        return false;
    }
}
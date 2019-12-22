// Interleaving String
// 递归，会超时，仅用来帮助理解
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        if (s1.isEmpty() || s2.isEmpty()) return true;

        return isInterleave(s1, 0, s1.length(),
                s2, 0, s2.length(), s3, 0, s3.length());
    }

    private static boolean isInterleave(String s1, int begin1, int end1,
                                        String s2, int begin2, int end2,
                                        String s3, int begin3, int end3) {
        if (begin3 == end3)
            return begin1 == end1 && begin2 == end2;

        return (begin1 < end1 && s1.charAt(begin1) == s3.charAt(begin3) &&
                isInterleave(s1, begin1 + 1, end1, s2, begin2, end2,
                        s3, begin3 + 1, end3)) ||
                (begin2 < end2 && s2.charAt(begin2) == s3.charAt(begin3) &&
                        isInterleave(s1, begin1, end1,
                                s2, begin2 + 1, end2, s3, begin3 + 1, end3));
    }
}
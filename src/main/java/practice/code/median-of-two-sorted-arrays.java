// Median of Two Sorted Arrays
// Time Complexity: O(log(m+n))，Space Complexity: O(log(m+n))
public class Solution {
    public double findMedianSortedArrays(final int[] A, final int[] B) {
        int total = A.length + B.length;
        if (total %2 == 1)
            return findKth(A, 0, B, 0, total / 2 + 1);
        else
            return (findKth(A, 0, B, 0, total / 2)
                    + findKth(A, 0, B, 0, total / 2 + 1)) / 2.0;
    }

    private static int findKth(final int[] A, int ai, final int[] B, int bi, int k) {
        //always assume that A is shorter than B
        if (A.length - ai > B.length - bi) {
            return findKth(B, bi, A, ai, k);
        }
        if (A.length - ai == 0) return B[bi + k - 1];
        if (k == 1) return Math.min(A[ai], B[bi]);

        //divide k into two parts
        int k1 = Math.min(k / 2, A.length - ai), k2 = k - k1;
        if (A[ai + k1 - 1] < B[bi + k2 - 1])
            return findKth(A, ai + k1, B, bi, k - k1);
        else if (A[ai + k1 - 1] > B[bi + k2 - 1])
            return findKth(A, ai, B, bi + k2, k - k2);
        else
            return A[ai + k1 - 1];
    }
};

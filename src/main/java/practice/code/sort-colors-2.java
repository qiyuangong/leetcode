// Sort Colors
// 双指针，时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public void sortColors(int[] A) {
        // 一个是red的index，一个是blue的index，两边往中间走
        int red = 0, blue = A.length - 1;

        for (int i = 0; i < blue + 1;) {
            if (A[i] == 0)
                swap (A, i++, red++);
            else if (A[i] == 2)
                swap(A, i, blue--);
            else
                i++;
        }
    }
    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
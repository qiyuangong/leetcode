// Gray Code
// 数学公式，时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        final int size = 1 << n;  // 2^n
        ArrayList<Integer> result = new ArrayList<>(size);

        for (int i = 0; i < size; ++i)
            result.add(binary_to_gray(i));
        return result;
    }
    private static int binary_to_gray(int n) {
        return n ^ (n >> 1);
    }
}
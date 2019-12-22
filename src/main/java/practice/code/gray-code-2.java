// Gray Code
// reflect-and-prefix method
// 时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        final int size = 1 << n;
        ArrayList<Integer> result = new ArrayList<>(size);

        result.add(0);
        for (int i = 0; i < n; i++) {
            final int highest_bit = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) // 要反着遍历，才能对称
                result.add(highest_bit | result.get(j));
        }
        return result;
    }
}
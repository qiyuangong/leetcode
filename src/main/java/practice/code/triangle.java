// Triangle
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i)
            for (int j = 0; j < i + 1; ++j) {
                int old = triangle.get(i).get(j);
                triangle.get(i).set(j, old + Math.min(triangle.get(i + 1).get(j),
                        triangle.get(i + 1).get(j + 1)));
            }

        return triangle.get(0).get(0);
    }
}
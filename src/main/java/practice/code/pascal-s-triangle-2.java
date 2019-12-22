// Pascal's Triangle
// 时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            for (int j = i - 2; j > 0; j--) {
                array.set(j, array.get(j - 1) + array.get(j));
            }
            array.add(1);
            result.add(new ArrayList<Integer>(array));
        }
        return result;
    }
}
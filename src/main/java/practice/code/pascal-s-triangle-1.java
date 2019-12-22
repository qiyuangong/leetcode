// Pascal's Triangle
// 时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        result.add(new ArrayList<>(Arrays.asList(1))); //first row

        for(int i = 2; i <= numRows; ++i) {
            Integer[] current = new Integer[i]; // 本行
            Arrays.fill(current, 1);
            List<Integer> prev = result.get(i - 2); // 上一行

            for(int j = 1; j < i - 1; ++j) {
                current[j] = prev.get(j-1) + prev.get(j); // 左上角和右上角之和
            }
            result.add(new ArrayList<>(Arrays.asList(current)));
        }
        return result;
    }
}
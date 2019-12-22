// Pascal's Triangle II
// 滚动数组，时间复杂度O(n^2)，空间复杂度O(n)
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--){
                array.set(j, array.get(j - 1) + array.get(j));
            }
            array.add(1);
        }
        return array;
    }
}
// Combination Sum III
// Time Complexity: O(9*8*...*(10-k)), Space Complexity: O(k)
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> path = new ArrayList<>();
        dfs(k, n, path, result);
        return result;
    }

    private static void dfs(int step, int gap, List<Integer> path,
                            List<List<Integer>> result) {
        if (step == 0) {
            if (gap == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if (gap < 1) return;

        final int start = path.isEmpty() ? 1 : path.get(path.size() - 1)+1;
        for (int i = start; i < 10; ++i) {
            path.add(i);
            dfs(step - 1, gap - i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
// Subsets II
// 增量构造法，版本2，时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); // 中间结果

        // 记录每个元素的出现次数
        HashMap<Integer, Integer> counterMap = new HashMap<>();
        for (int i : nums) {
            counterMap.put(i, counterMap.getOrDefault(i, 0) + 1);
        }
        // 将HashMap里的pair拷贝到一个数组里
        Pair[] counters = new Pair[counterMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            counters[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        Arrays.sort(counters);

        dfs(counters, 0, path, result);
        return result;
    }

    private static void dfs(Pair[] counters, int step, List<Integer> path,
                        List<List<Integer>> result) {
        if (step == counters.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <= counters[step].value; i++) {
            for (int j = 0; j < i; ++j) {
                path.add(counters[step].key);
            }
            dfs(counters, step + 1, path, result);
            for (int j = 0; j < i; ++j) {
                path.remove(path.size() - 1);
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.key < o.key) return -1;
            else if (this.key > o.key) return 1;
            else {
                return this.value - o.value;
            }
        }
    }
}
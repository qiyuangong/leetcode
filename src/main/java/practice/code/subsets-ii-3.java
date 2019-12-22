// Subsets II
// 位向量法，时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        List<List<Integer>> result = new ArrayList<>();
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

        // 每个元素选择了多少个
        HashMap<Integer, Integer> selected = new HashMap<>();
        for (Pair p : counters) {
            selected.put(p.key, 0 );
        }

        dfs(nums, counters, selected, 0, result);
        return result;
    }

    private static void dfs(int[] nums, Pair[] counters, HashMap<Integer, Integer> selected,
                            int step, List<List<Integer>> result) {
        if (step == counters.length) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (Pair p : counters) {
                for (int i = 0; i < selected.get(p.key); ++i) {
                    subset.add(p.key);
                }
            }
            result.add(subset);
            return;
        }

        for (int i = 0; i <= counters[step].value; i++) {
            selected.put(counters[step].key, i);
            dfs(nums, counters, selected, step + 1, result);
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
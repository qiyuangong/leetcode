// Permutations II
// 深搜，时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        List<List<Integer>> result = new ArrayList<>(); // 最终结果
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

        // 每个元素选择了多少个
        HashMap<Integer, Integer> selected = new HashMap<>();
        for (Pair p : counters) {
            selected.put(p.key, 0 );
        }

        n = nums.length;
        permute(counters, selected, path, result);
        return result;
    }

    private int n;

    void permute(Pair[] counters, HashMap<Integer,Integer> selected,
                 List<Integer> path, List<List<Integer>> result) {
        if (n == path.size()) {  // 收敛条件
            result.add(new ArrayList<>(path));
        }

        // 扩展状态
        for (Pair counter : counters) {
            if (selected.get(counter.key) < counter.value) {
                path.add(counter.key);
                selected.put(counter.key, selected.get(counter.key) + 1);
                permute(counters, selected, path, result);
                path.remove(path.size() - 1);
                selected.put(counter.key, selected.get(counter.key) - 1);
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
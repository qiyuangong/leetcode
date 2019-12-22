## Permutations II


### 描述

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
`[1,1,2]` have the following unique permutations:
`[1,1,2], [1,2,1]`, and `[2,1,1]`.


### next_permutation()

直接使用`std::next_permutation()`，代码与上一题相同。


### 重新实现next_permutation()

重新实现`std::next_permutation()`，代码与上一题相同。


### 递归

递归函数`permute()`的参数`p`，是中间结果，它的长度又能标记当前走到了哪一步，用于判断收敛条件。

扩展节点，每次从小到大，选一个没有被用光的元素，直到所有元素被用光。

本题不需要判重，因为状态装换图是一颗有层次的树。

{% if book.java %}
```java
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
```
{% endif %}

{% if book.cpp %}
```cpp
// Permutations II
// 深搜，时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        unordered_map<int, int> count_map; // 记录每个元素的出现次数
        for (int i : nums) {
            if (count_map.find(i) != count_map.end())
                count_map[i]++;
            else
                count_map[i] = 1;
        }

        // 将map里的pair拷贝到一个vector里
        vector<pair<int, int> > counters;
        for (auto p : count_map) {
            counters.push_back(p);
        }
        sort(counters.begin(), counters.end());

        // 每个元素选择了多少个
        unordered_map<int, int> selected;
        for (auto p : counters) {
            selected[p.first] = 0;
        }
        
        vector<vector<int>> result; // 最终结果
        vector<int> p;  // 中间结果

        n = nums.size();
        permute(counters, selected, p, result);
        return result;
    }

private:
    size_t n;
    typedef vector<pair<int, int> >::const_iterator Iter;

    void permute(const vector<pair<int, int> > &counters,
            unordered_map<int, int> &selected, 
            vector<int> &p, vector<vector<int> > &result) {
        if (n == p.size()) {  // 收敛条件
            result.push_back(p);
        }

        // 扩展状态
        for (auto counter : counters) {
            if (selected[counter.first] < counter.second) {
                p.push_back(counter.first);
                selected[counter.first]++;
                permute(counters, selected, p, result);
                p.pop_back(); // 撤销动作，返回上一层
                selected[counter.first]--;
            }
        }
    }
};
```
{% endif %}


### 相关题目

* [Next Permutation](next-permutation.md)
* [Permutation Sequence](permutation-sequence.md)
* [Permutations](permutations.md)
* [Combinations](combinations.md)

## Combinations


### 描述

Given two integers `n` and `k`, return all possible combinations of `k` numbers out of `1 ... n`.

For example,
If `n = 4` and `k = 2`, a solution is:

```
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```


### 递归

{% if book.java %}
```java
// Combinations
// 深搜，递归
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, 0, path, result);
        return result;
    }
    // start，开始的数, cur，已经选择的数目
    private static void dfs(int n, int k, int start, int cur,
                            List<Integer> path, List<List<Integer>> result) {
        if (cur == k) {
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i <= n; ++i) {
            path.add(i);
            dfs(n, k, i + 1, cur + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Combinations
// 深搜，递归
// 时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > result;
        vector<int> path;
        dfs(n, k, 1, 0, path, result);
        return result;
    }
private:
    // start，开始的数, cur，已经选择的数目
    static void dfs(int n, int k, int start, int cur,
            vector<int> &path, vector<vector<int> > &result) {
        if (cur == k) {
            result.push_back(path);
        }
        for (int i = start; i <= n; ++i) {
            path.push_back(i);
            dfs(n, k, i + 1, cur + 1, path, result);
            path.pop_back();
        }
    }
};
```
{% endif %}


### 相关题目

* [Next Permutation](next-permutation.md)
* [Permutation Sequence](permutation-sequence.md)
* [Permutations](permutations.md)
* [Permutations II](permutations-ii.md)

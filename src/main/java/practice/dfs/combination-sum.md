## Combination Sum


### 描述

Given a set of candidate numbers (`C`) and a target number (`T`), find all unique combinations in `C` where the candidate numbers sums to `T`.

The same repeated number may be chosen from `C` **unlimited** number of times.

Note:

* All numbers (including target) will be positive integers.
* Elements in a combination ($$a_1, a_2, ..., a_k$$) must be in non-descending order. (ie, $$a_1 \leq a_2 \leq ... \leq a_k$$).
* The solution set must not contain duplicate combinations.


For example, given candidate set `2,3,6,7` and target `7`, 
A solution set is: 

```
[7] 
[2, 2, 3] 
```


### 分析

无


### 代码

{% if book.java %}
```java
// Combination Sum
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); // 最终结果
        List<Integer> path = new ArrayList<>(); // 中间结果
        dfs(nums, path, result, target, 0);
        return result;
    }

    private static void dfs(int[] nums, List<Integer> path, 
                            List<List<Integer>> result, int gap, int start) {
        if (gap == 0) {  // 找到一个合法解
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) { // 扩展状态
            if (gap < nums[i]) return; // 剪枝

            path.add(nums[i]); // 执行扩展动作
            dfs(nums, path, result, gap - nums[i], i);
            path.remove(path.size() - 1);  // 撤销动作
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Combination Sum
// 时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int> > result; // 最终结果
        vector<int> path; // 中间结果
        dfs(nums, path, result, target, 0);
        return result;
    }

private:
    void dfs(vector<int>& nums, vector<int>& path, vector<vector<int> > &result,
            int gap, int start) {
        if (gap == 0) {  // 找到一个合法解
            result.push_back(path);
            return;
        }
        for (size_t i = start; i < nums.size(); i++) { // 扩展状态
            if (gap < nums[i]) return; // 剪枝

            path.push_back(nums[i]); // 执行扩展动作
            dfs(nums, path, result, gap - nums[i], i);
            path.pop_back();  // 撤销动作
        }
    }
};
```
{% endif %}


### 相关题目

* [Combination Sum II](combination-sum-ii.md)
* [Combination Sum III](combination-sum-iii.md)

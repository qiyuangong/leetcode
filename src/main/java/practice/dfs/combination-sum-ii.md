## Combination Sum II


### 描述

Given a collection of candidate numbers (`C`) and a target number (`T`), find all unique combinations in `C` where the candidate numbers sums to `T`.

Each number in `C` may only be used **once** in the combination.

Note:

* All numbers (including target) will be positive integers.
* Elements in a combination ($$a_1, a_2, ..., a_k$$) must be in non-descending order. (ie, $$a_1 > a_2 > ... > a_k$$).
* The solution set must not contain duplicate combinations.

For example, given candidate set `10,1,2,7,6,1,5` and target `8`, 
A solution set is: 

```
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6]
```


### 分析

无


### 代码

{% if book.java %}
```java
// Combination Sum II
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums); // 跟第 50 行配合，
        // 确保每个元素最多只用一次
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, result, target, 0);
        return result;
    }
    // 使用nums[start, nums.size())之间的元素，能找到的所有可行解
    private static void dfs(int[] nums, List<Integer> path,
                            List<List<Integer>> result, int gap, int start) {
        if (gap == 0) {  //  找到一个合法解
            result.add(new ArrayList<>(path));
            return;
        }

        int previous = -1;
        for (int i = start; i < nums.length; i++) {
            // 如果上一轮循环已经使用了nums[i]，则本次循环就不能再选nums[i]，
            // 确保nums[i]最多只用一次
            if (previous == nums[i]) continue;

            if (gap < nums[i]) return;  // 剪枝

            previous = nums[i];

            path.add(nums[i]);
            dfs(nums, path, result, gap - nums[i], i + 1);
            path.remove(path.size() - 1);  // 恢复环境
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Combination Sum II
// 时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > combinationSum2(vector<int> &nums, int target) {
        sort(nums.begin(), nums.end()); // 跟第 50 行配合，
                                        // 确保每个元素最多只用一次
        vector<vector<int> > result;
        vector<int> path;
        dfs(nums, path, result, target, 0);
        return result;
    }
private:
    // 使用nums[start, nums.size())之间的元素，能找到的所有可行解
    static void dfs(const vector<int> &nums, vector<int> &path, 
            vector<vector<int> > &result, int gap, int start) {
        if (gap == 0) {  //  找到一个合法解
            result.push_back(path);
            return;
        }

        int previous = -1;
        for (size_t i = start; i < nums.size(); i++) {
            // 如果上一轮循环已经使用了nums[i]，则本次循环就不能再选nums[i]，
            // 确保nums[i]最多只用一次
            if (previous == nums[i]) continue;

            if (gap < nums[i]) return;  // 剪枝

            previous = nums[i];

            path.push_back(nums[i]);
            dfs(nums, path, result, gap - nums[i], i + 1);
            path.pop_back();  // 恢复环境
        }
    }
};
```
{% endif %}


### 相关题目

* [Combination Sum](combination-sum.md)
* [Combination Sum III](combination-sum-iii.md)

## Permutations



### 描述

Given a collection of numbers, return all possible permutations.

For example,
`[1,2,3]` have the following permutations:
`[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2]`, and `[3,2,1]`.


### next_permutation()

函数 `next_permutation()`的具体实现见这节 [Next Permutation](../linear-list/array/next-permutation.md)。

{% if book.java %}
```java
// Permutations
// 重新实现 next_permutation()
// 时间复杂度O(n!)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        do {
            ArrayList<Integer> one = new ArrayList<>();
            for (int i : nums) {
                one.add(i);
            }
            result.add(one);
            // 调用的是 2.1.12 节的 next_permutation()
            // 而不是 std::next_permutation()
        } while(nextPermutation(nums, 0, nums.length));
        return result;
    }
    // 代码来自 2.1.12 节的 next_permutation()
    private static boolean nextPermutation(int[] nums, int begin, int end) {
        // From right to left, find the first digit(partitionNumber)
        // which violates the increase trend
        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) --p;

        // If not found, which means current sequence is already the largest
        // permutation, then rearrange to the first permutation and return false
        if(p == -1) {
            reverse(nums, begin, end);
            return false;
        }

        // From right to left, find the first digit which is greater
        // than the partition number, call it changeNumber
        int c = end - 1;
        while (c > 0 && nums[c] <= nums[p]) --c;

        // Swap the partitionNumber and changeNumber
        swap(nums, p, c);
        // Reverse all the digits on the right of partitionNumber
        reverse(nums, p+1, end);
        return true;
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static void reverse(int[] nums, int begin, int end) {
        end--;
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Permutations
// 重新实现 next_permutation()
// 时间复杂度O(n!)，空间复杂度O(1)
class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > result;
        sort(num.begin(), num.end());

        do {
            result.push_back(num);
        // 调用的是 2.1.12 节的 next_permutation()
        // 而不是 std::next_permutation()
        } while(next_permutation(num.begin(), num.end()));
        return result;
    }
private:
    // 代码来自 2.1.12 节的 next_permutation()
    void nextPermutation(vector<int> &nums) {
        next_permutation(nums.begin(), nums.end());
    }

    template<typename BidiIt>
    bool next_permutation(BidiIt first, BidiIt last) {
        // Get a reversed range to simplify reversed traversal.
        const auto rfirst = reverse_iterator<BidiIt>(last);
        const auto rlast = reverse_iterator<BidiIt>(first);

        // Begin from the second last element to the first element.
        auto pivot = next(rfirst);

        // Find `pivot`, which is the first element that is no less than its
        // successor.  `Prev` is used since `pivort` is a `reversed_iterator`.
        while (pivot != rlast && *pivot >= *prev(pivot))
            ++pivot;

        // No such elemenet found, current sequence is already the largest
        // permutation, then rearrange to the first permutation and return false.
        if (pivot == rlast) {
            reverse(rfirst, rlast);
            return false;
        }

        // Scan from right to left, find the first element that is greater than
        // `pivot`.
        auto change = find_if(rfirst, pivot, bind1st(less<int>(), *pivot));

        swap(*change, *pivot);
        reverse(rfirst, pivot);

        return true;
    }
};
```
{% endif %}


### 递归

本题是求路径本身，求所有解，函数参数需要标记当前走到了哪步，还需要中间结果的引用，最终结果的引用。

扩展节点，每次从左到右，选一个没有出现过的元素。

本题不需要判重，因为状态装换图是一颗有层次的树。收敛条件是当前走到了最后一个元素。


#### 代码

{% if book.java %}
```java
// Permutations
// 深搜，增量构造法
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); // 中间结果

        dfs(nums, path, result);
        return result;
    }
    private static void dfs(int[] nums, List<Integer> path,
                            List<List<Integer>> result) {
        if (path.size() == nums.length) {  // 收敛条件
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 扩展状态
        for (int i : nums) {
            // 查找 i 是否在path 中出现过
            int pos = path.indexOf(i);

            if (pos == -1) {
                path.add(i);
                dfs(nums, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Permutations
// 深搜，增量构造法
// 时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > permute(vector<int>& num) {
        sort(num.begin(), num.end());

        vector<vector<int>> result;
        vector<int> path;  // 中间结果

        dfs(num, path, result);
        return result;
    }
private:
    void dfs(const vector<int>& num, vector<int> &path,
            vector<vector<int> > &result) {
        if (path.size() == num.size()) {  // 收敛条件
            result.push_back(path);
            return;
        }

        // 扩展状态
        for (auto i : num) {
            // 查找 i 是否在path 中出现过
            auto pos = find(path.begin(), path.end(), i);

            if (pos == path.end()) {
                path.push_back(i);
                dfs(num, path, result);
                path.pop_back();
            }
        }
    }
};
```
{% endif %}


### 相关题目

* [Next Permutation](next-permutation.md)
* [Permutation Sequence](permutation-sequence.md)
* [Permutations II](permutations-ii.md)
* [Combinations](combinations.md)

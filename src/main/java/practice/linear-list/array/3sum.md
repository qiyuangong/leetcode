## 3Sum


### 描述

Given an array `S` of `n` integers, are there elements `a, b, c` in `S` such that `a + b + c = 0`? Find all unique triplets in the array which gives the sum of zero.

Note:

* Elements in a triplet `(a,b,c)` must be in non-descending order. (ie, $$a \leq b \leq c$$)
* The solution set must not contain duplicate triplets.


For example, given array `S = {-1 0 1 2 -1 -4}`.

A solution set is:

```
(-1, 0, 1)
(-1, -1, 2)
```


### 分析

先排序，然后左右夹逼，复杂度 $$O(n^2)$$。

这个方法可以推广到`k-sum`，先排序，然后做`k-2`次循环，在最内层循环左右夹逼，时间复杂度是 $$O(\max\{n \log n, n^{k-1}\})$$。


### 代码

{% if book.java %}
```java
// 3Sum
// 先排序，然后左右夹逼，注意跳过重复的数
// Time Complexity: O(n^2)，Space Complexity: O(1)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        final int target = 0;
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                } else if(nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    while(nums[k] == nums[k+1] && j < k) --k;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                    while(nums[k] == nums[k+1] && j < k) --k;
                }
            }
        }
        return result;
    }
};
```
{% endif %}

{% if book.cpp %}
```cpp
// 3Sum
// 先排序，然后左右夹逼，注意跳过重复的数
// Time Complexity: O(n^2)，Space Complexity: O(1)
class Solution {
    public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        if (nums.size() < 3) return result;
        sort(nums.begin(), nums.end());
        const int target = 0;
        
        auto last = nums.end();
        for (auto i = nums.begin(); i < last-2; ++i) {
            if (i > nums.begin() && *i == *(i-1)) continue;
            auto j = i+1;
            auto k = last-1;
            while (j < k) {
                if (*i + *j + *k < target) {
                    ++j;
                    while(*j == *(j - 1) && j < k) ++j;
                } else if (*i + *j + *k > target) {
                    --k;
                    while(*k == *(k + 1) && j < k) --k;
                } else {
                    result.push_back({ *i, *j, *k });
                    ++j;
                    --k;
                    while(*j == *(j - 1) && j < k) ++j;
                    while(*k == *(k + 1) && j < k) --k;
                }
            }
        }
        return result;
    }
};
```
{% endif %}


### 相关题目


* [Two sum](two-sum.md)
* [3Sum Closest](3sum-closest.md)
* [4Sum](4sum.md)

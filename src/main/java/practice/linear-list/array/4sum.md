## 4Sum


### 描述

Given an array `S` of `n` integers, are there elements `a, b, c`, and `d` in `S` such that `a + b + c + d = target`? Find all unique quadruplets in the array which gives the sum of target.

Note:

* Elements in a quadruplet `(a,b,c,d)` must be in non-descending order. (ie, $$a \leq b \leq c \leq d$$)
* The solution set must not contain duplicate quadruplets.


For example, given array `S = {1 0 -1 0 -2 2}`, and `target = 0`. 

A solution set is:

```
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
```



### 分析

先排序，然后左右夹逼，复杂度 $$O(n^3)$$，会超时。

可以用一个hashmap先缓存两个数的和，最终复杂度$$O(n^3)$$。这个策略也适用于 3Sum 。


### 左右夹逼

{% if book.java %}
```java
// 4Sum
// 先排序，然后左右夹逼
// Time Complexity: O(n^3)，Space Complexity: O(1)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    final int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        ++k;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                    } else if (sum > target) {
                        --l;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        --l;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    }
                }
            }
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// 4Sum
// 先排序，然后左右夹逼
// Time Complexity: O(n^3)，Space Complexity: O(1)
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        if (nums.size() < 4) return result;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size() - 3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.size() - 2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = nums.size() - 1;
                while (k < l) {
                    const int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        ++k;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                    } else if (sum > target) {
                        --l;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    } else {
                        result.push_back({nums[i], nums[j], nums[k], nums[l]});
                        ++k;
                        --l;
                        while(nums[k] == nums[k-1] && k < l) ++k;
                        while(nums[l] == nums[l+1] && k < l) --l;
                    }
                }
            }
        }
        return result;
    }
};
```
{% endif %}


### HashMap 做缓存

{% if book.java %}
```java
// 4Sum
// 先排序，然后左右夹逼
// Time Complexity: O(n^3)，Space Complexity: O(1)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);

        final HashMap<Integer, ArrayList<int[]>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                ArrayList<int[]> value = cache.get(nums[i] + nums[j]);
                if (value == null) {
                    value = new ArrayList<>();
                    cache.put(nums[i] + nums[j], value);
                }
                value.add(new int[]{i, j});
            }
        }

        final HashSet<String> used = new HashSet<>(); // avoid duplicates
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                final ArrayList<int[]> list = cache.get(target - nums[i] - nums[j]);
                if (list == null) continue;;
                for (int[] pair : list) {
                    if (j >= pair[0]) continue;  // overlap
                    
                    final Integer[] sol = new Integer[]{nums[i], nums[j], nums[pair[0]], nums[pair[1]]};
                    Arrays.sort(sol);
                    final String key = Arrays.toString(sol);
                    
                    if(!used.contains(key)){
                        result.add(Arrays.asList(sol));
                        used.add(key);
                    }
                }
            }
        }
        return result;
    }
}
```
{% endif %}


{% if book.cpp %}
```cpp
// 4Sum
// 用一个hashmap先缓存两个数的和
// Time Complexity: 平均O(n^2)，最坏O(n^4)，Space Complexity: O(n^2)
class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &nums, int target) {
        vector<vector<int>> result;
        if (nums.size() < 4) return result;
        sort(nums.begin(), nums.end());

        unordered_map<int, vector<pair<int, int> > > cache;
        for (size_t a = 0; a < nums.size(); ++a) {
            for (size_t b = a + 1; b < nums.size(); ++b) {
                cache[nums[a] + nums[b]].push_back(pair<int, int>(a, b));
            }
        }

        for (int c = 0; c < nums.size(); ++c) {
            for (size_t d = c + 1; d < nums.size(); ++d) {
                const int key = target - nums[c] - nums[d];
                if (cache.find(key) == cache.end()) continue;

                const auto& vec = cache[key];
                for (size_t k = 0; k < vec.size(); ++k) {
                    if (c <= vec[k].second)
                        continue; // 有重叠

                    result.push_back( { nums[vec[k].first],
                            nums[vec[k].second], nums[c], nums[d] });
                }
            }
        }
        sort(result.begin(), result.end());
        result.erase(unique(result.begin(), result.end()), result.end());
        return result;
    }
};
```
{% endif %}


### 相关题目


* [Two sum](two-sum.md)
* [3Sum](3sum.md)
* [3Sum Closest](3sum-closest.md)

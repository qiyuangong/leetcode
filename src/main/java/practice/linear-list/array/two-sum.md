## Two Sum


### 描述

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input:  `numbers={2, 7, 11, 15}, target=9`

Output: `index1=1, index2=2`


### 分析

方法1：暴力，复杂度$$O(n^2)$$，会超时

方法2：hash。用一个哈希表，存储每个数对应的下标，复杂度`O(n)`.

方法3：先排序，然后左右夹逼，排序$$O(n\log n)$$，左右夹逼`O(n)`，最终$$O(n\log n)$$。但是注意，这题需要返回的是下标，而不是数字本身，因此这个方法行不通。


### 代码

{% if book.java %}
```java
// Two Sum
// 方法2：hash。用一个哈希表，存储每个数对应的下标
// Time Complexity: O(n)，Space Complexity: O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            final Integer v = myMap.get(target-nums[i]);
            if (v != null && v > i) {
                return new int[]{i+1, v+1};
            }
        }
        return null;
    }
};
```
{% endif %}

{% if book.cpp %}
// Two Sum
// 方法2：hash。用一个哈希表，存储每个数对应的下标
// Time Complexity: O(n)，Space Complexity: O(n)
class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> my_map;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            my_map[nums[i]] = i;
        }
        for (int i = 0; i < nums.size(); i++) {
            auto iter = my_map.find(target-nums[i]);
            if (iter != my_map.end() && iter->second > i) {
                result.push_back(i + 1);
                result.push_back(iter->second + 1);
                break;
            }
        }
        return result;
    }
};
```cpp
```
{% endif %}


### 相关题目

* [3Sum](3sum.md)
* [3Sum Closest](3sum-closest.md)
* [4Sum](4sum.md)

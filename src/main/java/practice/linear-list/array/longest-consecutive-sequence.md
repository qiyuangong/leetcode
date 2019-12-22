## Longest Consecutive Sequence


### 描述

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given `[100, 4, 200, 1, 3, 2]`,
The longest consecutive elements sequence is `[1, 2, 3, 4]`. Return its length: 4.

Your algorithm should run in `O(n)` complexity.


### 分析

如果允许$$O(n \log n)$$的复杂度，那么可以先排序，可是本题要求`O(n)`。

由于序列里的元素是无序的，又要求`O(n)`，首先要想到用哈希表。

用一个哈希表存储所有出现过的元素，对每个元素，以该元素为中心，往左右扩张，直到不连续为止，记录下最长的长度。


### 代码

{% if book.java %}
```java
// Longest Consecutive Sequence
// Time Complexity: O(n)，Space Complexity: O(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        final HashSet<Integer> mySet = new HashSet<Integer>();
        for (int i : nums) mySet.add(i);
        
        int longest = 0;
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; mySet.contains(j); --j) {
                mySet.remove(j);
                ++length;
            }
            for (int j = i + 1; mySet.contains(j); ++j) {
                mySet.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Longest Consecutive Sequence
// Time Complexity: O(n)，Space Complexity: O(n)
class Solution {
public:
    int longestConsecutive(const vector<int> &nums) {
        unordered_set<int> my_set;
        for (auto i : nums) my_set.insert(i);

        int longest = 0;
        for (auto i : nums) {
            int length = 1;
            for (int j = i - 1; my_set.find(j) != my_set.end(); --j) {
                my_set.erase(j);
                ++length;
            }
            for (int j = i + 1; my_set.find(j) != my_set.end(); ++j) {
                my_set.erase(j);
                ++length;
            }
            longest = max(longest, length);
        }
        return longest;
    }
};
```
{% endif %}

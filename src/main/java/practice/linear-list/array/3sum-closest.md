## 3Sum Closest


### 描述

Given an array `S` of `n` integers, find three integers in `S` such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array `S = {-1 2 1 -4}`, and `target = 1`.

The sum that is closest to the target is 2. (`-1 + 2 + 1 = 2`).


### 分析

先排序，然后左右夹逼，复杂度 $$O(n^2)$$。


### 代码

{% if book.java %}
```java
// 3Sum Closest
// 先排序，然后左右夹逼
// Time Complexity: O(n^2), Space Complexity: O(1)
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minGap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; ++i) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                final int sum = nums[i] + nums[j] + nums[k];
                final int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    result = sum;
                    minGap = gap;
                }

                if (sum < target) ++j;
                else              --k;
            }
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// 3Sum Closest
// 先排序，然后左右夹逼//
// Time Complexity: O(n^2), Space Complexity: O(1)
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int result = 0;
        int min_gap = INT_MAX;

        sort(nums.begin(), nums.end());

        for (auto a = nums.begin(); a != prev(nums.end(), 2); ++a) {
            auto b = next(a);
            auto c = prev(nums.end());

            while (b < c) {
                const int sum = *a + *b + *c;
                const int gap = abs(sum - target);

                if (gap < min_gap) {
                    result = sum;
                    min_gap = gap;
                }

                if (sum < target) ++b;
                else              --c;
            }
        }

        return result;
    }
};
```
{% endif %}


### 相关题目


* [Two sum](two-sum.md)
* [3Sum](3sum.md)
* [4Sum](4sum.md)

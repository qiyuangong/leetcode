## Maximum Subarray


### 描述

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array `[−2,1,−3,4,−1,2,1,−5,4]`,
the contiguous subarray `[4,−1,2,1]` has the largest `sum = 6`.


### 分析

最大连续子序列和，非常经典的题。

当我们从头到尾遍历这个数组的时候，对于数组里的一个整数，它有几种选择呢？它只有两种选择： 1、加入之前的SubArray；2. 自己另起一个SubArray。那什么时候会出现这两种情况呢？

如果之前SubArray的总体和大于0的话，我们认为其对后续结果是有贡献的。这种情况下我们选择加入之前的SubArray

如果之前SubArray的总体和为0或者小于0的话，我们认为其对后续结果是没有贡献，甚至是有害的（小于0时）。这种情况下我们选择以这个数字开始，另起一个SubArray。

设状态为`f[j]`，表示以`S[j]`结尾的最大连续子序列和，则状态转移方程如下：

$$f[j] = \max\left\{f[j-1]+S[j],S[j]\right\}, 1 \leq j \leq n$$

$$target = \max\left\{f[j]\right\}, 1 \leq j \leq n$$

解释如下：

* 情况一，S[j]不独立，与前面的某些数组成一个连续子序列，则最大连续子序列和为`f[j-1]+S[j]`。
* 情况二，S[j]独立划分成为一段，即连续子序列仅包含一个数S[j]，则最大连续子序列和为`S[j]`。  

其他思路：

* 思路2：直接在i到j之间暴力枚举，复杂度是`O(n^3)`
* 思路3：处理后枚举，连续子序列的和等于两个前缀和之差，复杂度`O(n^2)`。
* 思路4：分治法，把序列分为两段，分别求最大连续子序列和，然后归并，复杂度`O(nlog n)`
* 思路5：把思路2`O(n^2)`的代码稍作处理，得到`O(n)`的算法
* 思路6：当成M=1的最大M子段和


### 动规

{% if book.java %}
{% codesnippet "./code/maximum-subarray-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int maxSubArray(const vector<int>& nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            maxLocal = max(nums[i], nums[i] + maxLocal);
            global = max(global, maxLocal);
        }
        return global;
    }
};
```
{% endif %}


### 思路5

{% if book.java %}
```java
// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int maxSubArray(int[] nums) {
        return mcss(nums, 0, nums.length);
    }
    // 思路5，求最大连续子序列和
    private static int mcss(int[] nums, int begin, int end) {
        final int n = end - begin;
        int[] sum = new int[n + 1];  // 前n项和

        int result = Integer.MIN_VALUE;
        int cur_min = sum[0];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[begin  + i - 1];
        }
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, sum[i] - cur_min);
            cur_min = Math.min(cur_min, sum[i]);
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Maximum Subarray
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    int maxSubArray(vector<int>& A) {
        return mcss(A.begin(), A.end());
    }
private:
    // 思路5，求最大连续子序列和
    template <typename Iter>
    static int mcss(Iter begin, Iter end) {
        int result, cur_min;
        const int n = distance(begin, end);
        int *sum = new int[n + 1];  // 前n项和

        sum[0] = 0;
        result = INT_MIN;
        cur_min = sum[0];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + *(begin  + i - 1);
        }
        for (int i = 1; i <= n; i++) {
            result = max(result, sum[i] - cur_min);
            cur_min = min(cur_min, sum[i]);
        }
        delete[] sum;
        return result;
    }
};
```
{% endif %}


### 相关题目

* [Maximum Subarray](maximum-subarray.md)
* [Binary Tree Maximum Path Sum](../binary-tree/recursion/binary-tree-maximum-path-sum.md)

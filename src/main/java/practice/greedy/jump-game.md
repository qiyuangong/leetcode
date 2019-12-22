## Jump Game


### 描述

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:

`A = [2,3,1,1,4]`, return true.

`A = [3,2,1,0,4]`, return false.


### 分析

由于每层最多可以跳`A[i]`步，也可以跳0或1步，因此如果能到达最高层，则说明每一层都可以到达。有了这个条件，说明可以用贪心法。

思路一：正向，从0出发，一层一层网上跳，看最后能不能超过最高层，能超过，说明能到达，否则不能到达。

思路二：逆向，从最高层下楼梯，一层一层下降，看最后能不能下降到第0层。

思路三：如果不敢用贪心，可以用动规，设状态为`f[i]`，表示从第0层出发，走到`A[i]`时剩余的最大步数，则状态转移方程为：

$$
f[i] = max(f[i-1], A[i-1])-1, i > 0
$$


### 代码1

{% if book.java %}
{% codesnippet "./code/jump-game-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Jump Game
// 思路1，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    bool canJump(const vector<int>& nums) {
        int reach = 1; // 最右能跳到哪里
        for (int i = 0; i < reach && reach < nums.size(); ++i)
            reach = max(reach,  i + 1 + nums[i]);
        return reach >= nums.size();
    }
};
```
{% endif %}


### 代码2

{% if book.java %}
{% codesnippet "./code/jump-game-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Jump Game
// 思路2，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    bool canJump (const vector<int>& nums) {
        if (nums.empty()) return true;
        // 逆向下楼梯，最左能下降到第几层
        int left_most = nums.size() - 1;

        for (int i = nums.size() - 2; i >= 0; --i)
            if (i + nums[i] >= left_most)
                left_most = i;

        return left_most == 0;
    }
};
```
{% endif %}


### 代码3

{% if book.java %}
{% codesnippet "./code/jump-game-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Jump Game
// 思路三，动规，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    bool canJump(const vector<int>& nums) {
        vector<int> f(nums.size(), 0);
        f[0] = 0;
        for (int i = 1; i < nums.size(); i++) {
            f[i] = max(f[i - 1], nums[i - 1]) - 1;
            if (f[i] < 0) return false;;
        }
        return f[nums.size() - 1] >= 0;
    }
};
```
{% endif %}


### 相关题目

* [Jump Game II ](jump-game-ii.md)

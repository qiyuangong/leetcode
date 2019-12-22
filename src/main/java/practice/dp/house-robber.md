## House Robber


### 描述

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and **it will automatically contact the police if two adjacent houses were broken into on the same night**.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight **without alerting the police**.


### 分析

这是一个多阶段最优化问题，且要走到最底部才能知道答案，因此广搜排除，只剩下贪心和动规。贪心明显要排除，只剩下动规。

设状态 `f[i]` 为到位置`i`时能抢到的金钱最大和，那么状态转移方程如下：

`f[i]=max(f[i-1], f[i-2] + nums[i])`

其含义是，如果不选择`i`，则抢到的钱是`f[i-1]`，如果选择`i`，则能抢到的钱是`f[i-2] + nums[i]`。


### 解法1

{% if book.java %}
{% codesnippet "./code/house-robber-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 解法2

在状态转移方程中，我们可以发现 `f[i]`仅仅依赖前两项，因此用两个整数变量即可代替一位数组，将空间复杂度降为`O(1)`。

{% if book.java %}
{% codesnippet "./code/house-robber-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

## Best Time to Buy and Sell Stock IV


### 描述

Say you have an array for which the i-th element is the price of a given stock on day `i`.

Design an algorithm to find the maximum profit. You may complete at most `k` transactions.

**Note**:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


### 分析

设两个状态，`global[i][j]` 表示i天前最多可以进行j次交易的最大利润，`local[i][j]`表示i天前最多可以进行j次交易，且在第i天进行了第j次交易的最大利润。状态转移方程如下：

```
local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
global[i][j] = max(local[i][j], global[i-1][j])
```

关于`global`的状态转移方程比较简单，不断地和已经计算出的local进行比较，把大的保存在global中。

关于`local`的状态转移方程，取下面二者中较大的一个：

* 全局前`i-1`天进行了`j-1`次交易，然后然后加上今天的交易产生的利润（如果赚钱就交易，不赚钱就不交易，什么也不发生，利润是0）
* 局部前`i-1`天进行了`j`次交易，然后加上今天的差价（`local[i-1][j]`是第`i-1`天卖出的交易，它加上diff后变成第`i`天卖出，并不会增加交易次数。无论`diff`是正还是负都要加上，否则就不满足`local[i][j]`必须在最后一天卖出的条件了）

注意，当`k`大于数组的大小时，上述算法将变得低效，此时可以改为不限交易次数的方式解决，即等价于 "Best Time to Buy and Sell Stock II"。


### 解法1

{% if book.java %}
{% codesnippet "./code/best-time-to-buy-and-sell-stock-iv-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

### 解法2 最长m段子段和

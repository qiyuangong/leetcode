## Best Time to Buy and Sell Stock with Cooldown


### 描述

Almost the ame as [Best Time to Buy and Sell Stock II](../greedy/best-time-to-buy-and-sell-stock-ii.md) but with one restriction: after you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day).

**Example**:

```
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
```


### 分析

这题比[Best Time to Buy and Sell Stock II](../greedy/best-time-to-buy-and-sell-stock-ii.md)多了一个cooldown的条件，就变得麻烦多了。这题是一个多阶段优化问题，首先范围缩小到广搜，贪心或者动规。因为每步之间互相牵连，贪心显然不行。广搜固然可以，不过是`O(2^n)`复杂度，所以我们先考虑用动规。

对于每一天，有三种动作，buy, sell, cooldown, sell 和 cooldown 可以合并成一种状态，因为手里最终没有股票。最终需要的结果是 sell，即手里股票卖了获得最大利润。我们可以用两个数组来记录当前持股和未持股的状态，令`sell[i]` 表示第i天未持股时，获得的最大利润，`buy[i]`表示第i天持有股票时，获得的最大利润。

对于`sell[i]`，最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是今天卖了股票，所以状态转移方程如下：

`sell[i] = max{sell[i - 1], buy[i-1] + prices[i]}`

对于`buy[i]`，最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天卖了股票，今天买了股票，因为 cooldown 只能隔天交易，所以今天买股票要追溯到前天的状态。状态转移方程如下：

`buy[i] = max{buy[i-1], sell[i-2] - prices[i]}`

最终我们要求的结果是`sell[n - 1]`，表示最后一天结束时，手里没有股票时的最大利润。

这个算法的空间复杂度是`O(n)`，不过由于`sell[i]`仅仅依赖前一项，`buy[i]`仅仅依赖前两项，所以可以优化到`O(1)`，具体见第二种代码实现。


### 代码1 O(n)空间

{% if book.java %}
{% codesnippet "./code/best-time-to-buy-and-sell-stock-with-cooldown-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 代码2 O(1)空间

{% if book.java %}
{% codesnippet "./code/best-time-to-buy-and-sell-stock-with-cooldown-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

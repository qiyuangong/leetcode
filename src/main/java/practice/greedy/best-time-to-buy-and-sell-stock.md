## Best Time to Buy and Sell Stock


### 描述

Say you have an array for which the i-th element is the price of a given stock on day i.

If you were only permitted to complete at    most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


### 分析

贪心法，分别找到价格最低和最高的一天，低进高出，注意最低的一天要在最高的一天之前。

把原始价格序列变成差分序列，本题也可以做是最大`m`子段和，`m=1`。

### 代码

{% if book.java %}
{% codesnippet "./code/best-time-to-buy-and-sell-stock."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Best Time to Buy and Sell Stock
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        if (prices.size() < 2) return 0;
        int profit = 0;  // 差价，也就是利润
        int cur_min = prices[0]; // 当前最小

        for (int i = 1; i < prices.size(); i++) {
            profit = max(profit, prices[i] - cur_min);
            cur_min = min(cur_min, prices[i]);
        }
        return profit;
    }
};
```
{% endif %}


### 相关题目

* [Best Time to Buy and Sell Stock II](best-time-to-buy-and-sell-stock-ii.md)
* [Best Time to Buy and Sell Stock III](../dp/best-time-to-buy-and-sell-stock-iii.md)

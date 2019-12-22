## Palindrome Partitioning II


### 描述

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given `s = "aab"`,

Return 1 since the palindrome partitioning `["aa","b"]` could be produced using 1 cut.


### 分析

定义状态`f(i,j)`表示区间`[i,j]`之间最小的cut数，则状态转移方程为 

$$
f(i,j)=\min\left\{f(i,k)+f(k+1,j)\right\}, i \leq k \leq j, 0 \leq i \leq j<n
$$

这是一个二维函数，实际写代码比较麻烦。
 
所以要转换成一维DP。如果每次，从i往右扫描，每找到一个回文就算一次DP的话，就可以转换为`f(i)=区间[i, n-1]之间最小的cut数`，n为字符串长度，则状态转移方程为

$$
f(i)=\min\left\{f(j+1)+1\right\}, i \leq j<n
$$

一个问题出现了，就是如何判断`[i,j]`是否是回文？每次都从i到j比较一遍？太浪费了，这里也是一个DP问题。

定义状态 `P[i][j] = true if [i,j]为回文`，那么

```
P[i][j] = str[i] == str[j] && P[i+1][j-1]
```


### 代码

{% codesnippet "./code/palindrome-partitioning-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Palindrome Partitioning](../dfs/palindrome-partitioning.md)

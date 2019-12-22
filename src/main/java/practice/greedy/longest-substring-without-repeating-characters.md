## Longest Substring Without Repeating Characters


### 描述

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for `"abcabcbb"` is `"abc"`, which the length is 3. For `"bbbbb"` the longest substring is `"b"`, with the length of 1.


### 分析

假设子串里含有重复字符，则父串一定含有重复字符，单个子问题就可以决定父问题，因此可以用贪心法。跟动规不同，动规里，单个子问题只能影响父问题，不足以决定父问题。

从左往右扫描，当遇到重复字母时，以上一个重复字母的`index+1`，作为新的搜索起始位置，直到最后一个字母，复杂度是`O(n)`。如下图所示。

![不含重复字符的最长子串](../images/longest-substring-without-repeating-characters.png)


### 代码

{% codesnippet "./code/longest-substring-without-repeating-characters."+book.suffix, language=book.suffix %}{% endcodesnippet %}

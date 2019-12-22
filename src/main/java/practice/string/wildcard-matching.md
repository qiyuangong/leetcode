## Wildcard Matching


### 描述

Implement wildcard pattern matching with support for `'?'` and `'*'`.

`'?'` Matches any single character.
`'*'` Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:

```cpp
bool isMatch(const char *s, const char *p)
```

Some examples:

```
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
```


### 分析

跟上一题很类似。

主要是`'*'`的匹配问题。`p`每遇到一个`'*'`，就保留住当前`'*'`的坐标和`s`的坐标，然后`s`从前往后扫描，如果不成功，则`s++`，重新扫描。


### 递归版

{% codesnippet "./code/wildcard-matching-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% codesnippet "./code/wildcard-matching-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Regular Expression Matching](regular-expression-matching.md)

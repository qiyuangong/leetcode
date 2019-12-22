## Regular Expression Matching


### 描述

Implement regular expression matching with support for `'.'` and `'*'`.

`'.'` Matches any single character.
`'*'` Matches zero or more of the preceding element.

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
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```


### 分析

这是一道很有挑战的题。


### 递归版

{% codesnippet "./code/regular-expression-matching."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Wildcard Matching](wildcard-matching.md)

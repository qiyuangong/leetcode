## Word Break


### 描述

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = `"leetcode"`,

dict = `["leet", "code"]`.

Return true because `"leetcode"` can be segmented as `"leet code"`.


### 分析

设状态为`f(i)`，表示`s[0,i)`是否可以分词，则状态转移方程为

`f(i) = any_of(f(j) && s[j,i] in dict), 0 <= j < i`


### 深搜

{% if book.java %}
```java
// Word Break
// 深搜，超时
// 时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, 0, 1);
    }
    private static boolean dfs(String s, Set<String> dict,
                    int start, int cur) {
        if (cur == s.length()) {
            return dict.contains(s.substring(start, cur));
        }
        if (dfs(s, dict, start, cur+1)) return true; // no cut
        if (dict.contains(s.substring(start, cur))) // cut here
            if (dfs(s, dict, cur+1, cur+1)) return true;
        return false;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Word Break
// 深搜，超时
// 时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        return dfs(s, dict, 0, 1);
    }
private:
    static bool dfs(const string &s, unordered_set<string> &dict,
            size_t start, size_t cur) {
        if (cur == s.size()) {
            return dict.find(s.substr(start, cur-start)) != dict.end();
        }
        if (dfs(s, dict, start, cur+1)) return true; // no cut
        if (dict.find(s.substr(start, cur-start)) != dict.end()) // cut here
            if (dfs(s, dict, cur+1, cur+1)) return true;
        return false;
    }
};
```
{% endif %}


### 动规

{% if book.java %}
```java
// Word Break
// 动规，时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // 长度为n的字符串有n+1个隔板
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true; // 空字符串
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Word Break
// 动规，时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        // 长度为n的字符串有n+1个隔板
        vector<bool> f(s.size() + 1, false);
        f[0] = true; // 空字符串
        for (int i = 1; i <= s.size(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (f[j] && dict.find(s.substr(j, i - j)) != dict.end()) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.size()];
    }
};
```
{% endif %}


### 相关题目

* [Word Break II](word-break-ii.md)

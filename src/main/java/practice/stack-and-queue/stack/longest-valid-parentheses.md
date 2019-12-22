## Longest Valid Parentheses


### 描述

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

For `"(()"`, the longest valid parentheses substring is `"()"`, which has length = 2.

Another example is `")()())"`, where the longest valid parentheses substring is `"()()"`, which has length = 4.


### 分析

无


### 使用栈

{% if book.java %}
```java
// Longest Valid Parenthese
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public int longestValidParentheses(String s) {
        // the position of the last ')'
        int maxLen = 0, last = -1;
        // keep track of the positions of non-matching '('s
        Stack<Integer> lefts = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) =='(') {
                lefts.push(i);
            } else {
                if (lefts.empty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.empty()) {
                        maxLen = Math.max(maxLen, i-last);
                    } else {
                        maxLen = Math.max(maxLen, i-lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Longest Valid Parenthese
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    int longestValidParentheses(const string& s) {
        int max_len = 0, last = -1; // the position of the last ')'
        stack<int> lefts;  // keep track of the positions of non-matching '('s

        for (int i = 0; i < s.size(); ++i) {
            if (s[i] =='(') {
                lefts.push(i);
            } else {
                if (lefts.empty()) {
                    // no matching left
                    last = i;
                } else {
                    // find a matching pair
                    lefts.pop();
                    if (lefts.empty()) {
                        max_len = max(max_len, i-last);
                    } else {
                        max_len = max(max_len, i-lefts.top());
                    }
                }
            }
        }
        return max_len;
    }
};
```
{% endif %}


### Dynamic Programming, One Pass

{% codesnippet "./code/longest-valid-parentheses-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 两遍扫描

{% codesnippet "./code/longest-valid-parentheses-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目

* [Valid Parentheses](valid-parentheses.md)
* [Generate Parentheses](generate-parentheses.md)

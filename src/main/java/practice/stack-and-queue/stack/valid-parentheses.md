## Valid Parentheses


### 描述

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.


### 分析

无


### 代码

{% if book.java %}
```java
// Valid Parentheses
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public boolean isValid(String s) {
        final String left = "([{";
        final String right = ")]}";
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (left.indexOf(c) != -1) {
                stk.push (c);
            } else {
                if (!stk.isEmpty() &&
                        stk.peek() == left.charAt(right.indexOf(c)))
                    stk.pop ();
                else
                    return false;
            }
        }
        return stk.empty();
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Valid Parentheses
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    bool isValid (string const& s) {
        string left = "([{";
        string right = ")]}";
        stack<char> stk;

        for (auto c : s) {
            if (left.find(c) != string::npos) {
                stk.push (c);
            } else {
                if (stk.empty () || stk.top () != left[right.find (c)])
                    return false;
                else
                    stk.pop ();
            }
        }
        return stk.empty();
    }
};
```
{% endif %}


### 相关题目


* [Generate Parentheses](generate-parentheses.md)
* [Longest Valid Parentheses](longest-valid-parentheses.md)

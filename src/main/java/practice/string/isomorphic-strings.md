## Isomorphic Strings

### 描述

Given two strings `s` and `t`, determine if they are isomorphic.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,

Given `"egg"`, `"add"`, return true.

Given `"foo"`, `"bar"`, return false.

Given `"paper"`, `"title"`, return true.

**Note**:

You may assume both `s` and `t` have the same length.


### 分析

用两个HashMap维护字符的映射关系，时间复杂度`O(n)`，空间复杂度`O(n)`。


### 代码

{% if book.java %}
```java
// Isomorphic Strings
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        final Map<Character,Character> map1 = new HashMap<>();
        final Map<Character,Character> map2 = new HashMap<>();
        
        for (int  i = 0; i < s.length(); ++i) {
            final char c1 = s.charAt(i);
            final char c2 = t.charAt(i);
            
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2, c1);
            }
        }
        return true;
    }
}
```
{% endif %}


### 相关题目

* [Word Pattern](word-pattern.md)

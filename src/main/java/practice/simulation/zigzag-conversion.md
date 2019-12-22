## ZigZag Conversion


### 描述

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```cpp
string convert(string text, int nRows);
```

`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.


### 分析

要找到数学规律。真正面试中，不大可能出这种问题。

n=4:

```
P     I     N
A   L S   I G
Y A   H R
P     I
```

n=5:

```
P       H
A     S I
Y   I   R
P L     I  G
A       N
```

所以，对于每一层垂直元素的坐标 `(i,j)= (j+1 )*n +i`；对于每两层垂直元素之间的插入元素（斜对角元素），`(i,j)= (j+1)*n -i`


### 代码

{% if book.java %}
```java
// ZigZag Conversion
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) return s;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0, index = i; index < s.length();
                 j++, index = (2 * numRows - 2) * j + i) {
                result.append(s.charAt(index));  // 垂直元素
                if (i == 0 || i == numRows - 1) continue;   // 斜对角元素
                if (index + (numRows - i - 1) * 2 < s.length())
                    result.append(s.charAt(index + (numRows - i - 1) * 2));
            }
        }
        return result.toString();
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// LeetCode, ZigZag Conversion
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    string convert(string s, int nRows) {
        if (nRows <= 1 || s.size() <= 1) return s;
        string result;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0, index = i; index < s.size();
                    j++, index = (2 * nRows - 2) * j + i) {
                result.append(1, s[index]);  // 垂直元素
                if (i == 0 || i == nRows - 1) continue;   // 斜对角元素
                if (index + (nRows - i - 1) * 2 < s.size())
                    result.append(1, s[index + (nRows - i - 1) * 2]);
            }
        }
        return result;
    }
};
```
{% endif %}

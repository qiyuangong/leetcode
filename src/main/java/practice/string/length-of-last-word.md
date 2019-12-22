## Length of Last Word


### 描述

Given a string s consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given `s = "Hello World"`,
return 5.


### 分析

模拟。先从右到左找到第一个字母，然后从右到左找到第一个非字母，二者的距离就是最后一个word的长度。


### 代码

{% codesnippet "./code/length-of-last-word."+book.suffix, language=book.suffix %}{% endcodesnippet %}

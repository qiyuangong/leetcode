## Maximum Product of Word Lengths


### 描述

Given a string array `words`, find the maximum value of `length(word[i]) * length(word[j])` where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

**Example 1**:

Given `["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]`

Return `16`

The two words can be `"abcw"`, `"xtfn"`.

**Example 2**:

Given `["a", "ab", "abc", "d", "cd", "bcd", "abcd"]`

Return 4

The two words can be `"ab"`, `"cd"`.

**Example 3**:

Given `["a", "aa", "aaa", "aaaa"]`

Return 0

No such pair of words.


### 分析

由于只有26个小写字母，所以，我们可以为数组中的每个`word`开辟一个长为26的布尔数组作为哈希表，然后用一个两重for循环，两两比较，如果不存在公共的字母，则计算二者的长度的乘积，取最大作为最终结果。时间复杂度`O(26n^2)`，空间复杂度`O(26n)`。

上面的方法可以进一步优化，即长度为26的布尔数组，小于32位，可以编码为一个整数，这样两个整数按位与，如果结果为1，说明存在公共字母，如果结果为0，说明不存在公共字母。时间复杂度`O(n^2)`，空间复杂度`O(n)`。


### 解法1

{% if book.java %}
{% codesnippet "./code/maximum-product-of-word-lengths-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

### 解法2

{% if book.java %}
{% codesnippet "./code/maximum-product-of-word-lengths-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

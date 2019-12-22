## Repeated DNA Sequences

### 描述

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = `"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"`,

Return:

`["AAAAACCCCC", "CCCCCAAAAA"]`.


### 分析

首先能想到一个简单直接的方法，用一个长度为10的窗口，从左到右扫描，放入 HashMap，并把计数器增一。最后，把 HashMap 中所有计数器大于1的字符串输出来。时间复杂度 `O(n)`, 由于HashMap中存储了所有长度为10的子串，所以空间复杂度`O(10n)`。

由于字符串中只存在 A, C, G, T 四种字符，我们可以把每个字符映射为2个bit:

```
A -> 00
C -> 01
G -> 10
T -> 11
```

每个长度为10的字符串，可以映射为 20 bits, 小于32位，因此可以把这个字符串映射到一个整数。这个方法时间复杂度依旧是`O(n)`，但空间复杂度下降到了`O(n)`。


### 解法1 简单粗暴

{% if book.java %}
```java
// Repeated DNA Sequences
// Time Complexity: O(n), Space Complexity: O(10n)
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;

        final Map<String, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length() - 9; ++i) {
            final String key = s.substring(i, i + 10);
            int value = counter.getOrDefault(key, 0);
            counter.put(key, value + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
```
{% endif %}


### 解法2 完美哈希

{% if book.java %}
```java
// Repeated DNA Sequences
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() < LEN) return result;

        final Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 0);
        charMap.put('C', 1);
        charMap.put('G', 2);
        charMap.put('T', 3);

        final Map<Integer, Character> intMap = new HashMap<>();
        intMap.put(0, 'A');
        intMap.put(1, 'C');
        intMap.put(2, 'G');
        intMap.put(3, 'T');

        final Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length() - LEN + 1; ++i) {
            final String key = s.substring(i, i + 10);
            final int hashValue = strToInt(key, charMap);
            counter.put(hashValue, counter.getOrDefault(hashValue, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(intToStr(entry.getKey(), intMap));
            }
        }
        return result;
    }

    // perfect hash, no collisions
    private static int strToInt(String s, Map<Character, Integer> charMap) {
        assert s.length() == LEN;
        int x = 0;
        for (int i = 0; i < LEN; ++i) {
            final char ch = s.charAt(i);
            x = (x << 2) + charMap.get(ch);
        }
        return x;
    }
    private String intToStr(int x, Map<Integer, Character> intMap) {
        final StringBuilder sb = new StringBuilder();

        while (x > 0) {
            final char ch = intMap.get(x & 3);
            sb.append(ch);
            x >>= 2;
        }
        while (sb.length() < LEN) sb.append(intMap.get(0));
        return sb.reverse().toString();
    }
    private static final int LEN = 10;
}
```
{% endif %}

## Longest Palindromic Substring


### 描述

Given a string `S`, find the longest palindromic substring in `S`. You may assume that the maximum length of `S` is 1000, and there exists one unique longest palindromic substring.


### 分析

最长回文子串，非常经典的题。

思路一：暴力枚举，以每个元素为中间元素，同时从左右出发，复杂度`O(n^2)`。

思路二：记忆化搜索，复杂度`O(n^2)`。设`f[i][j]` 表示[i,j]之间的最长回文子串，递推方程如下：

```
f[i][j] = if (i == j) S[i]
          if (S[i] == S[j] && f[i+1][j-1] == S[i+1][j-1]) S[i][j]
          else max(f[i+1][j-1], f[i][j-1], f[i+1][j])
```

思路三：动规，复杂度`O(n^2)`。设状态为`f(i,j)`，表示区间[i,j]是否为回文串，则状态转移方程为

$$
f(i,j)=\begin{cases}
true & ,i=j\\
S[i]=S[j] & , j = i + 1 \\
S[i]=S[j] \text{ and } f(i+1, j-1) & , j > i + 1
\end{cases}
$$

思路四：Manacher’s Algorithm, 复杂度`O(n)`。详细解释见 <http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html>。


### 备忘录法

{% if book.java %}
```java
// Longest Palindromic Substring
// 备忘录法，会超时
// 时间复杂度O(n^2)，空间复杂度O(n^2)
public class Solution {
    private final HashMap<Pair, String> cache = new HashMap<>();
    
    public String longestPalindrome(final String s) {
        cache.clear();
        return cachedLongestPalindrome(s, 0, s.length() - 1);
    }

    String longestPalindrome(final String s, int i, int j) {
        final int length = j - i + 1;
        if (length < 2) return s.substring(i, j + 1);

        final String s1 = cachedLongestPalindrome(s, i + 1, j - 1);

        if (s1.length() == length - 2 && s.charAt(i + 1) == s.charAt(j - 1))
            return s.substring(i, j + 1);

        final String s2 = cachedLongestPalindrome(s, i + 1, j);
        final String s3 = cachedLongestPalindrome(s, i, j - 1);

        // return max(s1, s2, s3)
        if (s1.length() > s2.length()) return s1.length() > s3.length() ? s1 : s3;
        else return s2.length() > s3.length() ? s2 : s3;
    }

    String cachedLongestPalindrome(final String s, int i, int j) {
        final Pair key = new Pair(i, j);
        
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            final String result = longestPalindrome(s, i, j);
            cache.put(key, result);
            return result;
        }
    }
    
    // immutable
    static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (this.hashCode() != other.hashCode()) return false;
            if (!(other instanceof Pair)) return false;

            final Pair o = (Pair) other;
            return this.x == o.x && this.y == o.y;
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Longest Palindromic Substring
// 备忘录法，会超时
// 时间复杂度O(n^2)，空间复杂度O(n^2)
namespace std {
template<>
struct hash<pair<int, int>> {
    size_t operator()(pair<int, int> const& p) const {
        return p.first * 31 + p.second;
    }
};
}

class Solution {
public:
    string longestPalindrome(string const& s) {
        cache.clear();
        return cachedLongestPalindrome(s, 0, s.length() - 1);
    }

private:
    unordered_map<pair<int, int>, string> cache;

    string longestPalindrome(string const& s, int i, int j) {
        const int length = j - i + 1;
        if (length < 2) return s.substr(i, length);

        const string& s1 = cachedLongestPalindrome(s, i + 1, j - 1);

        if (s1.length() == length - 2 && s[i + 1] == s[j - 1])
            return s.substr(i, length);

        const string& s2 = cachedLongestPalindrome(s, i + 1, j);
        const string& s3 = cachedLongestPalindrome(s, i, j - 1);

        // return max(s1, s2, s3)
        if (s1.length() > s2.length()) return s1.length() > s3.length() ? s1 : s3;
        else return s2.length() > s3.length() ? s2 : s3;
    }

    string cachedLongestPalindrome(string const& s, int i, int j) {
        auto key = make_pair(i, j);
        auto pos = cache.find(key);

        if (pos != cache.end()) return pos->second;
        else return cache[key] = longestPalindrome(s, i, j);
    }
};
```
{% endif %}


### 动规

{% codesnippet "./code/longest-palindromic-substring-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### Manacher’s Algorithm

{% codesnippet "./code/longest-palindromic-substring-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}

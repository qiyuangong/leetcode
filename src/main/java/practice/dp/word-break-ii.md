## Word Break II


### 描述

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given 

s = `"catsanddog"`,

dict = `["cat", "cats", "and", "sand", "dog"]`.

A solution is `["cats and dog", "cat sand dog"]`.


### 分析

在上一题的基础上，要返回解本身。


### 代码

{% if book.java %}
```java
// Word Break II
// 动规，时间复杂度O(n^2)，空间复杂度O(n^2)
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // 长度为n的字符串有n+1个隔板
        boolean[] f = new boolean[s.length() + 1];
        // prev[i][j]为true，表示s[j, i)是一个合法单词，可以从j处切开
        // 第一行未用
        boolean[][] prev = new boolean[s.length() + 1][s.length()];
        f[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    prev[i][j] = true;
                }
            }
        }
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        gen_path(s, prev, s.length(), path, result);
        return result;

    }
    // DFS遍历树，生成路径
    private static void gen_path(String s, boolean[][] prev,
                  int cur, List<String> path, List<String> result) {
        if (cur == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; --i) 
                sb.append(path.get(i)).append(' ');
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
        }
        for (int i = 0; i < s.length(); ++i) {
            if (prev[cur][i]) {
                path.add(s.substring(i, cur));
                gen_path(s, prev, i, path, result);
                path.remove(path.size()-1);
            }
        }
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Word Break II
// 动规，时间复杂度O(n^2)，空间复杂度O(n^2)
class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        // 长度为n的字符串有n+1个隔板
        vector<bool> f(s.length() + 1, false);
        // prev[i][j]为true，表示s[j, i)是一个合法单词，可以从j处切开
        // 第一行未用
        vector<vector<bool> > prev(s.length() + 1, vector<bool>(s.length()));
        f[0] = true;
        for (size_t i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (f[j] && dict.find(s.substr(j, i - j)) != dict.end()) {
                    f[i] = true;
                    prev[i][j] = true;
                }
            }
        }
        vector<string> result;
        vector<string> path;
        gen_path(s, prev, s.length(), path, result);
        return result;

    }
private:
    // DFS遍历树，生成路径
    void gen_path(const string &s, const vector<vector<bool> > &prev,
            int cur, vector<string> &path, vector<string> &result) {
        if (cur == 0) {
            string tmp;
            for (auto iter = path.crbegin(); iter != path.crend(); ++iter)
                tmp += *iter + " ";
            tmp.erase(tmp.end() - 1);
            result.push_back(tmp);
        }
        for (size_t i = 0; i < s.size(); ++i) {
            if (prev[cur][i]) {
                path.push_back(s.substr(i, cur - i));
                gen_path(s, prev, i, path, result);
                path.pop_back();
            }
        }
    }
};
```
{% endif %}


### 相关题目

* [Word Break](word-break.md)

## Anagrams


### 描述

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.


### 分析

Anagram（回文构词法）是指打乱字母顺序从而得到新的单词，比如 `"dormitory"` 打乱字母顺序会变成 `"dirty room"` ，`"tea"` 会变成`"eat"`。

回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。因此，将几个单词按照字母顺序排序后，若它们相等，则它们属于同一组 anagrams 。


### 代码

{% if book.java %}
```java
// Anagrams
// 时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final HashMap<String, ArrayList<String>> group = new HashMap<>();
        for (final String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);

            final String key = new String(tmp);
            if (!group.containsKey(key)) {
                group.put(key, new ArrayList<>());
            }
            group.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : group.entrySet()) {
            final ArrayList<String> list = entry.getValue();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Anagrams
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string> > group;
        for (const auto &s : strs) {
            string key = s;
            sort(key.begin(), key.end());
            group[key].push_back(s);
        }

        vector<vector<string>> result;
        for (auto iter = group.cbegin(); iter != group.cend(); iter++) {
            auto v = iter->second;
            sort(v.begin(), v.end());
            result.push_back(v);
        }
        return result;
    }
};
```
{% endif %}

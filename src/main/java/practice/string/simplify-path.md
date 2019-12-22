## Simplify Path


### 描述

Given an absolute path for a file (Unix-style), simplify it.

For example, 

* path = `"/home/"`, => `"/home"` 
* path = `"/a/./b/../../c/"`, => `"/c"`

Corner Cases:

* Did you consider the case where path = `"/../"`? 

    In this case, you should return `"/"`.

*  Another corner case is the path might contain multiple slashes `'/'` together, such as `"/home//foo/"`.

    In this case, you should ignore redundant slashes and return `"/home/foo"`.


### 分析

很有实际价值的题目。


### 代码

{% if book.java %}
```java
import java.util.*;

// Simplify Path
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public String simplifyPath(String path) {
        Stack<String> dirs = new Stack<>();

        for (int i = 0; i < path.length();) {
            ++i;

            int j = path.indexOf('/', i);
            if (j < 0) j = path.length();
            final String dir = path.substring(i, j);

            // 当有连续 '///'时，dir 为空
            if (!dir.isEmpty() && !dir.equals(".")) {
                if (dir.equals("..")) {
                    if (!dirs.isEmpty())
                        dirs.pop();
                } else {
                    dirs.push(dir);
                }
            }

            i = j;
        }

        StringBuilder result = new StringBuilder();
        if (dirs.isEmpty()) {
            result.append('/');
        } else {
            for (final String dir : dirs) {
                result.append('/').append(dir);
            }
        }
        return result.toString();
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Simplify Path
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    string simplifyPath(const string& path) {
        vector<string> dirs; // 当做栈

        for (auto i = path.begin(); i != path.end();) {
            ++i;

            auto j = find(i, path.end(), '/');
            auto dir = string(i, j);

            if (!dir.empty() && dir != ".") {// 当有连续 '///'时，dir 为空
                if (dir == "..") {
                    if (!dirs.empty())
                        dirs.pop_back();
                } else
                    dirs.push_back(dir);
            }

            i = j;
        }

        stringstream out;
        if (dirs.empty()) {
            out << "/";
        } else {
            for (auto dir : dirs)
                out << '/' << dir;
        }

        return out.str();
    }
};
```
{% endif %}

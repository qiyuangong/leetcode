// Subsets II
// 增量构造法，版本2，时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &nums) {
        vector<vector<int> > result;
        sort(nums.begin(), nums.end()); // 必须排序

        unordered_map<int, int> count_map; // 记录每个元素的出现次数
        for (int i : nums) {
            if (count_map.find(i) != count_map.end())
                count_map[i]++;
            else
                count_map[i] = 1;
        }

        // 将map里的pair拷贝到一个vector里
        vector<pair<int, int> > elems;
        for (auto p : count_map) {
            elems.push_back(p);
        }
        sort(elems.begin(), elems.end());
        vector<int> path; // 中间结果

        dfs(elems, 0, path, result);
        return result;
    }

private:
    static void dfs(const vector<pair<int, int> > &elems,
            size_t step, vector<int> &path, vector<vector<int> > &result) {
        if (step == elems.size()) {
            result.push_back(path);
            return;
        }

        for (int i = 0; i <= elems[step].second; i++) {
            for (int j = 0; j < i; ++j) {
                path.push_back(elems[step].first);
            }
            dfs(elems, step + 1, path, result);
            for (int j = 0; j < i; ++j) {
                path.pop_back();
            }
        }
    }
};
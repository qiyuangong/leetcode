// Subsets II
// 位向量法，时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &nums) {
        vector<vector<int> > result; // 必须排序
        sort(nums.begin(), nums.end());
        // 记录每个元素的出现次数
        unordered_map<int, int> count_map;
        for (int i : nums) {
            if (count_map.find(i) != count_map.end())
                count_map[i]++;
            else
                count_map[i] = 1;
        }
        // 将map里的pair拷贝到一个vector里
        vector<pair<int, int> > counters;
        for (auto p : count_map) {
            counters.push_back(p);
        }
        sort(counters.begin(), counters.end());

        // 每个元素选择了多少个
        unordered_map<int, int> selected;
        for (auto p : counters) {
            selected[p.first] = 0;
        }

        dfs(nums, counters, selected, 0, result);
        return result;
    }

private:
    static void dfs(const vector<int> &S, const vector<pair<int, int> >& counters,
            unordered_map<int, int>& selected, size_t step, vector<vector<int> > &result) {
        if (step == counters.size()) {
            vector<int> subset;
            for (auto p : counters) {
                for (int i = 0; i < selected[p.first]; ++i) {
                    subset.push_back(p.first);
                }
            }
            result.push_back(subset);
            return;
        }

        for (int i = 0; i <= counters[step].second; i++) {
            selected[counters[step].first] = i;
            dfs(S, counters, selected, step + 1, result);
        }
    }
};
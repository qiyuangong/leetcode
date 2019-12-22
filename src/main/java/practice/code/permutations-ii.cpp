// Permutations II
// 深搜，时间复杂度O(n!)，空间复杂度O(n)
class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        unordered_map<int, int> count_map; // 记录每个元素的出现次数
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
        
        vector<vector<int>> result; // 最终结果
        vector<int> p;  // 中间结果

        n = nums.size();
        permute(counters, selected, p, result);
        return result;
    }

private:
    size_t n;
    typedef vector<pair<int, int> >::const_iterator Iter;

    void permute(const vector<pair<int, int> > &counters,
            unordered_map<int, int> &selected, 
            vector<int> &p, vector<vector<int> > &result) {
        if (n == p.size()) {  // 收敛条件
            result.push_back(p);
        }

        // 扩展状态
        for (auto counter : counters) {
            if (selected[counter.first] < counter.second) {
                p.push_back(counter.first);
                selected[counter.first]++;
                permute(counters, selected, p, result);
                p.pop_back(); // 撤销动作，返回上一层
                selected[counter.first]--;
            }
        }
    }
};
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
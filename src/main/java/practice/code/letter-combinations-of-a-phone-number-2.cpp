// Letter Combinations of a Phone Number
// 时间复杂度O(3^n)，空间复杂度O(1)
class Solution {
public:
    const vector<string> keyboard { " ", "", "abc", "def", // '0','1','2',...
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    vector<string> letterCombinations (const string &digits) {
        if (digits.empty()) return vector<string>();
        vector<string> result(1, "");
        for (auto d : digits) {
            const size_t n = result.size();
            const size_t m = keyboard[d - '0'].size();

            // resize to n * m
            for (size_t i = 1; i < m; ++i) {
                for (size_t j = 0; j < n; ++j) {
                    result.push_back(result[j]);
                }
            }

            for (size_t i = 0; i < result.size(); ++i) {
                result[i] = result[i] + keyboard[d - '0'][i/n];
            }
        }
        return result;
    }
};
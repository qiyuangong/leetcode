// Longest Consecutive Sequence
// Time Complexity: O(n)，Space Complexity: O(n)
class Solution {
public:
    int longestConsecutive(const vector<int> &nums) {
        unordered_set<int> my_set;
        for (auto i : nums) my_set.insert(i);

        int longest = 0;
        for (auto i : nums) {
            int length = 1;
            for (int j = i - 1; my_set.find(j) != my_set.end(); --j) {
                my_set.erase(j);
                ++length;
            }
            for (int j = i + 1; my_set.find(j) != my_set.end(); ++j) {
                my_set.erase(j);
                ++length;
            }
            longest = max(longest, length);
        }
        return longest;
    }
};
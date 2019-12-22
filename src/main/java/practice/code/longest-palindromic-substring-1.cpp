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
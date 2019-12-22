// Wildcard Matching
// 递归版，会超时，用于帮助理解题意
// 时间复杂度O(n!*m!)，空间复杂度O(n)
class Solution {
public:
    bool isMatch(const string& s, const string& p) {
        return isMatch(s.c_str(), p.c_str());
    }
private:
    bool isMatch(const char *s, const char *p) {
        if (*p == '\0' || *s == '\0') return *p == *s;
        else if (*p == '*') {
            while (*p == '*') ++p;  //skip continuous '*'
            if (*p == '\0') return true;
            while (*s != '\0' && !isMatch(s, p)) ++s;

            return *s != '\0';
        }
        else if (*p == *s || *p == '?') return isMatch(++s, ++p);
        else return false;
    }
};
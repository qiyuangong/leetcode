// Regular Expression Matching
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
public:
    bool isMatch(const string& s, const string& p) {
        return isMatch(s.c_str(), p.c_str());
    }
private:
    bool matchFirst(const char *s, const char *p) {
        return *p == *s || (*p == '.' && *s != '\0');
    }

    bool isMatch(const char *s, const char *p) {
        if (*p == '\0') return *s == '\0';    //empty

        // next char is not '*', then must match current character
        if (*(p + 1) != '*') {
            if (matchFirst(s, p)) return isMatch(s + 1, p + 1);
            else return false;
        } else { // next char is '*'
            if (isMatch(s, p + 2)) return true;    // try the length of 0
            while ( matchFirst(s, p) )       // try all possible lengths 
                if (isMatch(++s, p + 2)) return true;
            return false;
        }
    }
};


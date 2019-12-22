// Permutation Sequence
// 康托编码
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public String getPermutation(int n, int k) {
        string s(n, '0');
        string result;
        for (int i = 0; i < n; ++i)
            s[i] += i + 1;

        return kth_permutation(s, k);
    }
private:
    int factorial(int n) {
        int result = 1;
        for (int i = 1; i < n+1; ++i)
            result *= i;
        return result;
    }

    // s 已排好序，是第一个排列
    string kth_permutation(string &s, int k) {
        const int n = s.size();
        string result;

        int base = factorial(n - 1);
        --k;  // 康托编码从0开始

        for (int i = n - 1; i > 0; k %= base, base /= i, --i) {
            auto a = next(s.begin(), k / base);
            result.push_back(*a);
            s.erase(a);
        }

        result.push_back(s[0]); // 最后一个
        return result;
    }
};
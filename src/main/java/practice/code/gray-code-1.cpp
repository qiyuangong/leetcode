// Gray Code
// 数学公式，时间复杂度O(2^n)，空间复杂度O(1)
class Solution {
public:
    vector<int> grayCode(int n) {
        const int size = 1 << n;  // 2^n
        vector<int> result;
        result.reserve(size);

        for (int i = 0; i < size; ++i)
            result.push_back(binary_to_gray(i));
        return result;
    }
private:
    static int binary_to_gray(int n) {
        return n ^ (n >> 1);
    }
};
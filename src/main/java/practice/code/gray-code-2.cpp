// Gray Code
// reflect-and-prefix method
// 时间复杂度O(2^n)，空间复杂度O(1)
class Solution {
public:
    vector<int> grayCode(int n) {
        const int size = 1 << n;
        vector<int> result;
        result.reserve(size);
        
        result.push_back(0);
        for (int i = 0; i < n; i++) {
            const int highest_bit = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) // 要反着遍历，才能对称
                result.push_back(highest_bit | result[j]);
        }
        return result;
    }
};
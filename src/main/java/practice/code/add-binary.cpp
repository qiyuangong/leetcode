// Add Binary
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    string addBinary(string a, string b) {
        string result;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry > 0) {
            int valueA = i < 0 ? 0 : a[i--] - '0';
            int valueB = j < 0 ? 0 : b[j--] - '0';
            int sum = valueA + valueB + carry;
            result.insert(result.begin(), (sum % 2) + '0');
            carry = sum / 2;
        }
        return result;
    }
};
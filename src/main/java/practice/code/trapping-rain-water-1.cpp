// Trapping Rain Water
// 思路1，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    int trap(const vector<int>& A) {
        const int n = A.size();
        int *left_peak = new int[n]();
        int *right_peak = new int[n]();

        for (int i = 1; i < n; i++) {
            left_peak[i] = max(left_peak[i - 1], A[i - 1]);
        }
        for (int i = n - 2; i >=0; --i) {
            right_peak[i] = max(right_peak[i+1], A[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int height = min(left_peak[i], right_peak[i]);
            if (height > A[i]) {
                sum += height - A[i];
            }
        }

        delete[] left_peak;
        delete[] right_peak;
        return sum;
    }
};
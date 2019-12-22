// Sort Colors
// 双指针，时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    void sortColors(vector<int>& A) {
        // 一个是red的index，一个是blue的index，两边往中间走
        int red = 0, blue = A.size() - 1;

        for (int i = 0; i < blue + 1;) {
            if (A[i] == 0)
                swap(A[i++], A[red++]);
            else if (A[i] == 2)
                swap(A[i], A[blue--]);
            else
                i++;
        }
    }
};
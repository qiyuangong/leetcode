class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int xorsum=0;
        int n= nums.size();
        for(int i=0; i<n; i++)
            xorsum = xorsum ^ nums[i];
        
        return xorsum;
    }
};

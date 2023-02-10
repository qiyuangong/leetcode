class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> answer;
        int n;
        for( int i=0; i < nums.size(); i++){
            n=nums[i];
            vector<int> temp;
            while( n>0 ){
                temp.push_back(n%10);
                n = n / 10;
            }
            for(int j= temp.size()-1; j>=0; j--){
                answer.push_back(temp[j]);
            }
        }
        return answer;
    }
};

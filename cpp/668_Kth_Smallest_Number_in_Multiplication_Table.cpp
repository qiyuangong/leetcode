class Solution {
public:
    #define ll long long int
    
    bool valid(ll x, int m, int n, int k){
        int cnt=0;
        for(int i=1;i<=m;i++){
            cnt+=n<x/i?n:x/i;
            if(x/i==0)break;
        }
        return cnt>=k;
    }
    
    int findKthNumber(int n1, int n2, int k) {
        ll l=0, r=n1*n2,ans;
        while(l<=r){
            ll m = l +(r-l)/2;
            if(valid(m,n1,n2,k)){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
};

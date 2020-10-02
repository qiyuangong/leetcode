#define pb push_back
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        int i;
        vector<string> s;
        for(i=0;i<n;i++){
            if((i+1)%15==0)s.pb("FizzBuzz");
            else if((i+1)%5==0)s.pb("Buzz");
            else if((i+1)%3==0)s.pb("Fizz");
            else s.pb(to_string(i+1));
        }
        return s;
    }
};

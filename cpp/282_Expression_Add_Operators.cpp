class Solution {
public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        if (num.size() == 0) return result;
        findSolution(num, target, result, "", 0, 0, 0, ' ');
        return result;        
    }

    //DFS algorithm
    void findSolution(const string &num, const int target,
                vector<string>& result, 
                string solution,
                int idx,
                long long val,
                long long prev,
                char preop )
    {

        if (target == val && idx == num.size()){
            result.push_back(solution);
            return;
        }
        if (idx == num.size()) return;

        string n;
        long long v=0;
        for(int i=idx; i<num.size(); i++) {
            //get rid of the number which start by "0"
            //e.g.  "05" is not the case.
            if (n=="0") return;

            n = n + num[i];
            v = v*10 + num[i]-'0';

            if (solution.size()==0){ 
                findSolution(num, target, result, n, i+1, v, 0, ' ');
            }else{
                // '+' or '-' needn't to adjust the priority
                findSolution(num, target, result, solution + '+' + n, i+1, val+v, v, '+');
                findSolution(num, target, result, solution + '-' + n, i+1, val-v, v, '-');
                if (preop=='+') {
                    findSolution(num, target, result, solution + '*' + n, i+1, (val-prev)+prev*v, prev*v, preop);
                }else if (preop=='-'){
                    findSolution(num, target, result, solution + '*' + n, i+1, (val+prev)-prev*v, prev*v, preop);
                }else {
                    findSolution(num, target, result, solution + '*' + n, i+1, val*v, v, '*');
                }
            }
        }

    }
};

// Evaluate Reverse Polish Notation
// 递归，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        if (tokens.empty()) return 0;
        int x, y;
        auto token = tokens.back();  tokens.pop_back();
        if (is_operator(token))  {
            y = evalRPN(tokens);
            x = evalRPN(tokens);
            switch(token[0]) {
                case '+' : x += y; break;
                case '-' : x -= y; break;
                case '*' : x *= y; break;
                default:   x /= y;
            }
        } else  {
            size_t i;
            x = stoi(token, &i);
        }
        return x;
    }
private:
    bool is_operator(const string &op) {
        return op.size() == 1 && string("+-*/").find(op) != string::npos;
    }
};
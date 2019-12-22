## Evaluate Reverse Polish Notation


### 描述

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are `+, -, *, /`. Each operand may be an integer or another expression.

Some examples:

```
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
```


### 分析

逆波兰表达式是典型的递归结构，所以可以用递归来求解，也可以用栈来求解。


### 递归版

{% if book.java %}
递归的写法，C++版可以AC，但Java版会爆栈`StackOverflowError`，所以Java 只能用栈来解决。
{% endif %}

{% codesnippet "./code/evaluate-reverse-polish-notation-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 迭代版

{% if book.java %}
```java
// Max Points on a Line
// 迭代，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                s.push(token);
            } else {
                int y = Integer.parseInt(s.pop());
                int x = Integer.parseInt(s.pop());
                switch (token.charAt(0)) {
                    case '+': x += y; break;
                    case '-': x -= y; break;
                    case '*': x *= y; break;
                    default: x /= y;
                }
                s.push(String.valueOf(x));
            }
        }
        return Integer.parseInt(s.peek());
    }
    private static boolean isOperator(final String op) {
        return op.length() == 1 && OPS.indexOf(op) != -1;
    }
    private static String OPS = new String("+-*/");
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Max Points on a Line
// 迭代，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        stack<string> s;
        for (auto token : tokens) {
            if (!is_operator(token)) {
                s.push(token);
            } else {
                int y = stoi(s.top());
                s.pop();
                int x = stoi(s.top());
                s.pop();
                switch(token[0]) {
                    case '+' : x += y; break;
                    case '-' : x -= y; break;
                    case '*' : x *= y; break;
                    default:   x /= y;
                }
                s.push(to_string(x));
            }
        }
        return stoi(s.top());
    }
private:
    bool is_operator(const string &op) {
        return op.size() == 1 && string("+-*/").find(op) != string::npos;
    }
};
```
{% endif %}

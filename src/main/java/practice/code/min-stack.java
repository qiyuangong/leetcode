// Min Stack
// Time Complexity: O(n), Space Complexity: O(1)
class MinStack {
    public void push(int x) {
        s.push(x);
        int minValue = minStack.isEmpty() ? x :
                Math.min(minStack.peek(), x);
        minStack.push(minValue);
    }

    public void pop() {
        s.pop();
        minStack.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
}
// Implement Queue using Stacks
class MyQueue {
    // Push element x to the back of queue.
    // Time Complexity: O(n)
    public void push(int x) {
        while (!s.isEmpty()) {
            final int e = s.pop();
            tmp.push(e);
        }
        tmp.push(x);

        while(!tmp.isEmpty()) {
            final int e = tmp.pop();
            s.push(e);
        }
    }

    // Removes the element from in front of queue.
    // Time Complexity: O(1)
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }

    private final Stack<Integer> s = new Stack<>();
    private final Stack<Integer> tmp = new Stack<>();
}
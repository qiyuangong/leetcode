// Implement Stack using Queues
class MyStack {
    // Push element x onto stack.
    // Time Complexity O(n)
    public void push(int x) {
        tmp.offer(x);
        while (!q.isEmpty()) {
            final int e = q.poll();
            tmp.offer(e);
        }
        // swap q and tmp
        Queue<Integer> temp = tmp;
        tmp = q;
        q = temp;
    }

    // Removes the element on top of the stack.
    // Time Complexity O(1)
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }

    private Queue<Integer> q = new LinkedList<>();
    private Queue<Integer> tmp = new LinkedList<>();
}
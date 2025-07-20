class MinStack {
    List<int> stack = [];
    List<int> minStack = [];

    MinStack() {}

    void push(int val) {
        stack.add(val);

        if (minStack.isEmpty) {
            minStack.add(val);
        } else if (val < minStack.last) {
            minStack.add(val);
        } else {
            minStack.add(minStack.last);
        }
    }

    void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    int top() {
        return stack.last;
    }

    int getMin() {
        return minStack.last;
    }
}
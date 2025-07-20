class MyQueue {
  List input = [];
  MyQueue() {}

  void push(int x) {
    input.add(x);
  }

  int pop() {
   return input.removeAt(0);
  }

  int peek() {
    return input.first;
  }

  bool empty() {
   return input.isEmpty;
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = MyQueue();
 * obj.push(x);
 * int param2 = obj.pop();
 * int param3 = obj.peek();
 * bool param4 = obj.empty();
 */
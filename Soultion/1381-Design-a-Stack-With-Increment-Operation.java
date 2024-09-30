class CustomStack {
    private int maxSize;
    private int[] stack;
    private int[] increments;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increments = new int[maxSize];
        this.top = -1; 
    }

    public void push(int x) {
        if (top < maxSize - 1) { 
            stack[++top] = x; 
        }
    }

    public int pop() {
        if (top == -1) {
            return -1; 
        }
        int value = stack[top] + increments[top];
        
        if (top > 0) {
            increments[top - 1] += increments[top];
        }

        
        increments[top] = 0; 
        top--;
        return value;
    }

    public void increment(int k, int val) {
        if (top >= 0) {
            increments[Math.min(k - 1, top)] += val;
        }
    }
}

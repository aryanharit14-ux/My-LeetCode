class CustomStack {
    private int[] stack;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top==maxSize-1) return;
        top++;
        stack[top] = x;
    }
    
    public int pop() {
        if(top == -1) return -1;
        int value = stack[top];
        top--;
        return value;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<=top ;i++){
            stack[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
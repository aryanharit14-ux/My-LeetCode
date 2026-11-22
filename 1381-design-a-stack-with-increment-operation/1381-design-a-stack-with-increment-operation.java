class CustomStack {
    private int[] stack;
    private int maxsize;
    private int top;

    public CustomStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[maxsize];
        top = -1;
    }
    
    public void push(int x) {
        if(top==maxsize-1) return;
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
        for(int i=0 ;i<k && i<=top;i++){
            stack[i]+= val;
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
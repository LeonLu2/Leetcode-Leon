class MyQueue {

    private static Stack<Integer> inStack;
    private static Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            inToOut();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if(outStack.isEmpty()){
            inToOut();
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        if(inStack.isEmpty() && outStack.isEmpty()) return true;
        else return false;
    }

    private void inToOut(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
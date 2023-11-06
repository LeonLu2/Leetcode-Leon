class MyStack {

    private Queue<Integer> inQueue;
    private Queue<Integer> outQueue;

    public MyStack() {
        inQueue = new LinkedList<Integer>();
        outQueue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        if(!inQueue.isEmpty()) inToOut();
        inQueue.add(x);
        if(!outQueue.isEmpty()) outToIn();
    }
    
    public int pop() {
        return inQueue.remove();
    }
    
    public int top() {
        return inQueue.peek();
    }
    
    public boolean empty() {
        return inQueue.isEmpty();
    }

    private void inToOut(){
        while(!inQueue.isEmpty()){
            outQueue.add(inQueue.remove());
        }
    }

    private void outToIn(){
        while(!outQueue.isEmpty()){
            inQueue.add(outQueue.remove());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
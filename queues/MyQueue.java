//https://leetcode.com/problems/implement-queue-using-stacks/
//This has been implemented using stack

class MyQueue {
    Stack<Integer> mstack;
    Stack<Integer> tstack;
    int front = -1;
    public MyQueue() {
        mstack = new Stack();
        tstack = new Stack();
    }

    public void push(int x) {
        if(mstack.isEmpty()) {
            front =x;
        }
        mstack.push(x);
    }

    public int pop() {
        while(!mstack.isEmpty()) {
            tstack.push(mstack.peek());
            mstack.pop();
        }
        int rval = tstack.peek();
        tstack.pop();
        while(!tstack.isEmpty()) {
            //mstack.push(tstack.peek());
            push(tstack.peek());
            tstack.pop();
        }
        return rval;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return mstack.isEmpty();
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
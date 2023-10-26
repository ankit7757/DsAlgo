
/*
It has beeen implemented using stack.
Amortized time complexity of every operation is 1.
Element from tempstack was never sent back to mstack.
mstack was used for push , tstack was used for pop
Key learning-> to return peek, we need to maintain 2 var btmstack and front. if tstack is empty btmstack is refered else front is referred.
 */
class MyQueueUsingStack2 {
    Stack<Integer> mstack;
    Stack<Integer> tstack;
    int btmstack = -1;
    int front =-1;
    public MyQueue() {
        mstack = new Stack();
        tstack = new Stack();
    }

    public void push(int x) {
        if(mstack.isEmpty()) {
         btmstack =x;
        }
        mstack.push(x);
    }

    public int pop() {
        if(tstack.isEmpty()) {
            while(!mstack.isEmpty()) {
         tstack.push(mstack.peek());
         front = mstack.peek();
         mstack.pop();
            }
        }
        int rval = tstack.peek();
        tstack.pop();
        if(!tstack.isEmpty()) {
        front = tstack.peek();
        }
        return rval;
    }

    public int peek() {
        if(tstack.isEmpty())
        {
  return btmstack;
        }
        else {
            return front;
        }
    }

    public boolean empty() {
        return mstack.isEmpty() && tstack.isEmpty();
    }
}

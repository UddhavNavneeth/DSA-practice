// Link to the question:
// https://www.interviewbit.com/problems/min-stack/

class Solution {
    public int[] stack = new int[Integer.MAX_VALUE/100];
    public Stack<Integer> minSt = new Stack<Integer>();
    public int top=-1;
    public int min=-1;
    
    public void push(int x) {
        this.top++;
        this.stack[this.top]=x;
        if (this.minSt.empty() || this.stack[minSt.peek()]>x) {
            this.minSt.push(this.top);
        }
        return;
    }

    public void pop() {
        if (this.top>=0) {
            if (this.stack[this.top]==this.stack[this.minSt.peek()]) {
                this.minSt.pop();
            }
            this.top--;
        }
    }

    public int top() {
        if (this.top>=0) {
            return this.stack[this.top];
        }else {
            return -1;
        }
    }

    public int getMin() {
        if (this.top>=0) {
            return this.stack[this.minSt.peek()];
        }else {
            return -1;
        }
    }
}
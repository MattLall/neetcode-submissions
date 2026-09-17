class MinStack {
    private Stack<Integer> orderedStack;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        orderedStack = new Stack<>();
    }

    public void push(int val) {
        // add to min stack
        stack.push(val);
        addMin(val);
    }

    public void pop() {
        // remove from min stack
        removeMin((int) stack.pop());
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) orderedStack.peek();
    }

    private void addMin(int val) {
        // System.out.println("ADDMIN" + val);
        if (orderedStack.isEmpty() || orderedStack.peek() >=val) {
            orderedStack.push(val);
            
        }

    }

    private void removeMin(int val) {
        if(orderedStack.peek()==val){
            orderedStack.pop();
        }
    }
}

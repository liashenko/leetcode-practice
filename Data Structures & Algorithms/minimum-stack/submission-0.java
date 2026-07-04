class MinStack {

    Stack<int[]> st = new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[]{val, val});
            return;
        }
        int[] top = st.peek();
        st.push(new int[]{val, Math.min(val, top[1])});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

// bruteforce: Scan the stack linearly on getMin() calls, O(N) time
// solution: Store elements in a Stack as pairs of [value, running_minimum] to retrieve the minimum in O(1) time, O(1) query time / O(N) space
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
